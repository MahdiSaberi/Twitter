package com.twitter.base.repository;

import com.twitter.base.entity.BaseEntity;
import jakarta.persistence.EntityTransaction;

import java.io.Serializable;
import java.util.List;

public interface BaseRepository<ID extends Serializable,T extends BaseEntity> {

    T save(T e);

    T findById(ID id);

    List<T> findAll();

    void deleteById(ID id);

    long countAll();

    void beginTransaction();

    void commitTransaction();

    void rollbackTransaction();

    EntityTransaction getTransaction();
}
