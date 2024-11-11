package com.maeda.webapp.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "preset")
public class Preset {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotEmpty(message = "Preset name must not be null")
    @Column(name = "name")
    private String name;


    @NotNull(message = "IR Cab must not be null")
    @Max(value = 10, message = "Maximum IR is 10")
    @Min(value = 0, message = "Minimum IR is 0")
    @Column(name = "ir_cab")
    private int ir_cab;

    @NotNull(message = "Reverb must not be null")
    @Max(value = 100, message = "Maximum Reverb is 100")
    @Min(value = 0, message = "Minimum Reverb is 0")
    @Column(name = "reverb")
    private int reverb;

    @Column(name = "preset")
    private int preset;

    @NotNull(message = "Mix must not be null")
    @Max(value = 100, message = "Maximum mix is 100")
    @Min(value = 0, message = "Minimum Mix is 0")
    @Column(name = "mix")
    private int mix;

    @NotNull(message = "FB must not be null")
    @Max(value = 100, message = "Maximum fb is 100")
    @Min(value = 0, message = "Minimum FB is 0")
    @Column(name = "fb")
    private int fb;

    @NotNull(message = "Time must not be null")
    @Max(value = 100, message = "Maximum time is 100")
    @Min(value = 0, message = "Minimum Time is 0")
    @Column(name = "time")
    private int time;

    @NotNull(message = "Mod must not be null")
    @Max(value = 100, message = "Maximum mod is 100")
    @Min(value = 0, message = "Minimum Mod is 0")
    @Column(name = "mod")
    private int mod;

    @NotNull(message = "Tone must not be null")
    @Max(value = 100, message = "Maximum tone is 100")
    @Min(value = 0, message = "Minimum tone is 0")
    @Column(name = "tone")
    private int tone;

    @NotNull(message = "Gain name must not be null")
    @Max(value = 100, message = "Maximum gain is 100")
    @Min(value = 0, message = "Minimum gain is 0")
    @Column(name = "gain")
    private int gain;

    @NotNull(message = "Type name must not be null")
    @Max(value = 10, message = "Maximum Type is 10")
    @Min(value = 0, message = "Minimum type is 0")
    @Column(name = "type")
    private int type;

    @Column(name = "id_user")
    private String user;

    public Preset() {
    }

    public Preset(String name, int ir_cab, int reverb, int preset, int mix, int fb, int time, int mod, int tone, int gain, int type, String id_user) {
        this.name = name;
        this.ir_cab = ir_cab;
        this.reverb = reverb;
        this.preset = preset;
        this.mix = mix;
        this.fb = fb;
        this.time = time;
        this.mod = mod;
        this.tone = tone;
        this.gain = gain;
        this.type = type;
        this.user = id_user;
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

    public String getId_user() {
        return user;
    }

    public void setId_user(String id_user) {
        this.user = id_user;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
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
