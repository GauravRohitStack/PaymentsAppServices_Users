//package com.jbm.payments.app.service;
//
//
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import com.jbm.payments.app.dto.RegisterRequest;
//import com.jbm.payments.app.entity.User;
//import com.jbm.payments.app.entity.Role;
//import com.jbm.payments.app.repository.UserRepository;
//import com.jbm.payments.app.security.JwtService;
//
//@Service
////@RequiredArgsConstructor
//public class AuthService {
//
//    private final UserRepository userRepository;
//    private final PasswordEncoder passwordEncoder;
//    private final JwtService jwtService;
//    private final AuthenticationManager authenticationManager;
//
//    
//    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtService jwtService, AuthenticationManager authenticationManager) {
//    	this.userRepository=userRepository;
//    	this.passwordEncoder=passwordEncoder; 
//    	this.jwtService=jwtService; 
//    	this.authenticationManager=authenticationManager;
//    	
//    }
//    
//    // =========================
//    // REGISTER
//    // =========================
//    public String register(RegisterRequest request) {
//
//        // Check if email already exists
//        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
//            throw new RuntimeException("Email already registered");
//        }
//
//        // Create new user
//        User user = new User();
//        user.setName(request.getName());
//        user.setEmail(request.getEmail());
//        user.setPassword(passwordEncoder.encode(request.getPassword()));
//        user.setRoles(Role.ROLE_USER);
//
//        // Save user to database
//        userRepository.save(user);
//
//        // Generate JWT token
//        return jwtService.generateToken(user.getEmail());
//    }
//
//    // =========================
//    // LOGIN
//    // =========================
//    public String login(String email, String password) {
//
//        // Authenticate using Spring Security
//        authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(email, password)
//        );
//
//        // Generate JWT token
//        return jwtService.generateToken(email);
//    }
//}






package com.jbm.payments.app.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.jbm.payments.app.dto.RegisterRequest;
import com.jbm.payments.app.entity.User;
import com.jbm.payments.app.entity.Role;
import com.jbm.payments.app.repository.UserRepository;
import com.jbm.payments.app.security.JwtService;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthService(UserRepository userRepository,
                       PasswordEncoder passwordEncoder,
                       JwtService jwtService,
                       AuthenticationManager authenticationManager) {

        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    // =========================
    // REGISTER
    // =========================
    public String register(RegisterRequest request) {

        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new RuntimeException("Email already registered");
        }

        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
//        user.setRole(Role.ROLE_USER);
        user.addRole(Role.ROLE_USER);
   
        userRepository.save(user);

        return jwtService.generateToken(user.getEmail());
    }

    // =========================
    // LOGIN
    // =========================
    public String login(String email, String password) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(email, password)
        );

        return jwtService.generateToken(email);
    }
}









