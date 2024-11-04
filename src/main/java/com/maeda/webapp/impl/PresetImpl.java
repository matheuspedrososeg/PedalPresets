package com.maeda.webapp.impl;

import com.maeda.webapp.dao.PresetDAO;
import com.maeda.webapp.entity.Preset;
import com.maeda.webapp.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PresetImpl implements PresetDAO {

    private EntityManager entityManager;

    @Autowired
    public PresetImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Preset findPresetById(int id) {
         return entityManager.find(Preset.class, id);
    }

    @Override
    public List<Preset> findPresetByUserId(int id) {
        User user = entityManager.find(User.class, id);
        TypedQuery<Preset> query = entityManager.createQuery("from Preset p where p.id_user = :id", Preset.class);
        query.setParameter("id", id);
        return query.getResultList();
    }

    @Override
    public List<Preset> getAllPresets() {
        TypedQuery<Preset> query = entityManager.createQuery("from Preset", Preset.class);
        return query.getResultList();
    }
}
