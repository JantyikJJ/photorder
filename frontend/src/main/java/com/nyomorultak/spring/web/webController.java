package com.nyomorultak.spring.web;



import com.nyomorultak.spring.api.Wrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
public class webController {

    private final String title = "PhotOrder";
    private static final Logger log = LoggerFactory.getLogger(webController.class);

    @GetMapping("/")
    public String homepage(Model model, HttpSession session){

        model.addAttribute("user", new User());
        model.addAttribute("title", title);
        return "index";
    }
    @PostMapping("/register")
    public String register(@ModelAttribute User user, HttpSession session) {
        User registeredUser = Wrapper.registerUser(user);
        if (registeredUser == null) {
            return "redirect:/";
        }

        session.setAttribute("user", registeredUser);
        return registeredUser.getIsStaff() ? "redirect:/admin" : "redirect:/user";
    }
    @PostMapping("/login")
    public String login(@ModelAttribute User user, HttpSession session) {
        User registeredUser = Wrapper.loginUser(user);
        if (registeredUser == null) {
            return "redirect:/";
        }

        session.setAttribute("user", registeredUser);
        return registeredUser.getIsStaff() ? "redirect:/admin" : "redirect:/user";
    }

    @GetMapping("/admin")
    public String adminPage(Model model, HttpSession session) {
        Object user = session.getAttribute("user");
        if (user == null || !((User)user).getIsStaff())
            return "redirect:/";

        List<Image> images = Wrapper.getImages();

        model.addAttribute("title", title);
        model.addAttribute("name", ((User)user).getName());
        model.addAttribute("images", images);
        return "admin";
    }
    @GetMapping("/user")
    public String userPage(Model model, HttpSession session) {
        Object user = session.getAttribute("user");
        if (user == null || !((User)user).getIsStaff())
            return "redirect:/";

        model.addAttribute("title", title);
        model.addAttribute("name", ((User)user).getName());
        return "user";
    }
}
