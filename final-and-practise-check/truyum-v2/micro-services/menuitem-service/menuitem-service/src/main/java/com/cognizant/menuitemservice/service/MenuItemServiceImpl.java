package com.cognizant.menuitemservice.service;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.menuitemservice.model.MenuItem;
import com.cognizant.menuitemservice.repository.MenuItemRepository;

@Service
public class MenuItemServiceImpl implements MenuItemService {

	private static final Logger LOGGER = LoggerFactory.getLogger(MenuItemServiceImpl.class);

	@Autowired
	MenuItemRepository menuItemRepository;

	@Override
	public Set<MenuItem> getMenuItemListCustomer() {
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
	public Set<MenuItem> getMenuItemListAdmin() {
		LOGGER.info("Start");
		LOGGER.info("End");
		return menuItemRepository.getAllMenuItemListAdmin();
	}

	@Override
	public void modifyMenuItem(MenuItem menuItem) {
		LOGGER.info("Start");
		menuItemRepository.save(menuItem);
		LOGGER.info("End");

	}

}
