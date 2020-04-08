package io.javabrains.coronatracker.controllers;

import io.javabrains.coronatracker.services.CoronaVirusDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller //renders HTML UI...its NOT a rest controller
public class HomeController {

    @Autowired// can autowire service into the controller
    CoronaVirusDataService coronaVirusDataService;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("locationStats", coronaVirusDataService.getAllStats());
        return "home"; //returning a name which points to the template
        //eg if you return "ho" it returns what is inside templates/ho.html
    }
}
