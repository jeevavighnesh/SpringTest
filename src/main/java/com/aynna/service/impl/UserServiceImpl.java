package com.aynna.service.impl;

import com.aynna.dao.UserDAO;
import com.aynna.model.User;
import com.aynna.service.UserService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.faces.bean.ManagedBean;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
@ManagedBean(name = "userService")
@Data
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = Logger.getLogger(UserServiceImpl.class.getSimpleName());

    private UserDAO userDAO;

    @Autowired
    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    @Transactional
    public void addUser(User user) {
        LOGGER.log(Level.INFO, user.toString());
        this.userDAO.addUser(user);
        LOGGER.log(Level.INFO, user.toString());
    }

    @Override
    @Transactional
    public List<User> listUsers() {
        return this.userDAO.listAllUsers();
    }

    @Override
    @Transactional
    public void removeUser(User user) {
        LOGGER.log(Level.INFO, user.toString());
        userDAO.removeUser(user);
    }

    @Override
    @Transactional
    public void editUser(User user) {
        userDAO.editUser(user);
    }
}
