package com.healthshop.healthshop.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
public class HomeController {

    @RequestMapping("/")
    public String home() {
        return "home";
    }

    @RequestMapping("/about")
    public String about() {
        return "about";
    }

    @RequestMapping("/services")
    public String services() {
        return "services";
    }
}
