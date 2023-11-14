package com.example.User;

public class User {
    private int userID;
    private String username;
    private String password;
    private Role role;

    private boolean isAdmin;

    public User(int userID, String username, String password, Role role, boolean isAdmin) {
        this.userID = userID;
        this.username = username;
        this.password = password;
        this.role = role;
        this.isAdmin = isAdmin;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public int getUserID() {
        return userID;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
