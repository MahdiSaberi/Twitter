package com.twitter.base;

import com.twitter.base.entity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity(name = "like_tbl")
public class Like extends BaseEntity<Long> {

    @OneToOne
    private User user;

    @ManyToOne
    private Tweet tweet;

    public Like() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Tweet getTweet() {
        return tweet;
    }

    public void setTweet(Tweet tweet) {
        this.tweet = tweet;
    }
}
