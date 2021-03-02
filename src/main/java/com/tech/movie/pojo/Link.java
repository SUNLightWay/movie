package com.tech.movie.pojo;

import javax.persistence.*;

@Entity
//@Table(name = "links")
public class Link {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer movie_id;
    private Integer imdb_id;
    private Integer tmdb_id;

    public Link() {
    }

    public Link(Integer id, Integer movie_id, Integer imdb_id, Integer tmdb_id) {       this.id = id;
        this.movie_id = movie_id;
        this.imdb_id = imdb_id;
        this.tmdb_id = tmdb_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(Integer movie_id) {
        this.movie_id = movie_id;
    }

    public Integer getImdb_id() {
        return imdb_id;
    }

    public void setImdb_id(Integer imdb_id) {
        this.imdb_id = imdb_id;
    }

    public Integer getTmdb_id() {
        return tmdb_id;
    }

    public void setTmdb_id(Integer tmdb_id) {
        this.tmdb_id = tmdb_id;
    }

    @Override
    public String toString() {
        return "Link{" +
                "id=" + id +
                ", movie_id=" + movie_id +
                ", imdb_id=" + imdb_id +
                ", tmdb_id=" + tmdb_id +
                '}';
    }
}
