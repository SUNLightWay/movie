package com.tech.movie.dao;

import com.tech.movie.pojo.Movie;
import com.tech.movie.pojo.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Integer> {

    Movie findMovieById(Integer movie_id);
}