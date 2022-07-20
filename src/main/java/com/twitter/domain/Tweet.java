package com.twitter.domain;

import com.twitter.base.entity.BaseEntity;
import jakarta.persistence.*;

import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
public class Tweet extends BaseEntity<Long> {

    @Column
    private String content;

    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    @Column
    private Date dateTime;

    @OneToMany(mappedBy = "tweet",cascade = CascadeType.REMOVE,fetch = FetchType.EAGER)
    private Set<Like> likes;

    @OneToMany(mappedBy = "tweet",cascade = CascadeType.REMOVE,fetch = FetchType.EAGER)
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

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
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
