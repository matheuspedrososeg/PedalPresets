package com.maeda.webapp.controller;

import com.maeda.webapp.dao.PresetDAO;
import com.maeda.webapp.dao.UserDAO;
import com.maeda.webapp.entity.Preset;
import com.maeda.webapp.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class WebPageController {

    @RequestMapping("/")
    public ModelAndView mainPage(Model model) {
        ModelAndView modelAndView = new ModelAndView();
        List<Preset> presets = presetDAO.getAllPresets();
        model.addAttribute("presets", presets);
        modelAndView.setViewName("index");
        return modelAndView;
    }

    private UserDAO userDAO;

    private PresetDAO presetDAO;

    @Autowired
    public WebPageController(UserDAO userDAO, PresetDAO presetDAO) {
        this.userDAO = userDAO;
        this.presetDAO = presetDAO;
    }

    @GetMapping("users/{id}")
    public ModelAndView returnUserById(Model model, @PathVariable int id) {
        User user = userDAO.findUserById(id);
        model.addAttribute("user", user);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user");
        return modelAndView;
    }
    @GetMapping("users")
    public ModelAndView returnAllUSers(Model model) {
        ModelAndView modelAndView = new ModelAndView();
        List<User> users = userDAO.findUsers();
        model.addAttribute("users", users);
        modelAndView.setViewName("users");
        return modelAndView;
    }

    @GetMapping("preset/{id}")
    public String presetPage(Model model, @PathVariable int id) {
        Preset preset = presetDAO.findPresetById(id);
        model.addAttribute("preset", preset);
        return "preset";
    }

}
