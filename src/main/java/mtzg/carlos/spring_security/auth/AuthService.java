package mtzg.carlos.spring_security.auth;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import mtzg.carlos.spring_security.modules.jwt.JwtService;
import mtzg.carlos.spring_security.modules.user.IUserRepository;
import mtzg.carlos.spring_security.modules.user.Role;
import mtzg.carlos.spring_security.modules.user.UserModel;
import mtzg.carlos.spring_security.modules.user.dto.UserRegisterDto;
import mtzg.carlos.spring_security.utils.Utilities;

@Service
@RequiredArgsConstructor
public class AuthService {

        private final IUserRepository userRepository;
        private final PasswordEncoder passwordEncoder;
        private final JwtService jwtService;
        private final AuthenticationManager authenticationManager;

        public ResponseEntity<Object> register(UserRegisterDto request) {
                var user = UserModel.builder()
                                .name(request.getName())
                                .email(request.getEmail())
                                .password(passwordEncoder.encode(request.getPassword()))
                                .role(Role.USER)
                                .build();
                userRepository.save(user);
                var jwtToken = jwtService.generateToken(user);
                return Utilities.authResponse(HttpStatus.OK, "User registered successfully", jwtToken);
        }

        public ResponseEntity<Object> authentication(AuthRequest request) {
                authenticationManager.authenticate(
                                new UsernamePasswordAuthenticationToken(
                                                request.getEmail(),
                                                request.getPassword()));
                var user = userRepository.findByEmail(request.getEmail()).orElseThrow();
                var jwtToken = jwtService.generateToken(user);
                return Utilities.authResponse(HttpStatus.OK, "User authenticated successfully", jwtToken);
        }

}
