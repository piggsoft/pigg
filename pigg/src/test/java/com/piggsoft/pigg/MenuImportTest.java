package com.piggsoft.pigg;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.util.StreamUtils;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.piggsoft.pigg.dao.MenuMapper;
import com.piggsoft.pigg.model.Menu;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml" })
@WebAppConfiguration
public class MenuImportTest {
	
	@Autowired
	private MenuMapper menuMapper;
	
	@Value("classpath:menu.json")
	private Resource resource;
	
	@Test
	public void testSave() throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper om = new ObjectMapper();
		String json = StreamUtils.copyToString(resource.getInputStream(), Charset.forName("UTF-8"));
		List<Menu> menus = om.readValue(json, om.getTypeFactory().constructCollectionType(List.class, Menu.class));
		for (Menu menu : menus) {
			save(menu);
			if (menu.getMenus() == null || menu.getMenus().isEmpty()) {
				continue;
			}
			for (Menu child : menu.getMenus()) {
				child.setParentMenuId(menu.getMenuId());
				save(child);
			}
		}
	}
	
	private int save(Menu menu) {
		menu.setMenuId(null);
		return menuMapper.insert(menu);
	}
}
