package mtzg.carlos.spring_security.modules.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRegisterDto {

    public static final String NO_ANGLE_BRACKETS_MESSAGE = "must not contain angle brackets";
    public static final String NO_ANGLE_BRACKETS_REGEX = "^[^<>]*$";

    @NotBlank(message = "Name is required")
    @Pattern(regexp = NO_ANGLE_BRACKETS_REGEX, message = NO_ANGLE_BRACKETS_MESSAGE)
    private String name;

    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    @Pattern(regexp = NO_ANGLE_BRACKETS_REGEX, message = NO_ANGLE_BRACKETS_MESSAGE)
    private String email;

    @NotBlank(message = "Password is required")
    @Size(min = 8, message = "Password must be at least 8 characters long")
    @Pattern(regexp = NO_ANGLE_BRACKETS_REGEX, message = NO_ANGLE_BRACKETS_MESSAGE)
    private String password;

}
