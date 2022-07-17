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
    public User findByUserPass(String username, String password) {
        return entityManager.createQuery("from User where username=:username and password=:password",User.class).setParameter(
                "username",username).setParameter("password",password).getSingleResult();
    }

    @Override
    public Class<User> getEntityClass() {
        return User.class;
    }
}
