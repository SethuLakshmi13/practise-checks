package com.cognizant.movie.service;

import java.util.Set;

import com.cognizant.movie.model.Movies;

public interface MovieService {

	public Set<Movies> getMovieListAdmin();

	public Set<Movies> getMovieListCustomer();
	
	public Set<String> getAllGenre();

	public void modifyMovieList(Movies movie);

	public Movies getMovieList(long movieId);
}
