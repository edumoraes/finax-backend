package com.finax.api.controllers;

import com.finax.api.domain.user.AuthDTO;
import com.finax.api.domain.user.User;
import com.finax.api.domain.user.UserDetailDTO;
import com.finax.api.infra.security.TokenJwtDTO;
import com.finax.api.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

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
        var user = (User) authentication.getPrincipal();
        var tokenJWT = tokenService.generateToken(user);
        var tokenResponse = new TokenJwtDTO(user, tokenJWT);


        return ResponseEntity.ok(tokenResponse);
    }
}
