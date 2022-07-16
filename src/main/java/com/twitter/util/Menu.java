package com.twitter.util;

public class Menu {

    public void start(){
        System.out.println("===========================");
        System.out.println("Welcome to Twitter!");
        System.out.println("===========================");
        System.out.println("1.Login\n2.Register\n3.Exit");

        Operation.selector("start");
    }

    public void login(){
        System.out.println("===========================");
        System.out.println("Login");
        System.out.println("===========================");

        Operation.selector("login");
    }

    public void register(){
        System.out.println("===========================");
        System.out.println("Register");
        System.out.println("===========================");

        Operation.selector("register");
    }
}
