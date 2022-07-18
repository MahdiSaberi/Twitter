package com.twitter.repository.Impl;

import com.twitter.base.repository.Impl.BaseRepositoryImpl;
import com.twitter.domain.Like;
import com.twitter.domain.Tweet;
import com.twitter.repository.LikeRepository;
import com.twitter.repository.TweetRepository;

public class LikeRepositoryImpl extends BaseRepositoryImpl<Long, Like> implements LikeRepository {

    public LikeRepositoryImpl() {
        super();
        entityClass = getEntityClass();
    }

    @Override
    public Class<Like> getEntityClass() {
        return Like.class;
    }
}
