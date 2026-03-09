//package com.jbm.payments.app.controller;
//
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import com.jbm.payments.app.dto.AuthRequest;
//import com.jbm.payments.app.dto.AuthResponse;
//import com.jbm.payments.app.dto.RegisterRequest;
//import com.jbm.payments.app.service.AuthService;
//
//@RestController
//@RequestMapping("/api/auth")
////@RequiredArgsConstructor
//public class AuthController {
//
//    private final AuthService authService;
//    
//    public AuthController(AuthService authService) {
//    	this.authService=authService;
//    	
//    }
//
//    // ==========================
//    // REGISTER
//    // ==========================
//    @PostMapping("/register")
//    public ResponseEntity<AuthResponse> register(
//            @RequestBody RegisterRequest request) {
//
//        String token = authService.register(request);
//
////        return ResponseEntity.ok(
////                AuthResponse.builder()
////                        .token(token)
////                        .build()
////        );
//        AuthResponse response = new AuthResponse();
//        response.setToken(token);
//
//        return ResponseEntity.ok(response);
//        
//        
//    }
//
//    // ==========================
//    // LOGIN
//    // ==========================
//    @PostMapping("/login")
//    public ResponseEntity<AuthResponse> login(
//            @RequestBody AuthRequest request) {
//
//        String token = authService.login(
//                request.getEmail(),
//                request.getPassword()
//        );
//
////        return ResponseEntity.ok(
////                AuthResponse.builder()
////                        .token(token)
////                        .build()
////        );
//        
//        AuthResponse response = new AuthResponse();
//        response.setToken(token);
//
//        return ResponseEntity.ok(response);
//        
//        
//    }
//}




package com.jbm.payments.app.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.jbm.payments.app.dto.AuthRequest;
import com.jbm.payments.app.dto.AuthResponse;
import com.jbm.payments.app.dto.RegisterRequest;
import com.jbm.payments.app.service.AuthService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    // ==========================
    // REGISTER
    // ==========================
    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request) {

        String token = authService.register(request);

        AuthResponse response = new AuthResponse();
        response.setToken(token);

        return ResponseEntity.ok(response);
    }

    // ==========================
    // LOGIN
    // ==========================
    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {

        String token = authService.login(
                request.getEmail(),
                request.getPassword()
        );

        AuthResponse response = new AuthResponse();
        response.setToken(token);

        return ResponseEntity.ok(response);
    }
}








