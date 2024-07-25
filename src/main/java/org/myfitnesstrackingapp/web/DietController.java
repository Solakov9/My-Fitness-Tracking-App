package org.myfitnesstrackingapp.web;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.myfitnesstrackingapp.model.entity.dto.AddDietDTO;
import org.myfitnesstrackingapp.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
@Controller
@RequiredArgsConstructor
public class DietController {

    private final UserService userService;

    @ModelAttribute("dietData")
    public AddDietDTO addDietDTO() {
        return new AddDietDTO();
    }

    @GetMapping("/users/add-diet")
    public String diet() {
        return "add-diet";
    }

    @PostMapping("users/add-diet")
    public String doDiet(
            @Valid AddDietDTO data,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes
    ) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("dietData", data);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.dietData", bindingResult);


            return "add-diet";
        }
        userService.saveDiet(data);


        return "redirect:/home";
    }
}
