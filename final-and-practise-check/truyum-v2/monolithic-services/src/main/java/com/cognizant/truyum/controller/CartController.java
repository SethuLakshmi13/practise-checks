package com.cognizant.truyum.controller;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.truyum.dto.CartDTO;
import com.cognizant.truyum.exception.CartEmptyException;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.service.CartService;

@RestController
@RequestMapping("/cart")
public class CartController {

	private static final Logger LOGGER = LoggerFactory.getLogger(CartController.class);

	@Autowired
	CartService cartService;

	@PostMapping("/{user}/{menuItemId}")
	public void addCartItem(@PathVariable String user, @PathVariable long menuItemId) {
		LOGGER.info("Start");
		this.cartService.addCartItem(user, menuItemId);
		LOGGER.info("End");
	}

	@GetMapping("/{user}")
	public CartDTO getAllCartItems(@PathVariable String user) throws CartEmptyException {
		LOGGER.info("Start");
		Set<MenuItem> menuItemList = cartService.getAllCartItems(user);
		double cartTotal = cartService.getCartTotal(user);
		CartDTO cartDTO = new CartDTO();
		cartDTO.setMenuItemList(menuItemList);
		cartDTO.setTotal(cartTotal);
		LOGGER.info("End");
		return cartDTO;
	}

	@DeleteMapping("/{user}/{menuItemId}")
	public void removeCartItem(@PathVariable String user, @PathVariable long menuItemId) {
		LOGGER.info("Start");
		LOGGER.info("End");
		this.cartService.removeCartItem(user, menuItemId);
	}

}
