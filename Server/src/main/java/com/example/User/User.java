package com.example.User;

public class User {
    private int userID;
    private String username;
    private String password;
    private Role role;
    private boolean blocked;

    private boolean isAdmin;

    public User( String username, String password, Role role, boolean blocked) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.isAdmin = isAdmin;
    }

    public boolean isBlocked() {
        return blocked;
    }

    // Добавьте метод setter, если вам нужно изменять статус блокировки
    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
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

