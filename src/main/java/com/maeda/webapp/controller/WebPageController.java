package com.maeda.webapp.controller;

import com.maeda.webapp.dao.PresetDAO;
import com.maeda.webapp.dao.UserDAO;
import com.maeda.webapp.entity.Preset;
import com.maeda.webapp.entity.User;
import com.maeda.webapp.security.UserAuthorizationConfig;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
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
        String username = userAuthorizationConfig.getLoggedUser();
        model.addAttribute("username", username);
        return modelAndView;
    }

    private UserDAO userDAO;

    private PresetDAO presetDAO;

    private UserAuthorizationConfig userAuthorizationConfig;

    @Autowired
    public WebPageController(UserDAO userDAO, PresetDAO presetDAO, UserAuthorizationConfig userAuthorizationConfig) {
        this.userDAO = userDAO;
        this.presetDAO = presetDAO;
        this.userAuthorizationConfig = userAuthorizationConfig;
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

    @GetMapping("createPreset/{id}")
    public String createPresetPage(Model model, @PathVariable String id) {
        if (!id.equals(userAuthorizationConfig.getLoggedUser())) return "non-authenticated";
        model.addAttribute("userId", id);
        model.addAttribute("preset", new Preset());
        return "createpreset";
    }
    @PostMapping("/processPreset")
    public String processPreset(@Valid @ModelAttribute("preset") Preset preset, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "createpreset";
        }
        presetDAO.savePreset(preset);
            return "preset-confirm";
    }

    @GetMapping("myPresets/{id}")
    public String showUserPresets(Model model, @PathVariable String id) {
        if (!id.equals(userAuthorizationConfig.getLoggedUser())) return "non-authenticated";
        model.addAttribute("userId", id);
        List<Preset> preset = presetDAO.findPresetByUserId(id);
        if (preset == null) return "myPresetsNUll";
        model.addAttribute("preset-list", preset);
        return "myPresets";
    }

//    @GetMapping("/login")
//    public String showLoginPage() {
//        return "login";
//    }
//    @RequestMapping("/non-authenticated")
//    public String showAccessDenied() {
//        return "non-authenticated";
//    }


}
