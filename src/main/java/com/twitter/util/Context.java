package com.twitter.util;

import jakarta.persistence.EntityManager;

import java.util.Scanner;

public class Context {
    private static EntityManager entityManager = DatabaseUtil.getEntityManager();
    private static Scanner intScanner = new Scanner(System.in);
    private static Scanner stringScanner = new Scanner(System.in);

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

    public static void isActive(){
        entityManager.getTransaction().isActive();
    }

    public static void persist(Object o){
        entityManager.persist(o);
    }

    public static Object merge(Object o){
        return entityManager.merge(o);
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

}
