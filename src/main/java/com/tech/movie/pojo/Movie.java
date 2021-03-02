package com.tech.movie.pojo;

import javax.persistence.*;

@Entity
//@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer movie_id;
    private String title;
    private String genres;
    private String poster;
    private Integer type;
    private Double imdb_rating;
    private String runtime;
    private Integer year;
    private String director;
    private String writer;
    private String actors;
    private String language;
    private String country;
    private String plot;

    public Movie() {
    }

    public Movie(Integer movie_id, String title, String genres, String poster, Integer type, Double imdb_rating, String runtime, Integer year, String director, String writer, String actors, String language, String country, String plot) {
        this.movie_id = movie_id;
        this.title = title;
        this.genres = genres;
        this.poster = poster;
        this.type = type;
        this.imdb_rating = imdb_rating;
        this.runtime = runtime;
        this.year = year;
        this.director = director;
        this.writer = writer;
        this.actors = actors;
        this.language = language;
        this.country = country;
        this.plot = plot;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public Integer getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(Integer movie_id) {
        this.movie_id = movie_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movie_id=" + movie_id +
                ", title='" + title + '\'' +
                ", genres='" + genres + '\'' +
                ", poster='" + poster + '\'' +
                ", type=" + type +
                ", imdb_rating=" + imdb_rating +
                ", runtime='" + runtime + '\'' +
                ", year=" + year +
                ", director='" + director + '\'' +
                ", writer='" + writer + '\'' +
                ", actors='" + actors + '\'' +
                ", language='" + language + '\'' +
                ", country='" + country + '\'' +
                ", plot='" + plot + '\'' +
                '}';
    }

    public Double getImdb_rating() {
        return imdb_rating;
    }

    public void setImdb_rating(Double imdb_rating) {
        this.imdb_rating = imdb_rating;
    }
}
