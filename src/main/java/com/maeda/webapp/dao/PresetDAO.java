package com.maeda.webapp.dao;

import com.maeda.webapp.entity.Preset;

import java.util.List;

public interface PresetDAO {
    Preset findPresetById(int id);
    List<Preset> findPresetByUserId(int id);
    List<Preset> getAllPresets();
    void createPreset(String name, int ir_cab, int reverb, int preset, int mix, int fb, int time, int mod, int tone, int gain, int type);
}
