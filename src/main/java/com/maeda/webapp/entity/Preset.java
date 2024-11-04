package com.maeda.webapp.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "preset")
public class Preset {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "ir_cab")
    private int ir_cab;

    @Column(name = "reverb")
    private int reverb;

    @Column(name = "preset")
    private int preset;

    @Column(name = "mix")
    private int mix;

    @Column(name = "fb")
    private int fb;

    @Column(name = "mod")
    private int mod;

    @Column(name = "tone")
    private int tone;

    @Column(name = "gain")
    private int gain;

    @Column(name = "type")
    private int type;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

    public Preset() {
    }

    public Preset(String name, int ir_cab, int reverb, int preset, int mix, int fb, int mod, int tone, int gain, int type) {
        this.name = name;
        this.ir_cab = ir_cab;
        this.reverb = reverb;
        this.preset = preset;
        this.mix = mix;
        this.fb = fb;
        this.mod = mod;
        this.tone = tone;
        this.gain = gain;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIr_cab() {
        return ir_cab;
    }

    public void setIr_cab(int ir_cab) {
        this.ir_cab = ir_cab;
    }

    public int getReverb() {
        return reverb;
    }

    public void setReverb(int reverb) {
        this.reverb = reverb;
    }

    public int getPreset() {
        return preset;
    }

    public void setPreset(int preset) {
        this.preset = preset;
    }

    public int getMix() {
        return mix;
    }

    public void setMix(int mix) {
        this.mix = mix;
    }

    public int getFb() {
        return fb;
    }

    public void setFb(int fb) {
        this.fb = fb;
    }

    public int getMod() {
        return mod;
    }

    public void setMod(int mod) {
        this.mod = mod;
    }

    public int getTone() {
        return tone;
    }

    public void setTone(int tone) {
        this.tone = tone;
    }

    public int getGain() {
        return gain;
    }

    public void setGain(int gain) {
        this.gain = gain;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Preset{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ir_cab=" + ir_cab +
                ", reverb=" + reverb +
                ", preset=" + preset +
                ", mix=" + mix +
                ", fb=" + fb +
                ", mod=" + mod +
                ", tone=" + tone +
                ", gain=" + gain +
                ", type=" + type +
                '}';
    }
}
