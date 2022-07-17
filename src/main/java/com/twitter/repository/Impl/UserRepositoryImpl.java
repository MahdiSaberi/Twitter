package com.twitter.repository.Impl;

import com.twitter.base.repository.Impl.BaseRepositoryImpl;
import com.twitter.domain.User;
import com.twitter.repository.UserRepository;

public class UserRepositoryImpl extends BaseRepositoryImpl<Long, User> implements UserRepository {

    public UserRepositoryImpl() {
        super();
        entityClass = getEntityClass();
    }

    @Override
    public Class<User> getEntityClass() {
        return User.class;
    }
}
