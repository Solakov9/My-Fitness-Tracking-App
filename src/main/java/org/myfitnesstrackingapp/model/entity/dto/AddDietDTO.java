package org.myfitnesstrackingapp.model.entity.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.myfitnesstrackingapp.model.entity.enums.DietCategory;
@Getter
@Setter
@NoArgsConstructor
public class AddDietDTO {
    @NotBlank
    @Size(min = 3, max = 20,message = "Name  must be between 3 and 20 characters.")
    private String name;
    @NotNull(message = "Need to select option!")
    private DietCategory category;
    @NotNull
    @Positive(message = "Must be positive number")
    @Max(value = 10000, message = "Must be less than or equal to 10000")
    private Integer calories;
    @NotBlank
    @Size(min = 20,max = 500,message = "Must be between 20 and 500 characters.")
    private String nutrients;
}
