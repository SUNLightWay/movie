package com.tech.movie.service;

import com.tech.movie.common.SverResponse;
import com.tech.movie.dao.LinkRepository;
import com.tech.movie.dao.MovieRepository;
import com.tech.movie.dao.UserRepository;
import com.tech.movie.pojo.Link;
import com.tech.movie.pojo.Movie;
import com.tech.movie.service.impl.MovieServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService implements MovieServiceImpl {

    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private LinkRepository linkRepository;

    @Override
    public SverResponse<Movie> findMovieInfo(Integer movieId) {
        Movie movie = movieRepository.findMovieById(movieId);
        if (movie != null)
            return SverResponse.createRespBySuccess(movie);
        else
            return SverResponse.createRespByError();
    }

    @Override
    public SverResponse<Link> findMovieLink(Integer movieId) {
        Link link = linkRepository.findLinkById(movieId);
        if (link != null)
            return SverResponse.createRespBySuccess(link);
        else
            return SverResponse.createRespByError();
    }

    @Override
    public SverResponse<Movie> padMovieInfo(Movie movie) {
        Movie movie_old = movieRepository.findMovieById(movie.getMovie_id());
        if (movie_old == null)
            return SverResponse.createRespByError();
        movie.setId(movie_old.getId());
        movie.setGenres(movie_old.getGenres());
        movie.setTitle(movie_old.getTitle());
        movieRepository.save(movie);
        return SverResponse.createRespBySuccess("更新成功！", movie);
    }

}
