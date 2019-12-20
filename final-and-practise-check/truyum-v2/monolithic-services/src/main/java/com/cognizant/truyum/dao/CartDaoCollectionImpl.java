package com.cognizant.truyum.dao;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.cognizant.truyum.exception.CartEmptyException;
import com.cognizant.truyum.model.MenuItem;
@Repository
public class CartDaoCollectionImpl implements CartDao{
	
	/*
	 * private static final Logger LOGGER = LoggerFactory.getLogger(
	 * CartDaoCollectionImpl.class);
	 * 
	 * public static HashMap<String, Cart> userCarts;
	 * 
	 * public CartDaoCollectionImpl() { LOGGER.info("Start"); if (userCarts == null)
	 * { userCarts = new HashMap<String, Cart>(); } LOGGER.info("End"); }
	 * 
	 * public void addCartItem(String userId, long menuItemId) {
	 * 
	 * LOGGER.info("Start"); MenuItemDao menuItemDao = new
	 * MenuItemDaoCollectionImpl(); MenuItem menuItem =
	 * menuItemDao.getMenuItem(menuItemId);
	 * 
	 * if (!userCarts.containsKey(userId)) { userCarts.put(userId, new Cart(new
	 * ArrayList<MenuItem>(), 0.0));
	 * 
	 * } Cart cartItems = userCarts.get(userId);
	 * cartItems.getMenuItemList().add(menuItem); LOGGER.info("End"); }
	 * 
	 * public Cart getAllCartItems(String userId) throws CartEmptyException {
	 * 
	 * LOGGER.info("Start"); List<MenuItem> menuItems = null;
	 * 
	 * if (userCarts.isEmpty()) { throw new CartEmptyException("Cart is Empty"); }
	 * else { Cart cartItems = userCarts.get(userId);
	 * if(userCarts.containsKey(userId)) { menuItems = cartItems.getMenuItemList();
	 * if (menuItems.isEmpty()) { throw new CartEmptyException("Cart is Empty"); }
	 * else { double total = 0.0; for (MenuItem item : menuItems) { total = total +
	 * item.getPrice(); } cartItems.setTotal(total); } } LOGGER.info("End"); return
	 * cartItems; } }
	 * 
	 * public void removeCartItem(String userId, long menuItemId) {
	 * LOGGER.info("Start"); Cart cartItems = userCarts.get(userId); List<MenuItem>
	 * menuItems = cartItems.getMenuItemList();
	 * 
	 * for (int i = 0; i < menuItems.size(); i++) { if (menuItems.get(i).getId() ==
	 * menuItemId) { menuItems.remove(i); break; } } LOGGER.info("End"); }
	 * 
	 */

}
