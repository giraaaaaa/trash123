package com.leejung.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Homecontroller
 */
@Controller
public class Homecontroller {
    @RequestMapping("/")
    public String index() {
        System.out.println("루트 경로로 들어옴");
        return "index";
    }
    
}