package com.coderscampus.Assignment3;

import java.io.IOException;
import java.util.Scanner;

public class ThirdAssignment {

    public static User[] users; // Dynamic array based on file
    private static final UserService userServ = new UserService();

    public static void main(String[] args) {
        try {
            // Load users from file
            userServ.loadUsersFromFile();

            // Start login process
            handleLogin();
        } catch (IOException e) {
            System.err.println("Error loading users: " + e.getMessage());
        }
    }

    private static void handleLogin() {
        try (Scanner input = new Scanner(System.in)) {
            boolean legitUser = false;
            int attempts = 0;
            final int maxAttempts = 5;

            while (!legitUser && attempts < maxAttempts) {
                System.out.print("Please enter your username: ");
                String username = input.nextLine();

                System.out.print("Please enter your password: ");
                String password = input.nextLine();

                User registeredUser = userServ.isValid(username, password);
                if (registeredUser != null) {
                    System.out.println("Hello: " + registeredUser.getName());
                    System.out.println("It's nice to meet you!");
                    legitUser = true;
                } else {
                    attempts++;
                    System.out.println(attempts + ": Your login is not valid, please retry!");
                    if (attempts >= maxAttempts) {
                        System.out.println("After " + attempts + " attempts, your account is locked.");
                    }
                }
            }
        }
    }

}