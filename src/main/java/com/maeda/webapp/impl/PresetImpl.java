package com.maeda.webapp.impl;

import com.maeda.webapp.dao.PresetDAO;
import com.maeda.webapp.dao.UserDAO;
import com.maeda.webapp.entity.Preset;
import com.maeda.webapp.entity.User;
import com.maeda.webapp.security.UserAuthorizationConfig;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PresetImpl implements PresetDAO {

    private EntityManager entityManager;
    private UserAuthorizationConfig userAuthorizationConfig;
    private UserDAO userDAO;

    @Autowired
    public PresetImpl(EntityManager entityManager, UserAuthorizationConfig userAuthorizationConfig, UserDAO userDAO) {
        this.entityManager = entityManager;
        this.userAuthorizationConfig = userAuthorizationConfig;
        this.userDAO = userDAO;
    }

    @Override
    public Preset findPresetById(int id) {
         return entityManager.find(Preset.class, id);
    }

    @Override
    public List<Preset> findPresetByUserId(String id) {
        TypedQuery<Preset> query = entityManager.createQuery("from Preset p where p.user = :id", Preset.class);
        query.setParameter("id", id);
        return query.getResultList();
    }

    @Override
    public List<Preset> getAllPresets() {
        TypedQuery<Preset> query = entityManager.createQuery("from Preset", Preset.class);
        return query.getResultList();
    }

    @Override
    @Transactional
    public void createPreset(String name, int ir_cab, int reverb, int preset, int mix, int fb, int time, int mod, int tone, int gain, int type) {
        Preset persistingPreset = new Preset();
        String username = userAuthorizationConfig.getLoggedUser();

        persistingPreset.setName(name);
        persistingPreset.setId_user(username);
        persistingPreset.setIr_cab(ir_cab);
        persistingPreset.setReverb(reverb);
        persistingPreset.setPreset(preset);
        persistingPreset.setMix(mix);
        persistingPreset.setFb(fb);
        persistingPreset.setTime(time);
        persistingPreset.setMod(mod);
        persistingPreset.setTone(tone);
        persistingPreset.setGain(gain);
        persistingPreset.setType(type);

        entityManager.persist(persistingPreset);
    }

    @Override
    @Transactional
    public void savePreset(Preset preset) {
        entityManager.merge(preset);
    }


}
