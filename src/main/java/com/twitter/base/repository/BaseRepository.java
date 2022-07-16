package com.twitter.base.repository;

import com.twitter.base.entity.BaseEntity;

import java.io.Serializable;

public interface BaseRepository<ID extends Serializable,T extends BaseEntity> {

    void save(T t);

    T update(T t);

    void delete(T t);

    T find(T t);

    T findById(ID id);
}
