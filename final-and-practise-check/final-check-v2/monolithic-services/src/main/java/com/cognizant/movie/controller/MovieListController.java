package com.cognizant.movie.controller;

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

import com.cognizant.movie.model.Movies;
import com.cognizant.movie.service.MovieService;
import com.cognizant.movie.secutity.AppUserDetailsService;


@RestController
@RequestMapping("/movie-list")
public class MovieListController {
	
	private static final Logger LOGGER=LoggerFactory.getLogger(MovieListController.class);
	
	@Autowired
	MovieService movieService;
	
	@Autowired
	 AppUserDetailsService appUserDetailsService;
	
	@GetMapping("")
	public Set<Movies> getMovieListAdmin(){
		
		LOGGER.info("Start");
		Set<Movies> movieList = null;
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String user = authentication.getName();
		
		if(user!="anonymousUser") {
			UserDetails userDetails = appUserDetailsService.loadUserByUsername(user);
			String role = userDetails.getAuthorities().toArray()[0].toString();
			if (role.equals("admin")) {
				LOGGER.debug("role_admin" + role);
				movieList=  movieService.getMovieListAdmin();
			} else {
				LOGGER.debug("role_admin" + role);
				movieList = movieService.getMovieListCustomer();
			}
		
		}else {
			movieList= movieService.getMovieListCustomer();
		}
		LOGGER.info("End");
		return movieList;
	}
	
	@GetMapping("/{movieId}")
	public Movies getMovieList(@PathVariable long movieId) {
		
		LOGGER.info("Start");
		LOGGER.info("End");
		return movieService.getMovieList(movieId);
		
	}
	
	@GetMapping("/genre")
	public Set<String> getAllGenre() {
		LOGGER.info("Start");
		LOGGER.info("End");
		return movieService.getAllGenre();
		
	}
	@PutMapping("")
	public void modifyMovieList(@RequestBody Movies movie) {
		
		LOGGER.info("Start");
		movieService.modifyMovieList(movie);
		LOGGER.info("End");
		
	}
	


}
