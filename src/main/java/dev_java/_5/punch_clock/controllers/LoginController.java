package dev_java._5.punch_clock.controllers;

import dev_java._5.punch_clock.entities.User;
import dev_java._5.punch_clock.entities.UserAuthenticationDTO;
import dev_java._5.punch_clock.service.TokenService;
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
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity login(@RequestBody @Valid UserAuthenticationDTO authData){
        var authenticationToken = new UsernamePasswordAuthenticationToken(
                authData.email(), authData.password());
        var authentication = manager.authenticate(authenticationToken);
        var tokenJWT = tokenService.createToken((User) authentication.getPrincipal());
        return ResponseEntity.ok().body(new TokenDTO(tokenJWT));
    }

    private record TokenDTO(String tokenJWT) {
    }
}
