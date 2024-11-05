package com.maeda.webapp.impl;


import com.maeda.webapp.dao.UserDAO;
import com.maeda.webapp.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
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

    @Override
    @Transactional
    public void createUser(String name) {
        User user = new User();
        user.setName(name);
        entityManager.persist(user);
    }

    @Override
    @Transactional
    public void updateUser(String name, int id) {
        User user = entityManager.find(User.class, id);
        user.setName(name);
        entityManager.merge(user);
    }

    @Override
    @Transactional
    public void deleteUserById(int id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }
}
