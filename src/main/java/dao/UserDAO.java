package dao;

import model.User;
import model.UserImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import storage.Storage;

import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private Storage storage;

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    public User findUserById(long id) {
        return storage.getuserById(id);
    }

    public User createUser(String name, String email) {
        return storage.addUser(name,email);
    }

    public User updateUser(User user) {
        return storage.updateUser(user);
    }

    public boolean deleteUser(long userId) {
        return storage.deleteUser(userId);
    }

    public User findUserByEmail(String email) {
        return storage.getUserByEmail(email);
    }
}
