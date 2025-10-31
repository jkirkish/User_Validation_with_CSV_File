package com.coderscampus.Assignment3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class UserService {

    public User isValid(String username, String password) {
        if (username == null || password == null) return null;

        for (User user : ThirdAssignment.users) {
            if (user != null &&
                user.getUsername().equalsIgnoreCase(username) &&
                user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    public void loadUsersFromFile() throws IOException {
        String filePath = "data.txt";
        List<User> userList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] userData = line.split(",");
                if (userData.length >= 3) { // assuming format: username,password,name
                    userList.add(new User(userData));
                }
            }
        }

        // Convert to array only if ThirdAssignment requires it
        ThirdAssignment.users = userList.toArray(User[]::new);
        System.out.println("User array populated with " + userList.size() + " users.");
    }
}
