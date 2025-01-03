package com.source.function.predicate;

import java.util.List;

class User {
    String name;
    List<String> roles;

    User(String name, List<String> roles) {
        this.name = name;
        this.roles = roles;
    }

    boolean hasRole(String role) {
        return roles.contains(role);
    }
}