package com.thcha.mini.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class HomeController {
    
    @RequestMapping("/")
    public String Home() {
        log.info("Home Controller start ...");
        return "index";
    }
}