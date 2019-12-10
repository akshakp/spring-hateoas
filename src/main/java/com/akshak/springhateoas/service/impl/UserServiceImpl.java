package com.akshak.springhateoas.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.akshak.springhateoas.Model.User;
import com.akshak.springhateoas.service.UserService;

import org.springframework.stereotype.Component;

/**
 * UserServiceImpl
 */
@Component
public class UserServiceImpl implements UserService {

    List<User> dummyUsers;

    
    @Override
    public List<User> getAllUsers() {
        return this.dummyUsers; 
    }

    @Override
    public User getUser(long id) {
        return this.dummyUsers.stream()
        .filter(p -> p.getId() == Long.valueOf(id))
        .findFirst().get() ;
    }

    @Override
    public List<User> deleteUser(long id) {
        List<User> users = this.dummyUsers.stream()
        .filter(p -> p.getId() != Long.valueOf(id))
        .collect(Collectors.toList());
        return users;
    }
    
    private List<User> setupUsers(){
        List<User> users = new ArrayList<User>();
        users.add(new User("User", "1", "user1@test.com", 1, true));
        users.add(new User("User", "2", "user2@test.com", 2, true));
        users.add(new User("User", "3", "user3@test.com", 3, true));
        users.add(new User("User", "4", "user4@test.com", 4, false));
        users.add(new User("User", "5", "user5@test.com", 5, true));
        users.add(new User("User", "6", "user6@test.com", 6, true));
        users.add(new User("User", "7", "user7@test.com", 7, false));
        users.add(new User("User", "8", "user8@test.com", 8, false));
        users.add(new User("User", "9", "user9@test.com", 9, true));
        return users;
    }

    public UserServiceImpl() {
        this.dummyUsers = setupUsers();
    }
    
}