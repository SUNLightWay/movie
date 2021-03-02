package com.tech.movie.pojo;

import javax.persistence.*;

@Entity
//@Table(name = "ratings")
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer user_id;
    private Integer movie_id;
    private Double rating;
    private Long timestamp;

    public Rating() {
    }

    public Rating(Integer id, Integer user_id, Integer movie_id, Double rating, Long timestamp) {
        this.id = id;
        this.user_id = user_id;
        this.movie_id = movie_id;
        this.rating = rating;
        this.timestamp = timestamp;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(Integer movie_id) {
        this.movie_id = movie_id;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Rating{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", movie_id=" + movie_id +
                ", rating=" + rating +
                ", timestamp=" + timestamp +
                '}';
    }
}
