package com.twitter.util;

import com.twitter.domain.Comment;
import com.twitter.domain.Like;
import com.twitter.domain.Tweet;
import com.twitter.domain.User;

import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;

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

        try {
            User user = new User(firstName,lastName,username,password);
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

        Operation.selector("userPage",user);
    }

    public void userMainPage(User user){
        System.out.println("=====================================");
        System.out.println("Main | "+"@"+user.getUsername());
        System.out.println("=====================================");

        List<Tweet> tweets = Context.tweet.findAll();
        int countLikes;
        for(Tweet t : tweets){
            countLikes = Context.like.countByTweetId(t.getId());
            System.out.println("=============================================");
            System.out.println("id. "+t.getId()+"   |   "+t.getUser().getFirstName()+" "+t.getUser().getLastName()+"   |   "+"@"+t.getUser().getUsername());
            System.out.println("---------------------------------------------");
            System.out.println(t.getContent());
            System.out.println("---------------------------------------------");
            System.out.println("Date: "+t.getDateTime()+"    "+"Likes: "+ countLikes);
            System.out.println("=============================================");
        }
        System.out.println("1.Like\\Unlike\n2.Comment\n3.Back");

        Operation.selector("userMainPage",user);

    }
    public void userAddLike(User user){
        System.out.println("===========================");
        System.out.println("Tweet id: ");
        Long id = Context.getIntScanner().nextLong();
        Tweet tweet = Context.tweet.findById(id);

        Like like = new Like();
        like.setUser(user);
        like.setTweet(tweet);
        Context.like.save(user,tweet);
        userPage(user);
    }

    public void userAddComment(User user){
        System.out.println("===========================");
        System.out.println("Tweet id: ");
        Long id = Context.getIntScanner().nextLong();
        Tweet tweet = Context.tweet.findById(id);

        System.out.println("===========================");
        System.out.print("Type Comment: ");

        Comment comment = new Comment();
        String content = Context.getStringScanner().nextLine();
        comment.setUser(user);
        comment.setContent(content);
        comment.setTweet(tweet);
        Context.comment.save(comment);
        System.out.println("Posted!");
        userPage(user);
    }

    public void userTweets(User user){
        System.out.println("=====================================");
        System.out.println("Manage Tweets | "+"@"+user.getUsername());
        List<Tweet> tweets = Context.tweet.findAll();
        int countLikes;
        for(Tweet tweet : tweets) {
            countLikes = Context.like.countByTweetId(tweet.getId());
            if (tweet.getUser().equals(user)){
                System.out.println("=============================================");
                System.out.println("id: "+tweet.getId());
                System.out.println("---------------------------------------------");
                System.out.println(tweet.getContent());
                System.out.println("---------------------------------------------");
                System.out.println("Date: "+tweet.getDateTime()+"    "+"Likes: "+ countLikes);
                System.out.println("=============================================");
            }
        }
        System.out.println("1.Add\n2.Edit\n3.Delete\n4.Back");

        Operation.selector("userTweets",user);
    }

    public void addTweet(User user){
        System.out.println("=====================================");
        System.out.print("Add Tweet:");
        String content = Context.getStringScanner().nextLine();
        Tweet tweet = new Tweet();
        tweet.setUser(user);
        tweet.setContent(content);
        tweet.setDateTime(new Date());
        Context.tweet.save(tweet);
        System.out.println("Posted!");
        userPage(user);
    }

    public void editTweet(User user){
        System.out.println("=====================================");
        System.out.print("Tweet id:");
        Long id = Context.getIntScanner().nextLong();
        Tweet tweet = Context.tweet.findById(id);
        System.out.println("=====================================");
        System.out.print("Type Content: ");
        String content = Context.getStringScanner().nextLine();
        if(tweet.getUser().getId() == user.getId()){
            tweet.setContent(content);
            Context.tweet.save(tweet);
            System.out.println("Edited!");
            userPage(user);
        }
        else{
            System.out.println("=====================================");
            System.out.println("You can't edit this Tweet!");
            editTweet(user);
        }

    }

    public void deleteTweet(User user){
        System.out.println("=====================================");
        System.out.print("Tweet id:");
        Long id = Context.getIntScanner().nextLong();
        Tweet tweet = Context.tweet.findById(id);
        List<Like> likes = Context.like.findByTweetId(id);

        if(tweet.getUser().getId() == user.getId())
        {
            for(Like l : likes)
                Context.like.deleteById(l.getId());

            Context.tweet.deleteById(id);
            System.out.println("=====================================");
            System.out.println("Tweet Deleted!");
            userPage(user);
        }

        else{
            System.out.println("=====================================");
            System.out.println("You can't delete this Tweet!");
            deleteTweet(user);
        }

    }

    public void userComments(User user){
        System.out.println("=====================================");
        System.out.println("Manage Comments | "+"@"+user.getUsername());
        System.out.println("=====================================");
        List<Comment> comments = Context.comment.findByUserId(user.getId());

        for(Comment comment : comments){
            System.out.println("id: "+comment.getId());
            System.out.println("=============================================");
            System.out.println("Content: "+comment.getContent());
            System.out.println("=============================================");
        }
        System.out.println("1.Edit\n2.Delete\n3.Back");
        Operation.selector("userComments",user);
    }

    public void editComments(User user){
        System.out.println("=====================================");
        System.out.print("Comment id:");
        Long id = Context.getIntScanner().nextLong();
        Comment comment = Context.comment.findById(id);
        System.out.println("=====================================");
        System.out.print("Type Content: ");
        String content = Context.getStringScanner().nextLine();
        if(comment.getUser().getId() == user.getId()){
            comment.setContent(content);
            Context.comment.save(comment);
            System.out.println("Edited!");
            userPage(user);
        }
        else{
            System.out.println("=====================================");
            System.out.println("You can't edit this Comment!");
            editComments(user);
        }
    }

    public void deleteComment(User user){
        System.out.println("=====================================");
        System.out.print("Comment id:");
        Long id = Context.getIntScanner().nextLong();
        Comment comment = Context.comment.findById(id);

        if(comment.getUser().getId() == user.getId())
        {
            Context.comment.deleteById(id);
            System.out.println("=====================================");
            System.out.println("Comment Deleted!");
            userPage(user);
        }

        else{
            System.out.println("=====================================");
            System.out.println("You can't delete this Comment!");
            deleteComment(user);
        }

    }
}
