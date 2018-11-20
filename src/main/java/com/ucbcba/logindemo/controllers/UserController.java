package com.ucbcba.logindemo.controllers;


import com.ucbcba.logindemo.entities.Subcategoria;
import com.ucbcba.logindemo.entities.User;
import com.ucbcba.logindemo.services.SubcategoriaService;
import com.ucbcba.logindemo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private SubcategoriaService subcategoriaService;


    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(Model model) {
        model.addAttribute("user", new User());
        return "user/register";
    }


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model) {
        model.addAttribute("user", new User());
        return "user/login";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registration(@ModelAttribute("user") User user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "user/register";
        }
        user.setRol("CLIENTE");
        user.setFirstSession(true);
        userService.save(user);
        return "redirect:/login";
    }

    @RequestMapping(value = "/sub/{username}/{idSub}", method = RequestMethod.GET)
    public String subscribe(@PathVariable("username") String username, @PathVariable("idSub") Integer idSub){
        //Subcategoria subcategoria = subcategoriaService.findSubcategoria(idSub);
        User user=userService.findByUsername(username);
        //user.getSubcategorias().add(subcategoria);
        userService.save(user);
        return "redirect:/welcome";
    }

    @RequestMapping(value = "/profile/{username}", method = RequestMethod.GET)
    public String profile(@PathVariable String username, Model model) {
        User user=userService.findByUsername(username);
        model.addAttribute("user", user);
        return "user/profile";
    }
}
