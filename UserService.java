package com.coderscampus.Assignment3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class UserService {

	public User isValid(String username, String password) {
		for (User user : ThirdAssignment.users) {
			if (user.getUsername().equals(username) &&
					user.getPassword().equals(password)) {
				return user;
			}
		}
		return null;
	}
	

	public void giveArrayContents() throws IOException, FileNotFoundException {

		String file = "data.txt";

		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file));
			String line = null;
			int i = 0;
			while ((line = br.readLine()) != null) {
				ThirdAssignment.users[i] = new User(line.split(","));
				System.out.println(ThirdAssignment.users[i]);
				i++;
			}
		} finally {
			System.out.println("User Array Populated");
			if (br != null)
				br.close();
		}
	}
}