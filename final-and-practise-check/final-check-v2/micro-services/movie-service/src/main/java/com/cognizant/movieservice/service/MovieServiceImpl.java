package com.cognizant.movieservice.service;

import java.util.Set;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.movieservice.model.Movies;
import com.cognizant.movieservice.repository.MovieRepository;

@Service
public class MovieServiceImpl implements MovieService {

	private static final Logger LOGGER = LoggerFactory.getLogger(MovieServiceImpl.class);
	
	@Autowired
	MovieRepository movieRepository;

	@Override
	@Transactional
	public Set<Movies> getMovieListAdmin() {

		LOGGER.info("Start");
		LOGGER.info("End");
		return movieRepository.getAllMovieListAdmin();

	}

	@Override
	@Transactional
	public Set<Movies> getMovieListCustomer() {

		LOGGER.info("Start");
		LOGGER.info("End");
		return movieRepository.getAllMovieListCustomer();
	}

	@Override
	@Transactional
	public void modifyMovieList(Movies movie) {

		LOGGER.info("Start");
		movieRepository.save(movie);
		LOGGER.info("End");
	}

	@Override
	@Transactional
	public Movies getMovieList(long movieId) {

		LOGGER.info("Start");
		LOGGER.info("End");
		return movieRepository.findMoviesById(movieId);
	}

	@Override
	@Transactional
	public Set<String> getAllGenre() {

		LOGGER.info("Start");
		LOGGER.info("End");
		return movieRepository.getAllGenre();
	}

}
