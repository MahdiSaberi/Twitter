package com.twitter.util;

import com.twitter.domain.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Operation {
    public static Menu menu = getMenu();

    private static List<String> methods = new ArrayList<>(Arrays.asList("start","userPage","userMainPage","userTweets","userComments"));

    public static Menu getMenu() {
        return new Menu();
    }

    private static int methodName(String string){
        int chooseMethod = -1;

        for(String s : methods){
            if(s.equals(string)) {
                chooseMethod = methods.indexOf(s);
                break;
            }
        }
        return chooseMethod;
    }

    public static void selector(String string){
        start();
//        int chooseMethod = methodName(string);
//
//        switch (chooseMethod){
//            case 0:
//                start();
//
//        }
    }

    public static void selector(String string, User user){
        int chooseMethod = methodName(string);

        switch (chooseMethod){
            case 1:
                userPage(user);
            case 2:
                userMainPage(user);
            case 3:
                userTweets(user);
            case 4:
                userComments(user);
        }

    }


    private static void userPage(User user) {
        int select;
        select = Context.getIntScanner().nextInt();
        try {
            switch (select) {
                case 1:
                    menu.userMainPage(user);
                    break;

                case 2:
                    menu.userTweets(user);
                    break;

                case 3:
                    menu.userComments(user);
                    break;

                case 4:
                    menu.start();
            }
        }catch (Exception e){
            System.out.println("Please Enter valid number");
            menu.userPage(user);
        }
    }

    private static void userMainPage(User user) {
        int select;
        select = Context.getIntScanner().nextInt();
        try {
            switch (select) {
                case 1:
                    menu.userAddLike(user);
                    break;

                case 2:
                    menu.userAddComment(user);
                    break;

                case 3:
                    menu.userPage(user);
                    break;

            }
        }catch (Exception e){
            System.out.println("Please Enter valid number");
            menu.userMainPage(user);
        }

    }

    private static void userTweets(User user) {
        int select = Context.getIntScanner().nextInt();

        try {
            switch (select) {
                case 1:
                    menu.addTweet(user);
                    break;

                case 2:
                    menu.editTweet(user);
                    break;

                case 3:
                    menu.deleteTweet(user);
                    break;

                case 4:
                    menu.userMainPage(user);
            }
        }catch (Exception e){
            System.out.println("Please Enter valid number");
            menu.userTweets(user);
        }
    }

    private static void userComments(User user) {
        int select = Context.getIntScanner().nextInt();

        try {
            switch (select) {
                case 1:
                    menu.editComments(user);
                    break;

                case 2:
                    menu.deleteComment(user);
                    break;

                case 3:
                    menu.userPage(user);
                    break;

            }
        }catch (Exception e){
            System.out.println("Please Enter valid number");
            menu.userComments(user);
        }
    }

    private static void start() {
        int select;
        select = Context.getIntScanner().nextInt();
        try {
            switch (select) {
                case 1:
                    menu.login();
                    break;

                case 2:
                    menu.register();
                    break;

                case 3:
                    System.exit(0);
            }
        }catch (Exception e){
            System.out.println("Please Enter valid number");
            menu.start();
        }
    }
}