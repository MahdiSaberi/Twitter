package com.twitter.base.repository.Impl;

import com.twitter.base.entity.BaseEntity;
import com.twitter.base.repository.BaseRepository;
import com.twitter.util.Context;

import java.io.Serializable;

public class BaseRepositoryImpl <ID extends Serializable, T extends BaseEntity<ID>> implements BaseRepository<ID, T> {
    @Override
    public void save(T t) {

        try {
            Context.begin();
            Context.persist(t);
            Context.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            Context.rollback();
        } finally {
            Context.close();
        }

    }

    @Override
    public T update(T t) {
        T newEntity;

        try {
            Context.begin();
            newEntity = (T) Context.merge(t);
            Context.commit();
        } catch (Exception e) {
            System.out.println("wrong Entity!");
            Context.rollback();
            newEntity = t;
        } finally {
            Context.close();
        }
        return newEntity;    }

    @Override
    public void delete(T t) {

    }

    @Override
    public T find(T t) {
        return null;
    }

    @Override
    public T findById(ID id) {
        return null;
    }
}
