package io.javabrains.coronatracker.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller //renders HTML UI...its NOT a rest controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "home"; //returning a name which points to the template
        //eg if you return "ho" it returns what is inside templates/ho.html
    }
}
