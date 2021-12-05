package ru.ibs.recruiters_happiness.configuration;

public enum ApplicationUserPermission {
    PROJECTCARD_READ("projects:read"),
    PROJECTCARD_CREATE("projects:create"),
    PROJECTCARD_ARCHIVE("projects:archive"),
    PROJECTCARD_UPDATE("projects:update");

    private final String permission;

    ApplicationUserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
