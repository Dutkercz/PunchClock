package dev_java._5.punch_clock.infra.security;

import dev_java._5.punch_clock.repositories.UserRepository;
import dev_java._5.punch_clock.service.TokenService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UserRepository userRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        System.out.println("Iniciando filtro de segurança para: " + request.getRequestURI());

        var token = recoverToken(request);
        if (token != null){
            var subject = tokenService.getSubject(token);

            UserDetails user = userRepository.findByEmail(subject);
            if (user != null && SecurityContextHolder.getContext().getAuthentication() == null){
                var authentication = new UsernamePasswordAuthenticationToken
                        (user, null, user.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
            filterChain.doFilter(request, response);
        }
    }
    private String recoverToken(HttpServletRequest request) {
        var authorizationHeader = request.getHeader("Authorization");
        if(authorizationHeader != null){
            return authorizationHeader.replaceAll("Bearer ", "");
        }
        return null;
    }
}
