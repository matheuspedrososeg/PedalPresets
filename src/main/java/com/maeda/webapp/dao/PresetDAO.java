package com.maeda.webapp.dao;

import com.maeda.webapp.entity.Preset;

import java.util.List;

public interface PresetDAO {
    Preset findPresetById(int id);
    List<Preset> findPresetByUserId(int id);
    List<Preset> getAllPresets();
}
