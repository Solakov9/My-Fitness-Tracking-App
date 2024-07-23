package org.myfitnesstrackingapp.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class HomeController {

    @GetMapping("/")
    public String goIndex(){
        return "index";
    }
    @GetMapping("/home")
    public String goHome(){
        return "home";
    }

}
