package service;

import dao.UserDAO;
import model.User;

public class UserService {

    private UserDAO userDAO;

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public User findUserById(long id){
        return userDAO.findUserById(id);
    }
}
