package com.aynna.dao.impl;

import com.aynna.dao.UserDAO;
import com.aynna.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Repository
public class UserDAOImpl implements UserDAO{

    private static final Logger LOGGER = Logger.getLogger(UserDAOImpl.class.getSimpleName());

    private SessionFactory factory;

    @Autowired
    public void setFactory(SessionFactory sessionFactory){
        this.factory = sessionFactory;
    }

    @Override
    public void addUser(User user) {
        Session session = this.factory.getCurrentSession();
        LOGGER.log(Level.INFO,"Adding User details" + user.toString());
        session.save(user);
        LOGGER.log(Level.INFO,"Added user Successfully");
    }

    @Override
    public List<User> listAllUsers() {
        Session session = this.factory.getCurrentSession();
        List<User> users = (List<User>) session.createQuery("from User").list();
        for (User user :
                users) {
            LOGGER.log(Level.INFO, users.toString());
        }
        return users;
    }

    @Override
    public void removeUser(User user) {
        Session session = this.factory.getCurrentSession();
        LOGGER.log(Level.INFO,"Removing User " + user.toString() + " From DB...");
        session.delete(user);
        LOGGER.log(Level.INFO,"Removed User " + user.toString() + " From DB Successfully...");
    }

    @Override
    public void editUser(User user) {
        Session session = this.factory.getCurrentSession();
        LOGGER.log(Level.INFO,"Modifying User " + user.toString() + " details...");
        session.createQuery("UPDATE User set name = '" + user.getName() + "' WHERE id = " + user.getId());
    }
}
