package com.example.desarrollo7.myapplication.data;

/**
 * Created by desarrollo7 on 1/03/17.
 */

public class User {
    private final String firstName;
    private final String lastName;
    private final int status;

    public User(String firstName, String lastName, int status) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.status = status;
    }
    public String getFirstName() {
        return this.firstName;
    }
    public String getLastName() {
        return this.lastName;
    }

    public int getStatus() {
        return status;
    }
}