package com.audreysperry.moviereview.controllers;

import com.audreysperry.moviereview.models.Role;
import com.audreysperry.moviereview.models.User;
import com.audreysperry.moviereview.repositories.RoleRepository;
import com.audreysperry.moviereview.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private RoleRepository roleRepo;

    @RequestMapping(value="/login", method = RequestMethod.GET)
    public String loginForm(Model model,
                            HttpServletRequest request) {
        model.addAttribute("user", new User());
        Object message = request.getSession().getAttribute("error");
        model.addAttribute("errors", message);
        request.getSession().removeAttribute("error");
        return "login";
    }

    @RequestMapping(value="/signup")
    public String signupForm(Model model) {
        model.addAttribute("user", new User());
        return "signup";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String signupUser(Model model,
                             @ModelAttribute User user) {
        User newUser = user;
        Role userRole = roleRepo.findByName("ROLE_USER");
        newUser.setRole(userRole);
        userRepo.save(user);
        return "redirect:/login";
    }
}
