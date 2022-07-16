package com.twitter.util;

public class Operation {
    public static Menu menu = getMenu();

    public static Menu getMenu() {
        return new Menu();
    }

    public static void selector(String methodName){
        int select = Context.getIntScanner().nextInt();

        if(methodName.equals("start")){

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

        else if(methodName.equals("login")){

            System.out.println("Username:");
            String username = Context.getStringScanner().nextLine();

            System.out.println("Password:");
            String password = Context.getStringScanner().nextLine();

        }

        else if(methodName.equals("register")){

            System.out.println("FirstName:");
            String firstName = Context.getStringScanner().nextLine();

            System.out.println("LastName:");
            String lastName = Context.getStringScanner().nextLine();

            System.out.println("Username:");
            String username = Context.getStringScanner().nextLine();

            System.out.println("Password:");
            String password = Context.getStringScanner().nextLine();
        }
    }
}
