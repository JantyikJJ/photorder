package com.nyomorultak.spring.web;



import com.nyomorultak.spring.api.ImageUploadRequest;
import com.nyomorultak.spring.api.Wrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
public class WebController {
    private final String title = "PhotOrder";

    @GetMapping("/")
    public String homepage(Model model, HttpSession session){
        Object user = session.getAttribute("user");
        if (user != null) {
            return redirectBy((User)user);
        }
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
        return redirectBy(registeredUser);
    }
    @PostMapping("/login")
    public String login(@ModelAttribute User user, HttpSession session) {
        User registeredUser = Wrapper.loginUser(user);
        if (registeredUser == null) {
            return "redirect:/";
        }

        session.setAttribute("user", registeredUser);
        return redirectBy(registeredUser);
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
        model.addAttribute("editImage", new Image());

        return "admin";
    }
    @PostMapping("/admin")
    public String updatePage(@RequestParam("id") int id, @RequestParam("status") int status, HttpSession session) {
        Object user = session.getAttribute("user");
        if (user == null || !((User)user).getIsStaff())
            return "redirect:/";

        Wrapper.updateImage(id, status);
        return "redirect:/admin";
    }

    @GetMapping("/user")
    public String userPage(Model model, HttpSession session) {
        Object user = session.getAttribute("user");
        if (user == null || ((User)user).getIsStaff())
            return "redirect:/";

        List<Image> images = Wrapper.getImages(((User)user).getId());

        model.addAttribute("title", title);
        model.addAttribute("name", ((User)user).getName());
        model.addAttribute("images", images);
        model.addAttribute("uploadImage", new ImageUploadRequest());

        return "user";
    }
    @PostMapping("/user")
    public String userPage(@ModelAttribute ImageUploadRequest image, HttpSession session) {
        Object user = session.getAttribute("user");
        if (user == null || ((User)user).getIsStaff() || image.image.length() == 0) {
            return "redirect:/";
        }

        image.setUserId(((User)user).getId());
        Wrapper.uploadImage(image);

        return "redirect:/user";
    }
    @GetMapping("/logout")
    public String logout(Model model, HttpSession session) {
        session.removeAttribute("user");
        return "redirect:/";
    }

    private String redirectBy(User user) {
        return user.getIsStaff() ? "redirect:/admin" : "redirect:/user";
    }
}
