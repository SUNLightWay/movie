package com.tech.movie.dao;

import com.tech.movie.pojo.Link;
import com.tech.movie.pojo.Movie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LinkRepository extends CrudRepository<Link, Integer> {

    Link findLinkById(Integer movie_id);
}