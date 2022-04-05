package com.coderscampus.Assignment3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ThirdAssignment {

	public static User[] users = new User[4];
	private static UserService userServ = new UserService();

	public static void main(String[] args) throws IOException {
		userServ.giveArrayContents();

		Scanner input = new Scanner(System.in);
		try {

			boolean legitUser = false;
			short logins = 0;
			while (!legitUser && logins < 5) {
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
					System.out.println((logins+1) + ": Your login is not valid, please retry again!");
					logins++;
					if (logins >= 5) {
						System.out.println("After " + logins + " attempts, you account is locked.");
					}
				}
			}
		} finally {
			input.close();
		}
	}
}
