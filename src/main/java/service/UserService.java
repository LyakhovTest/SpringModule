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

    public User createUser(String name, String email){
        return userDAO.createUser(name,email);
    }
}
