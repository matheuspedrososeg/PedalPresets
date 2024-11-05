package com.maeda.webapp.impl;


import com.maeda.webapp.dao.UserDAO;
import com.maeda.webapp.entity.Roles;
import com.maeda.webapp.entity.User;
import jakarta.persistence.EntityManager;
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
    public User createUser(String name, String password, boolean active) {
        User user = new User();
        user.setName(name);
        user.setPassword("{noop}" + password);
        user.setActive(active);

        entityManager.persist(user);

        return user;
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
    @Override
    @Transactional
    public void createRole(User user) {
        Roles roles = new Roles();
        roles.setRole("ROLE_MEMBER");
        roles.setId_user(user.getName());
        entityManager.persist(roles);
    }

}
