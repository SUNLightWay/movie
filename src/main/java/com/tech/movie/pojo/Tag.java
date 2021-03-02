package com.tech.movie.pojo;

import javax.persistence.*;

@Entity
//@Table(name = "tags")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer user_id;
    private Integer movie_id;
    private String tag;
    private Long timestamp;

    public Tag() {
    }

    public Tag(Integer id, Integer user_id, Integer movie_id, String tag, Long timestamp) {
        this.id = id;
        this.user_id = user_id;
        this.movie_id = movie_id;
        this.tag = tag;
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

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Tag{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", movie_id=" + movie_id +
                ", tag='" + tag + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
