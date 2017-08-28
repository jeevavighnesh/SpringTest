package com.aynna.service;

import com.aynna.model.User;

import java.util.List;

public interface UserService {
    public void addUser(User user);
    public List<User> listUsers();
    public void removeUser(User user);
    public void editUser(User user);
}
