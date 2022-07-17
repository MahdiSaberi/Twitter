package com.twitter.util;

import com.twitter.domain.User;

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

        System.out.println("Username:");
        String username = Context.getStringScanner().nextLine();

        System.out.println("Password:");
        String password = Context.getStringScanner().nextLine();
        User user;

        if(!((user = Context.user.findByUserPass(username,password)) == null)){
            System.out.println("Your login was successfully!");
            userPage(user);
        }
    }

    public void register(){
        System.out.println("===========================");
        System.out.println("Register");
        System.out.println("===========================");

        System.out.println("FirstName:");
        String firstName = Context.getStringScanner().nextLine();

        System.out.println("LastName:");
        String lastName = Context.getStringScanner().nextLine();

        System.out.println("Username:");
        String username = Context.getStringScanner().nextLine();

        System.out.println("Password:");
        String password = Context.getStringScanner().nextLine();

        User user = new User(firstName,lastName,username,password);
        try {
            Context.user.save(user);
            System.out.println("You have registered successfully!");
        }catch (Exception e){
            System.out.println("This username is already taken.");
            Context.rollback();
        }finally {
            start();
        }
    }

    public void userPage(User user){
        System.out.println("=====================================");
        System.out.println(user.getFirstName()+" "+user.getLastName()+" | "+"@"+user.getUsername());
        System.out.println("=====================================");
        System.out.println("1.Main\n2.My Tweets\n3.My Comments\n4.Logout");

        Operation.selector("userPage");
    }

    public void userPageMain(User user){
        System.out.println("=====================================");
        System.out.println("Main | "+"@"+user.getUsername());
        System.out.println("=====================================");
        System.out.println("1.Like\n2.Comment\n3.Back");

    }

    public void userPageManagePosts(User user){
        System.out.println("=====================================");
        System.out.println("Manage Tweets | "+"@"+user.getUsername());
        System.out.println("=====================================");
        System.out.println("1.Add\n2.Edit\n3.Delete\n4.Back");
    }
}
