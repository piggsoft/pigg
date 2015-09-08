package com.piggsoft.pigg.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.piggsoft.pigg.dao.MenuMapper;
import com.piggsoft.pigg.model.Menu;
import com.piggsoft.pigg.model.MenuExample;
import com.piggsoft.pigg.service.MenuService;

@Service("menuService")
public class MenuServiceImpl implements MenuService {
	
	@Autowired
	private MenuMapper menuMapper;
	
	@Override
	public List<Menu> searchMenuTree() {
		MenuExample example = new MenuExample();
		example.createCriteria().andParentMenuIdIsNull();
		return menuMapper.selectByExampleFetch(example);
	}
	
	@Override
	public List<Menu> searchMenu() {
		return menuMapper.selectByExample(new MenuExample());
	}

	public void setMenuMapper(MenuMapper menuMapper) {
		this.menuMapper = menuMapper;
	}
}
