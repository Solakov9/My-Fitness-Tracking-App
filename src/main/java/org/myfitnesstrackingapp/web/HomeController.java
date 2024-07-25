package org.myfitnesstrackingapp.web;

import lombok.RequiredArgsConstructor;
import org.myfitnesstrackingapp.model.entity.User;
import org.myfitnesstrackingapp.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
@RequiredArgsConstructor
public class HomeController {
    private final UserService userService;

    @GetMapping("/")
    public String goIndex(){
        return "index";
    }
    @GetMapping("/home")
    public String goHome(Model model) {
        User user = userService.getCurrentUserData();
        model.addAttribute("username",user.getUsername());
        model.addAttribute("age",user.getAge());
        model.addAttribute("height",user.getHeight());
        model.addAttribute("weight",user.getWeight());
    return "home";
    }

}
