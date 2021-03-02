package com.tech.movie.dao;

import com.tech.movie.pojo.Movie;
import com.tech.movie.pojo.Tag;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends CrudRepository<Tag, Integer> {

}