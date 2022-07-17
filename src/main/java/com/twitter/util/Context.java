package com.twitter.util;

import com.twitter.repository.Impl.TweetRepositoryImpl;
import com.twitter.repository.Impl.UserRepositoryImpl;
import jakarta.persistence.EntityManager;

import java.util.Scanner;

public class Context {
    private static EntityManager entityManager = DatabaseUtil.getEntityManager();
    private static Scanner intScanner = new Scanner(System.in);
    private static Scanner stringScanner = new Scanner(System.in);

    //Repository
    public static UserRepositoryImpl user = getUserRepository();
    public static TweetRepositoryImpl tweet = getTweetRepository();

    public static EntityManager getEntityManager() {
        return entityManager;
    }


    public static void begin(){
        entityManager.getTransaction().begin();
    }

    public static void commit(){
        entityManager.getTransaction().commit();
    }

    public static void rollback(){
        entityManager.getTransaction().rollback();
    }

    public static Boolean isActive(){
        return entityManager.getTransaction().isActive();
    }

    public static void close(){
        entityManager.close();
    }

    public static Scanner getIntScanner() {
        return intScanner;
    }

    public static Scanner getStringScanner() {
        return stringScanner;
    }

    public static UserRepositoryImpl getUserRepository() {
        return new UserRepositoryImpl();
    }

    public static TweetRepositoryImpl getTweetRepository() {return new TweetRepositoryImpl();}

}
