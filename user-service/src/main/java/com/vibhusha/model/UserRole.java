package com.vibhusha.model;

public enum UserRole {
    ADMIN("admin"),
    USER("user");

    private final String displayName;

    UserRole(String displayName) {
        this.displayName = displayName;
    }
}