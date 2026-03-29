package com.wintherdev.dtos;

import com.wintherdev.entities.UserProfile;

public class ProfileDTO {
    public String username;
    public String firstName;
    public String lastName;

    public ProfileDTO(UserProfile profile) {
        this.username = profile.getUsername();
        this.firstName = profile.getFirstName();
        this.lastName = profile.getLastName();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
