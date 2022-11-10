package com.example.springboot.NoleggioAutoSpringBoot.service.jwt;

import com.example.springboot.NoleggioAutoSpringBoot.entity.Utente;
import com.example.springboot.NoleggioAutoSpringBoot.repository.UtenteRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    public final UtenteRepository utenteRepository;

    public JwtUserDetailsService(UtenteRepository utenteRepository) {
        this.utenteRepository = utenteRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Utente utente = this.utenteRepository.findByUsername(username);
        if (utente != null) {
            User.UserBuilder builder;

            builder = User.withUsername(utente.getUsername());
            builder.password(utente.getPassword());

            String tipoUtente = utente.isAdmin() ? "ROLE_ADMIN" : "ROLE_USER";

            builder.authorities(tipoUtente);

            return builder.build();

        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }
}