package com.cognizant.truyum.service;

import java.util.Set;

import com.cognizant.truyum.exception.CartEmptyException;
import com.cognizant.truyum.model.MenuItem;

public interface CartService {

	public void addCartItem(String user, long menuItemId);

	public Set<MenuItem> getAllCartItems(String user) throws CartEmptyException;

	public void removeCartItem(String user, long menuItemId);

	public double getCartTotal(String user);

}
