package com.cognizant.truyum.controller;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.service.AppUserDetailsService;
import com.cognizant.truyum.service.MenuItemService;

@RestController
@RequestMapping("/menu-items")

public class MenuItemController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger( MenuItemController.class);
	
	@Autowired
	MenuItemService menuItemService;
	@Autowired
	 AppUserDetailsService appUserDetailsService;

	@GetMapping("/items")
	public Set<MenuItem> getAllMenuItems() {
		LOGGER.info("Start");
		Set<MenuItem> menuItemList = null;
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String user = authentication.getName();
		
		if(user!="anonymousUser") {
			UserDetails userDetails =  appUserDetailsService.loadUserByUsername(user);
			String role = userDetails.getAuthorities().toArray()[0].toString();
			if (role.equals("admin")) {
				LOGGER.debug("role_admin" + role);
				menuItemList = menuItemService.getMenuItemListAdmin();
			} else {
				LOGGER.debug("role_admin" + role);
				menuItemList = menuItemService.getMenuItemListCustomer();
			}
		
		}else {
			menuItemList=menuItemService.getMenuItemListCustomer();
		}
		LOGGER.info("End");
		return menuItemList;
	}

	@GetMapping("/{id}")
	public MenuItem getMenuItem(@PathVariable long id)  {
		LOGGER.info("Start");
		LOGGER.info("End");
		return menuItemService.getMenuItem(id);
	}
	
	@PutMapping("/items")
	public void modifyMenuItem(@RequestBody MenuItem menuItem) {
		LOGGER.info("Start");
		menuItemService.modifyMenuItem(menuItem);
		LOGGER.info("End");
	}
}
