package com.cognizant.movie.dto;

import java.util.Set;

import com.cognizant.movie.model.Movies;

public class FavoritesDTO {
	
	private Set<Movies> movieList;
	private int noOfFavorites;

	public FavoritesDTO() {
		
	}

	public FavoritesDTO(Set<Movies> movieList, int noOfFavorites) {
		this.movieList = movieList;
		this.noOfFavorites = noOfFavorites;
	}

	public Set<Movies> getMovieList() {
		return movieList;
	}

	public void setMovieList(Set<Movies> movieList) {
		this.movieList = movieList;
	}

	public int getNoOfFavorites() {
		return noOfFavorites;
	}

	public void setNoOfFavorites(int noOfFavorites) {
		this.noOfFavorites = noOfFavorites;
	}


}
