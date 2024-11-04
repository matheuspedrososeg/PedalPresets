package com.maeda.webapp.dao;

import com.maeda.webapp.entity.User;

import java.util.List;

public interface UserDAO {
    User findUserById(int id);
    List<User> findUsers();

}
