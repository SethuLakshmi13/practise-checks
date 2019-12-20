package com.cognizant.truyum.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.cognizant.truyum.model.MenuItem;

@Repository

public class MenuItemDaoCollectionImpl implements MenuItemDao {

	private static List<MenuItem> menuItemList;
	private static final Logger LOGGER = LoggerFactory.getLogger( MenuItemDaoCollectionImpl.class);
	
	public MenuItemDaoCollectionImpl() {
		LOGGER.info("Start");
		ApplicationContext context=new ClassPathXmlApplicationContext("truyum.xml");
		menuItemList=(ArrayList)context.getBean("menuItemList");
		LOGGER.debug(menuItemList.toString());
		LOGGER.info("End");
	}

	public List<MenuItem> getMenuItemListAdmin() {
		LOGGER.info("Start");
		LOGGER.info("End");
		return menuItemList;
	}

	public List<MenuItem> getMenuItemListCustomer() {
		LOGGER.info("Start");
		List<MenuItem> filteredMenuItemList = new ArrayList<MenuItem>();
		for (MenuItem item : menuItemList) {
			int dateCompare = item.getDateOfLaunch().compareTo(new Date());
			//if (item.isActive() == true&& (dateCompare == 0 || dateCompare < 0)) {
				filteredMenuItemList.add(item);
			//}
		}
		LOGGER.info("End");
		return filteredMenuItemList;
	}

	public void modifyMenuItem(MenuItem menuItem){
		LOGGER.info("Start");
		for (int i = 0; i < menuItemList.size(); i++) {
			if (menuItem.getId() == menuItemList.get(i).getId()) {
				menuItemList.set(i, menuItem);
				break;
			}
		}
		LOGGER.info("End");
	}

	public MenuItem getMenuItem(long menuItemId) {
		LOGGER.info("Start");
		MenuItem menuItem = null;
		for (int i = 0; i < menuItemList.size(); i++) {
			if (menuItemId == menuItemList.get(i).getId()) {
				menuItem = menuItemList.get(i);
				break;
			}
		}
		LOGGER.info("End");
		return menuItem;
	}

}
