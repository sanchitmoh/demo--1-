package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyClass {
@GetMapping ("/greet")
    public String getGreeting() {
        return "Hello, World!";
    }
    @GetMapping("/add")
    public int addNumbers(@RequestParam int a,  @RequestParam int b) {
        return a + b;
    }
}
