package se.lexicon.model.entity;

public enum ApplicationRole {

    APP_USER("APP_USER"),
    APP_USER_ADMIN("APP_USER_ADMIN");

    private final String role;

    ApplicationRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
