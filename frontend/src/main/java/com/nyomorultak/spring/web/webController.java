package com.nyomorultak.spring.web;

import org.apache.catalina.User;
import org.slf4j.LoggerFactory;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

@RestController
public class webController {

    private final String title = "PhotOrder";



    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String homepage(@ModelAttribute User user, Model model){
        model.addAttribute("title",title);
        model.addAttribute("user",user);
        return "index";
    }


    @RequestMapping("/admin")
    public String adminPage(Model model){
        model.addAttribute("title",title);
        model.addAttribute("name","Admin");
        return "admin";
    }
    @RequestMapping("/user")
    public String userPage(Model model){
        model.addAttribute("title",title);
        model.addAttribute("name","-----");
        return "user";
    }
}
