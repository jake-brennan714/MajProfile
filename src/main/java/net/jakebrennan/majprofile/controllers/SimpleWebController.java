package net.jakebrennan.majprofile.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SimpleWebController {
    @GetMapping("/simple")
    public String simple() {
        return "simple";
    }
}
