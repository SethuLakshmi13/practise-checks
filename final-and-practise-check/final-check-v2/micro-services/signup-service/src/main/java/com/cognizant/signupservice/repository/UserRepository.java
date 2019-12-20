package com.cognizant.signupservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cognizant.signupservice.model.Users;

public interface UserRepository extends JpaRepository<Users,Long>{
	 
	 public Users findByUserName(String userName);
	 @Query("select u from Users u where userName=?1")
	 public Users getMovie(String user);
	 @Query(value="select count(fa_mo_id) as no_of_favorites from favorite inner join user on us_id=fa_us_id where user.us_name=?1",nativeQuery=true)
	 public int getNoOfFavorites(String user);
}
