package com.restaurante.Backend.Admin.roles;

public enum UserRole {

    ADMIN( "admin" ),
    EMPREGADO( "empregado" ),
    CLIENTE( "cliente" );

    private final String role;

    UserRole( String role) {
        this.role = role;
    }
    public String getRole() {
        return role;
    }
}
