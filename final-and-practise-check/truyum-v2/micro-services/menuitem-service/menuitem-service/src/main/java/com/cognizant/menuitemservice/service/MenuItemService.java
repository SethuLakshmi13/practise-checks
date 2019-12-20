package com.cognizant.menuitemservice.service;

import java.util.Set;

import com.cognizant.menuitemservice.model.MenuItem;

public interface MenuItemService {

	public Set<MenuItem> getMenuItemListAdmin();

	public Set<MenuItem> getMenuItemListCustomer();

	public MenuItem getMenuItem(long menuItemId);

	public void modifyMenuItem(MenuItem menuItem);

}
