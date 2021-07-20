package com.speedy.io.test.merchantAPI.entity;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
@TestPropertySource("classpath:application-dev.properties")
public class UserTest {

    @InjectMocks
    private User user;

    @Before
    public void setUp() {
        user.setEmail("example@mail.com");
        user.setPassword("password");
    }

    @Test
    public void getEmail() {
        String expectedEmail = "example@mail.com";
        Assert.assertEquals(expectedEmail, user.getEmail());
    }

    @Test
    public void getPassword() {
        String expectedPass = "password";
        Assert.assertEquals(expectedPass, user.getPassword());
    }

    @Test
    public void setEmail() {
        User testUser = Mockito.mock(User.class);
        testUser.setEmail("some@mail.com");
        verify(testUser, times(1)).setEmail("some@mail.com");
    }

    @Test
    public void setPassword() {
        User testUser = Mockito.mock(User.class);
        testUser.setPassword("12345678");
        verify(testUser, times(1)).setPassword("12345678");
    }

    @Test
    public void testEquals() {
        User testUser = new User();
        testUser.setEmail("example@mail.com");
        testUser.setPassword("password");
        Assert.assertTrue(testUser.equals(user));
    }
}