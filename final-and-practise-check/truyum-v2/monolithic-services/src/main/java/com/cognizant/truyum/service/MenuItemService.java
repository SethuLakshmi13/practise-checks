package com.cognizant.truyum.service;

import java.util.Set;

import com.cognizant.truyum.model.MenuItem;

public interface MenuItemService {

	public Set<MenuItem> getMenuItemListAdmin();

	public Set<MenuItem> getMenuItemListCustomer();

	public MenuItem getMenuItem(long menuItemId);

	public void modifyMenuItem(MenuItem menuItem);

}
