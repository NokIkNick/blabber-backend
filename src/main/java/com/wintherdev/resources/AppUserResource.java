package com.wintherdev.resources;

import com.wintherdev.controllers.UserController;
import com.wintherdev.dtos.UserDTO;
import com.wintherdev.entities.AppUser;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
public class AppUserResource {

    @Inject
    UserController userController;


    @GET
    public List<AppUser> getAll()
    {
        return userController.getAllUsers();
    }

    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public String createUser(AppUser user)
    {
        System.out.println(user);
        return userController.createUser(user);
    }

    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    public UserDTO loginUserThroughCredentials(AppUser user){
        if(user.getEmail() == null || user.getPassword() == null)
        {
            return null;
        }

        return userController.getUserByLoginCredentials(user.getEmail(), user.getPassword());

    }
}
