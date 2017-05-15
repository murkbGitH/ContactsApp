package com.facade;

import com.dao.UserDAO;
import com.model.User;

/**
 * Created by Pawel on 2017-05-12.
 */
public class UserFacade {

    private UserDAO userDAO = new UserDAO();

    public boolean emailAlreadyExists(String email) {
        userDAO.beginTransaction();
        User user = userDAO.findUserByEmail(email);
        userDAO.closeTransaction();
        return user != null;
    }

    public User checkLoginData(String email, String password) {
        userDAO.beginTransaction();
        User user = userDAO.findUserByEmail(email);
        if (user == null || !user.getPassword().equals(password)) {
            return null;
        }
        return user;
    }

    public void createUser(User user) {
        userDAO.beginTransaction();
        userDAO.save(user);
        userDAO.commitAndCloseTransaction();
    }
}
