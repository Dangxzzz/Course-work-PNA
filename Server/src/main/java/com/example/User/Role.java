package com.example.User;

public enum Role {
    ADMIN("Administrator"),
    USER("User");

    private final String roleName;

    Role(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }
}
