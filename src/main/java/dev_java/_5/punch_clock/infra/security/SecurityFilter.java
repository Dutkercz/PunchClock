package dev_java._5.punch_clock.infra.security;

import dev_java._5.punch_clock.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SecurityFilter {

    @Autowired
    private TokenService tokenService;
}
