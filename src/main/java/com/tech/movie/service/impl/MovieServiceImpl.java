package com.tech.movie.service.impl;

import com.tech.movie.common.SverResponse;
import com.tech.movie.pojo.Link;
import com.tech.movie.pojo.Movie;

public interface MovieServiceImpl {

    /**
     * 通过movieId获取电影信息
     * @param movieId
     * @return
     */
    public SverResponse<Movie> findMovieInfo(Integer movieId);

    /**
     * 通过movieId获取该电影的imdb_id、tmdb_id等信息
     * @param movieId
     * @return
     */
    SverResponse<Link> findMovieLink(Integer movieId);

    /**
     * 填充数据库中某电影缺失的信息
     * @param movie
     * @return
     */
    SverResponse<Movie> padMovieInfo(Movie movie);
}
