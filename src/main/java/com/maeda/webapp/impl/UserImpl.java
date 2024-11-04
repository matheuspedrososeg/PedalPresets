package com.maeda.webapp.impl;


import com.maeda.webapp.dao.UserDAO;
import com.maeda.webapp.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserImpl implements UserDAO {

    private EntityManager entityManager;

    @Autowired
    public UserImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public User findUserById(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public List<User> findUsers() {
        TypedQuery<User> query = entityManager.createQuery("from User", User.class);
        return query.getResultList();
    }
}
