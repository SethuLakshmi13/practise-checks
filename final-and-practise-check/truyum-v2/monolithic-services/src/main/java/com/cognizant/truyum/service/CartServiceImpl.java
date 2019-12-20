package com.cognizant.truyum.service;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.truyum.dao.CartDao;
import com.cognizant.truyum.exception.CartEmptyException;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.model.Users;
import com.cognizant.truyum.repository.MenuItemRepository;
import com.cognizant.truyum.repository.UserRepository;

@Service
public class CartServiceImpl implements CartService {

	private static final Logger LOGGER = LoggerFactory.getLogger(CartServiceImpl.class);

	@Autowired
	UserRepository userRepository;
	@Autowired
	MenuItemRepository menuItemRepository;

	@Override
	public void addCartItem(String user, long menuItemId) {
		LOGGER.info("Start");
		Users userObj = userRepository.findByUserName(user);
		MenuItem menuItem = menuItemRepository.findMenuItemById(menuItemId);
		Set<MenuItem> menuList = userObj.getMenuItemList();
		menuList.add(menuItem);
		userObj.setMenuItemList(menuList);
		userRepository.save(userObj);
		LOGGER.info("End");

	}

	@Override
	public Set<MenuItem> getAllCartItems(String user) throws CartEmptyException {
		LOGGER.info("Start");
		Users userObject = userRepository.getMenuItems(user);
		Set<MenuItem> menuList = userObject.getMenuItemList();
		if (menuList.isEmpty()) {
			throw new CartEmptyException("Cart is Empty");
		}
		LOGGER.info("End");
		return menuList;
	}

	@Override
	public double getCartTotal(String user) {
		LOGGER.info("Start");
		double total = userRepository.getCartTotal(user);
		LOGGER.info("End");
		return total;
	}

	@Override
	public void removeCartItem(String user, long menuItemId) {
		LOGGER.info("Start");
		boolean flag = false;
		Users userObj = userRepository.getMenuItems(user);
		Set<MenuItem> menuList = userObj.getMenuItemList();
		for (MenuItem m : menuList) {
			if (menuItemId == m.getId()) {
				flag = menuList.remove(m);
				break;
			}
		}
		if (flag == true) {
			userObj.setMenuItemList(menuList);
			userRepository.save(userObj);
		}
		LOGGER.info("End");
	}
}
