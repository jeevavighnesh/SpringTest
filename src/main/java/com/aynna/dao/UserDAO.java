package com.aynna.dao;

import com.aynna.model.User;

import java.util.List;

public interface UserDAO {
    public void addUser(User user);
    public List<User> listAllUsers();
    public void removeUser(User user);
    public void editUser(User user);
}
