package com.wintherdev.repositories;

import com.wintherdev.entities.AppUser;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class AppUserRepository implements PanacheRepository<AppUser> {

    public AppUser getById(long id) {
        return findById(id);
    }

    public AppUser getByUUID(String uuid) {
        return find("uuid = ?1", uuid).firstResult();
    }

    public List<AppUser> getAll() {
        return listAll();
    }

    public void deleteById(long id) {
        AppUser u = findById(id);
        if (u != null) {
            delete(u);
        }
    }

    public String createUser(AppUser appUser) {
        String createdStatus = "failed";
        persist(appUser);
        AppUser createdAppUser = getById(appUser.getId());
        if(createdAppUser != null) {
            createdStatus = "success";
        }
        return createdStatus;
    }


    public AppUser getByEmail(String email) {
        return find("email", email).firstResult();
    }
}
