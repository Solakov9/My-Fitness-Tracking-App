package org.myfitnesstrackingapp.model.entity.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserLoginDTO {
    @NotBlank
    @Size(min = 3, max = 20, message = "Username must be between 3 and 20")
    private String username;
    @NotBlank
    @Size(min = 3, max = 20, message = "Password must be between 3 and 20")
    private String password;

}
