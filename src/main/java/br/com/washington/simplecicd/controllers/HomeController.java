package br.com.washington.simplecicd.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping
    String home(){
        return "Welcome to my homepage!";
    }
}
