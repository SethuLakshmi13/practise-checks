package com.cognizant.truyum.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cognizant.truyum.model.Users;

public interface UserRepository extends JpaRepository<Users,Long>{
	 
	 public Users findByUserName(String userName);
	 @Query("select u from Users u where userName=?1")
	 public Users getMenuItems(String user);
	 @Query(value="select sum(menu_item.me_price) as total_price from menu_item inner join cart  On menu_item.me_id = cart.ct_pr_id inner join user On cart.ct_us_id=user.us_id where user.us_name=?1",nativeQuery=true)
	 public double getCartTotal(String user);

}