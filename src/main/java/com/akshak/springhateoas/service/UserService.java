package com.akshak.springhateoas.service;

import java.util.List;

import com.akshak.springhateoas.Model.User;

/**
 * UserService
 */
public interface UserService {

    public List<User> getAllUsers();
    public User getUser(long id);
    public List<User> deleteUser(long id);

}