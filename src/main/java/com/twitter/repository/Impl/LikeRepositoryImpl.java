package com.twitter.repository.Impl;

import com.twitter.base.repository.Impl.BaseRepositoryImpl;
import com.twitter.domain.Like;
import com.twitter.domain.Tweet;
import com.twitter.domain.User;
import com.twitter.repository.LikeRepository;
import com.twitter.repository.TweetRepository;
import com.twitter.util.Context;

import java.util.ArrayList;
import java.util.List;

public class LikeRepositoryImpl extends BaseRepositoryImpl<Long, Like> implements LikeRepository {

    public LikeRepositoryImpl() {
        super();
        entityClass = getEntityClass();
    }

    @Override
    public  Class<Like> getEntityClass() {
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

    @Override
    public Like findByUserAndTweetId(Long u_id, Long t_id) {

        return entityManager.createQuery("from Like where user.id =: u_id and tweet.id =: t_id",Like.class).setParameter(
                "u_id",u_id).setParameter("t_id",t_id).getSingleResult();
    }

    public Like save(User user, Tweet tweet){
        System.out.println("You are HERE!");
        Long u_id = user.getId();
        Long t_id = tweet.getId();

        if(entityManager.createQuery("from Like where user.id =: u_id and tweet.id =: t_id",Like.class).setParameter(
                "u_id",u_id).setParameter("t_id",t_id).getResultList().isEmpty()) {
            Context.begin();
            Like like = new Like();
            like.setUser(user);
            like.setTweet(tweet);
            entityManager.persist(like);
            Context.commit();
            System.out.println("Liked!");
            return like;
        }
        else{
            Context.begin();
            Like like = findByUserAndTweetId(user.getId(), tweet.getId());
            entityManager.remove(like);
            Context.commit();
            System.out.println("Unliked!");
            return like;
        }

    }
}
