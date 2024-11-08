package com.maeda.webapp.dao;

import com.maeda.webapp.entity.User;

import java.util.List;

public interface UserDAO {
    User findUserById(int id);
    List<User> findUsers();
    User createUser(String name, String password, boolean active);
    void updateUser(String name, int id);
    void deleteUserById(int id);
    void createRole(User user);
    User findUserByName(String id);
}
