package org.myfitnesstrackingapp.model.entity.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.myfitnesstrackingapp.model.entity.enums.Role;
@Getter
@Setter
@NoArgsConstructor
public class UserRegisterDTO {
    @NotBlank
    @Size(min = 3, max = 20,message = "Username  must be between 3 and 20 characters.")
    private String username;
    @NotBlank
    @Email(message = "Email cannot be empty.")
    private String email;
    @NotBlank
    @Size(min = 3, max = 20,message = "Password   be between 3 and 20 characters.")
    private String password;
    @NotNull(message = "Need to select option!")
    private Role role;
    @NotNull(message = "Age must be between 12 and 100 characters.")
    @Min(value = 12, message = "Age must be at least 12")
    @Max(value = 100, message = "Age must be less than or equal to 100")
    private Integer age;
    @NotNull(message = "Height must be between 100 and 300 centimeters.")
    @Min(value = 90, message = "Height must be at least 100")
    @Max(value = 300, message = "Height must be less than or equal to 300")
    private Integer height;
    @NotNull(message = "Weight must be between 30 and 400 kilograms.")
    @Min(value = 30, message = "Weight must be at least 30")
    @Max(value = 400, message = "Weight must be less than or equal to 400")
    private Integer weight;
}
