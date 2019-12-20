package com.cognizant.movieservice.service;

import java.util.Set;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.movieservice.exception.FavoritesEmptyException;
import com.cognizant.movieservice.model.Movies;
import com.cognizant.movieservice.model.Users;
import com.cognizant.movieservice.repository.MovieRepository;
import com.cognizant.movieservice.repository.UserRepository;

@Service
public class FavoritesServiceImpl implements FavoritesService{
	
	private static final Logger LOGGER=LoggerFactory.getLogger(FavoritesServiceImpl .class);
	
	@Autowired
	UserRepository userRepository;
	@Autowired
	MovieRepository movieRepository;

	@Override
	@Transactional
	public void addToFavorites(String user, long movieId) {
		LOGGER.info("Start");
		Users userObj = userRepository.findByUserName(user);
		Movies movie = movieRepository.findMoviesById(movieId);
		Set<Movies> movieList = userObj.getMovieList();
		movieList.add(movie);
		userObj.setMovieList(movieList);
		userRepository.save(userObj);
		LOGGER.info("End");

	}

	@Override
	@Transactional
	public Set<Movies> getAllFavorites(String user) throws FavoritesEmptyException {
		LOGGER.info("Start");
		Users userObject = userRepository.getMovie(user);
		Set<Movies> movieList = userObject.getMovieList();
		if (movieList.isEmpty()) {
			throw new FavoritesEmptyException("Favorites is Empty");
		}
		LOGGER.info("End");
		return movieList;
	}

	@Override
	@Transactional
	public int getNoOfFavorites(String user) {
		LOGGER.info("Start");
		int noOfFavorites = userRepository.getNoOfFavorites(user);
		LOGGER.info("End");
		return noOfFavorites;
	}

	@Override
	@Transactional
	public void removeFavorites(String user, long movieId) {
		LOGGER.info("Start");
		boolean flag = false;
		Users userObj = userRepository.getMovie(user);
		Set<Movies>movieList= userObj.getMovieList();
		for (Movies m : movieList) {
			if (movieId == m.getId()) {
				flag = movieList.remove(m);
				break;
			}
		}
		if (flag == true) {
			userObj.setMovieList(movieList);
			userRepository.save(userObj);
		}
		LOGGER.info("End");
	}


}
