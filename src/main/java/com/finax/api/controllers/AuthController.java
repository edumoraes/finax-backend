package com.finax.api.controllers;

import com.finax.api.domain.user.AuthDTO;
import com.finax.api.domain.user.User;
import com.finax.api.infra.security.TokenJwtDTO;
import com.finax.api.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity auth(@RequestBody @Valid AuthDTO auth) {
        var authenticationToken = new UsernamePasswordAuthenticationToken(auth.email(), auth.password());
        var authentication = manager.authenticate(authenticationToken);
        var tokenJWT = tokenService.generateToken((User) authentication.getPrincipal());
        var tokenResponse = new TokenJwtDTO(tokenJWT);

        return ResponseEntity.ok(tokenResponse);
    }
}
