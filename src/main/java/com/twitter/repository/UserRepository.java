package com.twitter.repository;

import com.twitter.base.repository.BaseRepository;
import com.twitter.domain.User;

public interface UserRepository extends BaseRepository<Long, User> {

    User findByUserPass(String username, String password);
}
