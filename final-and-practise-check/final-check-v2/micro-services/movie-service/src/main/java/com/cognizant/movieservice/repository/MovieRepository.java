package com.cognizant.movieservice.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cognizant.movieservice.model.Movies;

public interface MovieRepository extends JpaRepository<Movies,Long>{
	
	@Query("Select m from Movies m")
	public Set<Movies> getAllMovieListAdmin();
	
	@Query(value="select mo_id,mo_title, mo_box_office, mo_active, mo_date_of_launch, mo_genre, "
			+ "mo_has_teaser ,mo_image,mo_description,mo_rating,mo_language,mo_runtime,mo_like,mo_trailer "
			+ "from movie_list where mo_date_of_launch  <= (select curdate()) and mo_active = 'Yes'",nativeQuery=true)
	public Set<Movies> getAllMovieListCustomer();
	
	public Movies findMoviesById(long movieId);
	
	@Query("Select g.genreName from Genre g")
	public Set<String> getAllGenre();
	

}
