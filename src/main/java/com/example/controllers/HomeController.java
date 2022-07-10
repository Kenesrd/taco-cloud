package com.example.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(){
        return "home";
    }

    @GetMapping("/dev")
    public ResponseEntity<String> str(){
        return ResponseEntity.ok("Hello World!");
    }
}
