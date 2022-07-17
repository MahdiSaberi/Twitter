package com.twitter.repository;

import com.twitter.base.repository.BaseRepository;
import com.twitter.domain.Comment;
import com.twitter.domain.Tweet;

import java.util.List;

public interface CommentRepository extends BaseRepository<Long, Comment>  {
    List<Comment> findByUserId(Long id);
}
