package mtzg.carlos.spring_security.auth;

import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthRequest {

    public static final String NO_ANGLE_BRACKETS_MESSAGE = "must not contain angle brackets";
    public static final String NO_ANGLE_BRACKETS_REGEX = "^[^<>]*$";

    @Pattern(regexp = NO_ANGLE_BRACKETS_REGEX, message = NO_ANGLE_BRACKETS_MESSAGE)
    private String email;

    @Pattern(regexp = NO_ANGLE_BRACKETS_REGEX, message = NO_ANGLE_BRACKETS_MESSAGE)
    private String password;
}
