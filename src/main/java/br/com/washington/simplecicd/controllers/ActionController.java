package br.com.washington.simplecicd.controllers;

import br.com.washington.simplecicd.dto.Greeting;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/actions")
public class ActionController {


    @GetMapping(value = "/greeting/{text}")
    Greeting greeting(@PathVariable(value = "text") String text) {
        String greeting = "Hello, world!".concat(" - ").concat(text);
        return new Greeting(greeting);
    }
}
