package com.twitter.util;

import com.twitter.domain.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Operation {
    public static Menu menu = getMenu();

    public static Menu getMenu() {
        return new Menu();
    }

    public static void selector(String methodName){
        List<String> methods = new ArrayList<>(Arrays.asList("start","userPage"));
        int chooseMethod = -1;

        for(String s : methods){
            if(s.equals(methodName)) {
                chooseMethod = methods.indexOf(s);
                break;
            }
        }

        switch (chooseMethod){
            case 0:
                start();
            case 1:
                userPage();
        }
    }

    private static void userPage() {

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

