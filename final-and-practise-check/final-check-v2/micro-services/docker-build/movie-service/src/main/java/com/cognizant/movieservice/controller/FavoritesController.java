package com.cognizant.movieservice.controller;

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

import com.cognizant.movieservice.dto.FavoritesDTO;
import com.cognizant.movieservice.exception.FavoritesEmptyException;
import com.cognizant.movieservice.model.Movies;
import com.cognizant.movieservice.service.FavoritesService;


@RestController
@RequestMapping("/favorites")
public class FavoritesController {
	
	private static final Logger LOGGER=LoggerFactory.getLogger(FavoritesController.class);
	
	@Autowired
	FavoritesService favoritesService;
	
	@PostMapping("/{user}/{movieId}")
	public void addToFavorites(@PathVariable String user, @PathVariable long movieId){
		LOGGER.info("Start");
		favoritesService.addToFavorites(user, movieId);
		LOGGER.info("End");
	}
	
	@GetMapping("/{user}")
	public FavoritesDTO getAllFavorites(@PathVariable String user) throws FavoritesEmptyException {
		
		LOGGER.info("Start");
		Set<Movies> movieList = favoritesService.getAllFavorites(user);
		int noOfFavorites = favoritesService.getNoOfFavorites(user);
		FavoritesDTO favoriteDTO = new FavoritesDTO();
		favoriteDTO.setMovieList(movieList);;
		favoriteDTO.setNoOfFavorites(noOfFavorites);;
		LOGGER.info("End");
		return favoriteDTO ;
	}
	
	@DeleteMapping("/{user}/{movieId}")
	public void removeFavorites( @PathVariable String user,@PathVariable  long movieId){
		
		LOGGER.info("Start");
		favoritesService.removeFavorites(user, movieId);
		LOGGER.info("End");
	}
	

}
