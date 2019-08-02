package com.practice.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/practice")
@Controller
public class PracticeController {
    @Value("${spring.application.name}")
    String appName;
 
    @GetMapping("/first")
    public String homePage(Model model) {
        model.addAttribute("test", appName);
        return "home";
    }
    
    @GetMapping("/second")
    public String SecondHomePage(Model model) {
    	model.addAttribute("appNames",appName);
    	return "meeting";
    }
    
 
    
    
}
