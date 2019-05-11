package com.jetbrains;

import java.util.ArrayList;
import java.util.Scanner;

public class Main2
{
    private static UserManager users = new UserManager();
    private static PostManager posts = new PostManager();

    public static void main(String[] args)
    {

        User userOne = new User("TimeLord", "http://myavatar.com/TimeLord", "Katie", "Golden", "kegolden78@gmail.com");
        User userTwo = new User("Panger", "http://myavatar.com/Panger", "Darren", "Pang", "dpang@stlblues.com");
        User userThree = new User("JK", "http://myavatar.com/JK", "John", "Kelly", "jkelly@stlblues.com");
        users.addUser(userOne);
        users.addUser(userTwo);
        users.addUser(userThree);

        posts.addPost(userOne, 1, "Benedryl and coding DO NOT mix!");
        posts.addPost(userOne, 2, "So sleepy!");
        posts.addPost(userTwo, 3, "Holy Jumpin...");
        posts.addPost(userThree, 4, "Nuka Cola...the new official drink of the St. Louis Blues!", "http://www.fallout.com");
        posts.addPost(userOne, 5, "Can't...keep...eyes...open...");

        String mainMenuText = "Main Menu\n" +
                "1. Create/Select a user\n" +
                "2. Create a post as the current user\n" +
                "3. Print All Posts\n" +
                "4. Prints All Users\n" +
                "5. Exit Program\n";

        String userMenu = "\n1. Create new user\n"+
                "2. Select existing user";

        String selectedUserName = null;
        String postMenu = "New message: ";
        boolean endMenu = false;
        do {
            switch (userInterface(mainMenuText + "\n" +
                    (selectedUserName == null? "No user currently selected. ":"You are currently " + selectedUserName + ". ") +
                    " What would you like to do?"))
            {
                case "1":
                    switch (userInterface(userMenu))
                    {
                        case "1":
                            String userName;
                            boolean checkName = false;
                            do
                            {
                                userName = userInterface("Enter User Name: ");
                                checkName = users.containsUserName(userName);
                                if (checkName)
                                {
                                    System.out.println("The User Name you chose is already in use. ");
                                }
                            }
                            while (checkName);

                            String avatar = userInterface("Enter Avatar URL: ");
                            String firstName = userInterface("Enter First Name: ");
                            String lastName = userInterface("Enter Last Name: ");
                            String email = userInterface("Enter Email: ");

                            users.addUser(userName, avatar, firstName, lastName, email);
                            break;

                        case "2":
                            ArrayList<User> byEmail = users.getAllUsersByEmail(userInterface("\nPlease enter your email address: "));
                            System.out.println("\n");
                            if (byEmail == null || byEmail.size() == 0)
                            {
                                System.out.println("No users found with that email. ");
                            }
                            else
                            {
                                for (int i = 1; i <= byEmail.size(); i++)
                                {
                                    System.out.println(i+". "+byEmail.get(i-1).toString());
                                }
                                String selectedUser = userInterface("\nPlease select your User Name: ");
                                int selectedIndex = Integer.parseInt(selectedUser)-1;
                                if (!(selectedIndex >= 0 && selectedIndex < byEmail.size()))
                                {
                                    System.out.println("Invalid selection.  Returning to Main Menu.");
                                }
                                else
                                {
                                    selectedUserName = byEmail.get(selectedIndex).getUserName();
                                }

                            }

                            break;

                        default:
                            break;
                    }
                    break;
                case "2":
                    if (selectedUserName == null)
                    {
                        System.out.println("No user selected.  Please select a user. ");
                    }
                    else
                    {
                        System.out.println("\n");
                        Post lastUserPost = posts.getUserLastPost(selectedUserName);
                        if (lastUserPost == null)
                        {
                            System.out.println("No previous posts. ");
                        }
                        else
                        {
                            System.out.println(lastUserPost.toString());
                        }
                        String url = null;
                        String message = userInterface("Please enter your next post.");
                        if (userInterface("Do you have a link? y/n").equals("y"))
                        {
                            url = userInterface("Enter your link: ");
                        }
                        posts.addPost(users.getUser(selectedUserName), posts.nextPostOrder(selectedUserName), message, url);


                    }
                    break;
                case "3":
                    System.out.println("\n");
                    System.out.println(posts.getAllPosts().toString());
                    break;
                case "4":
                    System.out.println("\n");
                    System.out.println(users.getUserList());
                    break;
                case "5": endMenu = true;
                    break;

                default:
                    userInterface(mainMenuText);
                    break;
            }
            System.out.println("\n");
        }
        while (!endMenu);
        System.out.println("Goodbye!");







        /*for (int i = 0; i < blog.length; i++)
        {
            System.out.println(blog[i].toString());
        }

        for (int i = 0; i < users.length; i++)
        {
            System.out.println(users[i].toString());
        }*/

    }

    public static String userInterface(String screenMessage)
    {
        Scanner keyboard = new Scanner(System.in);
        System.out.println(screenMessage);
        String s = keyboard.nextLine();
        return s;
    }
}