package com.twitter.repository;

import com.twitter.base.repository.BaseRepository;
import com.twitter.domain.Comment;
import com.twitter.domain.Tweet;

public interface CommentRepository extends BaseRepository<Long, Comment>  {
}
