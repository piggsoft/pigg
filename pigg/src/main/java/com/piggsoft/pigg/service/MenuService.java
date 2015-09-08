package com.piggsoft.pigg.service;

import java.util.List;

import com.piggsoft.pigg.model.Menu;

public interface MenuService {

	List<Menu> searchMenuTree();

	List<Menu> searchMenu();

}
