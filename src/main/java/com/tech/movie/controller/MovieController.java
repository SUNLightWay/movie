package com.tech.movie.controller;

import com.tech.movie.common.SverResponse;
import com.tech.movie.pojo.Link;
import com.tech.movie.pojo.Movie;
import com.tech.movie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MovieController {

    @Autowired
    private MovieService movieService;

    /**
     * 获取某一部电影的全部信息
     * @param movieId
     * @return
     */
    @PostMapping("/getMovieInfo")
    public @ResponseBody SverResponse<Movie> getMovieInfo(@RequestParam Integer movieId){
        return movieService.findMovieInfo(movieId);
    }

    /**
     * 获取电影在imdb、tmdb的id标识
     * @param movieId
     * @return
     */
    @PostMapping("/getMovieLink")
    public @ResponseBody SverResponse<Link> getMovieLink(@RequestParam Integer movieId){
        return movieService.findMovieLink(movieId);
    }

    /**
     * 当数据库中电影数据不完整时，调用该接口补全信息
     * @param movie
     * @return
     */
    @PostMapping("/padMovieInfo")
    public @ResponseBody SverResponse<Movie> padMovieInfo(Movie movie){
        return movieService.padMovieInfo(movie);
    }
}
