package com.maeda.webapp.impl;

import com.maeda.webapp.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRoleImpl {
    private UserImpl userImpl;

    @Autowired
    public UserRoleImpl(UserImpl userImpl) {
        this.userImpl = userImpl;
    }

    public void createUserWithRole(String name, String password, boolean active) {
        User user = userImpl.createUser(name, password, active);

        userImpl.createRole(user);
    }
}
