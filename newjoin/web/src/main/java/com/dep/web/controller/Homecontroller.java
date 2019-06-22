package com.dep.web.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Homecontroller
 */
@Controller
public class Homecontroller {
    @RequestMapping("/")
    public String index() {
        System.out.println("잘 나오나요?");
        return "index";    
    }
    
}