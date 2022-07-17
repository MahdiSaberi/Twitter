package com.twitter.repository.Impl;

import com.twitter.base.repository.Impl.BaseRepositoryImpl;
import com.twitter.domain.Tweet;
import com.twitter.domain.User;
import com.twitter.repository.TweetRepository;
import com.twitter.repository.UserRepository;

public class TweetRepositoryImpl extends BaseRepositoryImpl<Long, Tweet> implements TweetRepository {

    public TweetRepositoryImpl() {
        super();
        entityClass = getEntityClass();
    }

    @Override
    public Class<Tweet> getEntityClass() {
        return Tweet.class;
    }

}
