package dao;

import model.User;
import storage.Storage;

public class UserDAO {
    private Storage storage;

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    public User findUserById(long id) {
        return storage.getUserById(id);
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
