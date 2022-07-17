package com.twitter.repository.Impl;

import com.twitter.base.repository.Impl.BaseRepositoryImpl;
import com.twitter.domain.Comment;
import com.twitter.domain.Tweet;
import com.twitter.repository.CommentRepository;
import com.twitter.repository.TweetRepository;

public class CommentRepositoryImpl extends BaseRepositoryImpl<Long, Comment> implements CommentRepository {

    public CommentRepositoryImpl() {
        super();
        entityClass = getEntityClass();
    }

    @Override
    public Class<Comment> getEntityClass() {
        return Comment.class;
    }
}
