package com.coderscampus.Assignment3;

import java.util.Objects;

public class User {
    private String username;
    private String password;
    private String name;

    // Constructor that accepts an array of values
    public User(String[] values) {
        if (values == null || values.length < 3) {
            throw new IllegalArgumentException("Invalid user data: expected [username, password, name]");
        }
        this.username = values[0].trim();
        this.password = values[1].trim();
        this.name = values[2].trim();
    }

    // Optional default constructor
    public User() {}

    // Getters and Setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username != null ? username.trim() : null;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password != null ? password.trim() : null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name != null ? name.trim() : null;
    }

    @Override
    public String toString() {
        return String.format("User [username=%s, password=%s, name=%s]", username, password, name);
    }

    // Equality check for potential future comparisons
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(username, user.username)
            && Objects.equals(password, user.password)
            && Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password, name);
    }
}
