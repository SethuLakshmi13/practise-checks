package com.cognizant.movieservice.service;

import java.util.Set;

import com.cognizant.movieservice.exception.FavoritesEmptyException;
import com.cognizant.movieservice.model.Movies;

public interface FavoritesService {
	


	public void addToFavorites(String user, long movieId);

	public Set<Movies> getAllFavorites(String user) throws FavoritesEmptyException;

	public void removeFavorites(String user, long movieId);

	public int getNoOfFavorites(String user);


}
