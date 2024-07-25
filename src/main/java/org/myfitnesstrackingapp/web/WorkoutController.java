package org.myfitnesstrackingapp.web;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.myfitnesstrackingapp.model.entity.dto.UserRegisterDTO;
import org.myfitnesstrackingapp.model.entity.dto.AddWorkoutDTO;
import org.myfitnesstrackingapp.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
public class WorkoutController {

    private final UserService userService;

    @ModelAttribute("workoutData")
    public AddWorkoutDTO addWorkoutDTO() {
        return new AddWorkoutDTO();
    }

    @GetMapping("/users/add-workout")
    public String workout() {
        return "add-workout";
    }

    @PostMapping("users/add-workout")
    public String doWorkout(
            @Valid AddWorkoutDTO data,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes
    ) {
        System.out.println();
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("workoutData", data);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.workoutData", bindingResult);


            return "add-workout";
        }
        userService.saveWorkout(data);


        return "redirect:/home";
    }
}
