package com.example.springboot.NoleggioAutoSpringBoot.controller.jwt;

import com.example.springboot.NoleggioAutoSpringBoot.config.jwt.JwtTokenUtil;
import com.example.springboot.NoleggioAutoSpringBoot.dto.UtenteDto;
import com.example.springboot.NoleggioAutoSpringBoot.entity.jwt.JwtRequest;
import com.example.springboot.NoleggioAutoSpringBoot.entity.jwt.JwtResponse;
import com.example.springboot.NoleggioAutoSpringBoot.service.UtenteService;
import com.example.springboot.NoleggioAutoSpringBoot.service.jwt.JwtUserDetailsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "api/jwt")
public class JwtAuthenticationController {

    private final AuthenticationManager authenticationManager;

    private final JwtTokenUtil jwtTokenUtil;

    private final JwtUserDetailsService userDetailsService;

    private final UtenteService utenteService;

    public JwtAuthenticationController(AuthenticationManager authenticationManager, JwtTokenUtil jwtTokenUtil, JwtUserDetailsService userDetailsService, UtenteService utenteService) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
        this.userDetailsService = userDetailsService;
        this.utenteService = utenteService;
    }


    @PostMapping(value = "/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());

        final String token = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new JwtResponse(token));
    }

    @GetMapping(value = "/user-profile")
    public ResponseEntity<UtenteDto> getProfiloUtente(@RequestHeader("Authorization") String authorization) {
        UtenteDto utenteDto = this.utenteService.cercaUtentePerUsername(this.jwtTokenUtil.getUsernameFromToken(authorization));
        return new ResponseEntity<>(utenteDto, HttpStatus.OK);
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}
