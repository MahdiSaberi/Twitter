package com.twitter.base;

import com.twitter.base.entity.BaseEntity;
import jakarta.persistence.*;

import java.time.ZonedDateTime;
import java.util.Set;

@Entity
public class Tweet extends BaseEntity<Long> {

    @Column
    private String content;

    @ManyToOne
    private User user;

    @Column
    private ZonedDateTime dateTime;

    @OneToMany(mappedBy = "tweet")
    private Set<Like> likes;

    @OneToMany(mappedBy = "tweet")
    private Set<Comment> comments;

    public Tweet() {
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ZonedDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(ZonedDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Set<Like> getLikes() {
        return likes;
    }

    public void setLikes(Set<Like> likes) {
        this.likes = likes;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }
}
