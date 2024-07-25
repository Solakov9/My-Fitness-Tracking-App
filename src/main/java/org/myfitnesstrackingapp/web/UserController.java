package org.myfitnesstrackingapp.web;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.myfitnesstrackingapp.model.entity.dto.UserLoginDTO;
import org.myfitnesstrackingapp.model.entity.dto.UserRegisterDTO;
import org.myfitnesstrackingapp.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @ModelAttribute("registerData")
    public UserRegisterDTO registerDTO() {
        return new UserRegisterDTO();
    }
    @GetMapping("users/login")
    public ModelAndView viewLogin() {
        ModelAndView modelAndView = new ModelAndView("login");

        modelAndView.addObject("loginData", new UserLoginDTO());

        return modelAndView;
    }

    @GetMapping("/users/register")
    public String viewRegister(){
        return "register";
    }
      @PostMapping("users/register")
    public String doRegister(
            @Valid UserRegisterDTO data,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes
    ) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("registerData", data);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.registerData", bindingResult);


            return "redirect:register";
        }

        userService.register(data);


        return "redirect:/users/login";
    }
}
