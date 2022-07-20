package com.twitter.base.repository.Impl;

import com.twitter.base.entity.BaseEntity;
import com.twitter.base.repository.BaseRepository;
import com.twitter.domain.Tweet;
import com.twitter.util.Context;
import com.twitter.util.DatabaseUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.criteria.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseRepositoryImpl<ID extends Serializable, T extends BaseEntity<ID>> implements BaseRepository<ID, T> {
    protected EntityManager entityManager;

    protected Class<T> entityClass;

    public BaseRepositoryImpl() {
        this.entityManager = Context.entityManager;
        this.entityClass = getEntityClass();
    }

    public abstract Class<T> getEntityClass();

    @Override
    public T save(T e) {
        if (e.getId() == null) {
            Context.begin();
            entityManager.persist(e);
            Context.commit();
        } else {
            Context.begin();
            e = entityManager.merge(e);
            Context.commit();
        }
        return e;
    }

    @Override
    public T findById(ID id) {
        return entityManager.find(entityClass, id);
    }

    @Override
    public List<T> findAll() {

        try {
            Context.begin();
            List<T> list = Context.entityManager.createQuery("from " + entityClass.getSimpleName(), entityClass).getResultList();
            Context.commit();

            return list;
        }catch (Exception e){
            findAll();
        }

        return null;
    }

    @Override
    public void deleteById(ID id) {
        Context.begin();
        entityManager.createQuery(
                "delete from " + entityClass.getSimpleName() + " e where e.id = :id").setParameter("id", id).executeUpdate();
        Context.commit();
    }

    @Override
    public long countAll() {
        return entityManager.createQuery(
                "select count(e) from " + entityClass.getSimpleName() + " e", Long.class).getSingleResult();
    }

    @Override
    public void beginTransaction() {
        if (!entityManager.getTransaction().isActive()) {
            entityManager.getTransaction().begin();
        }
    }

    @Override
    public void commitTransaction() {
        entityManager.getTransaction().commit();
    }

    @Override
    public void rollbackTransaction() {
        entityManager.getTransaction().rollback();
    }

    @Override
    public EntityTransaction getTransaction() {
        return entityManager.getTransaction();
    }

}
