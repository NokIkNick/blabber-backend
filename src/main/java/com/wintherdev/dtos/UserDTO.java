package com.wintherdev.dtos;

import com.wintherdev.entities.AppUser;

public class UserDTO {

        public Long id;
        public String uuid;
        public String email;
        public ProfileDTO profile;

        public UserDTO(AppUser appUser) {
            this.id = appUser.getId();
            this.uuid = appUser.getUuid().toString();
            this.email = appUser.getEmail();
            this.profile = new ProfileDTO(appUser.getProfile());
        }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ProfileDTO getProfile() {
        return profile;
    }

    public void setProfile(ProfileDTO profile) {
        this.profile = profile;
    }
}
