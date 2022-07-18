package com.twitter.repository;

import com.twitter.base.repository.BaseRepository;
import com.twitter.domain.Comment;
import com.twitter.domain.Like;

import java.util.List;

public interface LikeRepository extends BaseRepository<Long, Like> {

    List<Like> findByTweetId(Long id);

    Like findByUserAndTweetId(Long u_id,Long t_id);

    int countByTweetId(Long id);
}
