package com.finax.api.controllers;

import com.finax.api.domain.user.AuthDTO;
import com.finax.api.domain.user.UserDetailDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private AuthenticationManager authenticationManager;

    @PostMapping
    public ResponseEntity auth(@RequestBody @Valid AuthDTO auth) {
        var token = new UsernamePasswordAuthenticationToken(auth.email(), auth.password());
        var authentication = authenticationManager.authenticate(token);
        return ResponseEntity.ok().build();
    }
}
