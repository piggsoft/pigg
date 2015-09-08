package com.piggsoft.pigg;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.piggsoft.pigg.model.Menu;
import com.piggsoft.pigg.model.PageData;
import com.piggsoft.pigg.service.MenuService;
import com.piggsoft.pigg.utils.StringUnicodeSerializer;

@Controller
@RequestMapping("/menu")
public class MenuController {
	
	@Autowired
	private MenuService menuService;
	
	@RequestMapping
	public String index() {
		return "menu/index";
	}
	
	@RequestMapping("/search")
	@ResponseBody
	public PageData search(int page, int rows) {
		PageHelper.startPage(page, rows);
		Page<Menu> pages = (Page<Menu>)menuService.searchMenu();
		PageData pageData = new PageData();
		pageData.setRows(pages);
		pageData.setTotal(pages.getTotal());
		return pageData;
	}
	
	@RequestMapping("/search/script")
	@ResponseBody
	public String searchScript() throws JsonProcessingException {
		List<Menu> menus = menuService.searchMenuTree();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("menus", menus);
		ObjectMapper objectMapper = new ObjectMapper();
		SimpleModule module = new SimpleModule();  
	    module.addSerializer(String.class, new StringUnicodeSerializer()); 
	    objectMapper.registerModule(module);  
		StringBuilder sb = new StringBuilder();
		sb.append("var _menus = ");
		sb.append(objectMapper.writeValueAsString(map));
		return sb.toString();
	}

	public void setMenuService(MenuService menuService) {
		this.menuService = menuService;
	}
	
	
}
