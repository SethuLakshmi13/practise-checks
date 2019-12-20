package com.cognizant.truyum.service;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.truyum.dao.MenuItemDao;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.repository.MenuItemRepository;
@Service
public class MenuItemServiceImpl implements MenuItemService {
	
	private static final Logger LOGGER=LoggerFactory.getLogger(MenuItemServiceImpl.class);
	
	@Autowired
	MenuItemDao menuItemDao;
	
	@Autowired
	MenuItemRepository menuItemRepository;

	@Override
	public Set<MenuItem> getMenuItemListCustomer(){
		LOGGER.info("Start");
		LOGGER.info("End");
		return menuItemRepository.getAllMenuItemListCustomer();
	}

	@Override
	public MenuItem getMenuItem(long menuItemId) {
		LOGGER.info("Start");
		LOGGER.info("End");
		return menuItemRepository.findMenuItemById(menuItemId);
	}

	@Override
	public Set<MenuItem> getMenuItemListAdmin()  {
		LOGGER.info("Start");
		LOGGER.info("End");
		return menuItemRepository.getAllMenuItemListAdmin();
	}

	@Override
	public void modifyMenuItem(MenuItem menuItem)  {
		LOGGER.info("Start");
		menuItemRepository.save(menuItem);
		LOGGER.info("End");
		
	}

}
