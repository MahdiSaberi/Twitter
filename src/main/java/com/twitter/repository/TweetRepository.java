package com.twitter.repository;

import com.twitter.base.repository.BaseRepository;
import com.twitter.domain.Tweet;
import com.twitter.domain.User;

public interface TweetRepository extends BaseRepository<Long, Tweet> {
}
