package com.cognizant.truyum.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cognizant.truyum.model.MenuItem;

public interface MenuItemRepository  extends JpaRepository<MenuItem, Long>  {
	
	@Query("Select m from MenuItem m")
	public Set<MenuItem> getAllMenuItemListAdmin();
	@Query(value="select me_id,me_name, me_price, me_active, me_date_of_launch, me_category, me_free_delivery ,me_image from menu_item where me_date_of_launch  <= (select curdate()) and me_active = 'yes'",nativeQuery=true)
	public Set<MenuItem> getAllMenuItemListCustomer();
	public MenuItem findMenuItemById(long menuItemId);
}
