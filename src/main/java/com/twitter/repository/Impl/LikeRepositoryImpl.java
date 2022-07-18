package com.twitter.repository.Impl;

import com.twitter.base.repository.Impl.BaseRepositoryImpl;
import com.twitter.domain.Like;
import com.twitter.domain.Tweet;
import com.twitter.repository.LikeRepository;
import com.twitter.repository.TweetRepository;

import java.util.ArrayList;
import java.util.List;

public class LikeRepositoryImpl extends BaseRepositoryImpl<Long, Like> implements LikeRepository {

    public LikeRepositoryImpl() {
        super();
        entityClass = getEntityClass();
    }

    @Override
    public Class<Like> getEntityClass() {
        return Like.class;
    }

    @Override
    public int countByTweetId(Long id) {
        List<Like> likes = entityManager.createQuery("from Like where tweet.id =: id",Like.class).setParameter("id",id).getResultList();
        return likes.size();
    }

    @Override
    public List<Like> findByTweetId(Long id) {
        return entityManager.createQuery("from Like where tweet.id =: id",Like.class).setParameter("id",id).getResultList();
    }
}
