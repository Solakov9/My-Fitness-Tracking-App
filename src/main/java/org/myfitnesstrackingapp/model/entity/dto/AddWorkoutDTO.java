package org.myfitnesstrackingapp.model.entity.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.myfitnesstrackingapp.model.entity.enums.Level;
import org.myfitnesstrackingapp.model.entity.enums.WorkoutCategory;
@Getter
@Setter
@NoArgsConstructor
public class AddWorkoutDTO {
    @NotBlank
    @Size(min = 3, max = 20,message = "Name  must be between 3 and 20 characters.")
    private String name;
    @NotNull(message = "Need to select option!")
    private Level level;
    @NotNull(message = "Need to select option!")
    private WorkoutCategory category;
    @NotBlank
    @Size(min = 20, max = 400, message = "Input must be between 20 and 400")
    private String exercises;
}
