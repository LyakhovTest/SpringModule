package service;

import basicIntegration.BasicIntegrationTest;
import model.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserServiceTest extends BasicIntegrationTest {
    UserService userService = context.getBean("userService", UserService.class);
    @Test
    public void createUserTest() {
        //When
        User newUser = userService.createUser("Kolya", "Bang@Gang");
        //Then
        assertEquals(storage.getUserById(newUser.getId()), newUser);
    }

    @Test
    public void updateUserTest(){
        //Given
        User user = storage.addUser("Kolya", "Bang@Gang");
        user.setEmail("Ivan@");
        //When
        User updateUser = userService.updateUser(user);
        //Then
        assertEquals(userService.findUserById(user.getId()).getEmail(),"Ivan@");
        assertNull(userService.findUserByEmail("Bang@Gang"));
    }

    @Test
    public void deleteUserTest() {
        //Given
        User newUser = storage.addUser("Qwer", "ytfgujh@kj");
        //When
        boolean isDeleted = userService.deleteUser(newUser.getId());
        //Then
        assertTrue(isDeleted);
        assertStorageIsEmpty();
    }

    @Before
    public void assertStorageIsEmpty(){
        assertEquals(0, storage.getUsersCount());
    }

    @After
    public void cleanUserStorage(){
        storage.deleteAllUsers();
    }
}
