package com.wintherdev.controllers;

import com.wintherdev.dtos.UserDTO;
import com.wintherdev.entities.AppUser;
import com.wintherdev.repositories.AppUserRepository;
import com.wintherdev.utils.PasswordHashingService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class UserController {

    @Inject
    AppUserRepository appUserRepository;

    @Inject
    PasswordHashingService passwordHashingService;

    public AppUser getUserById(Long id) {
        return appUserRepository.getById(id);
    }

    public List<AppUser> getAllUsers() {
        return appUserRepository.getAll();
    }

    public String createUser(AppUser user) {

        user.setPassword(passwordHashingService.hash(user.getPassword()));

        if(user.getProfile() != null){
            user.getProfile().setAppUser(user);
        }
        return appUserRepository.createUser(user);
    }

    public UserDTO getUserByLoginCredentials(String email, String password) {
        AppUser found = appUserRepository.getByEmail(email);
        if(found == null){
            return null;
        }

        boolean isValid = passwordHashingService.verify(password, found.getPassword());

        if(!isValid){
            return null;
        }

        return new UserDTO(found);
    }
}
