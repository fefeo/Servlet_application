package com.example.ztp_proj1.User;

import com.example.ztp_proj1.enums.Role;

public class User {
    public String login;
    public String pass;
    public final Role role;

    public User(String login, String pass) {
        this.login = login;
        this.pass = pass;
        this.role = Role.USER;
    }
    public User(String login, String pass, Role role) {
        this.login = login;
        this.pass = pass;
        this.role = role;
    }
    public static User Admin(){
        User admin = new User("admin", "admin123", Role.ADMIN);
        return admin;

    }
}

