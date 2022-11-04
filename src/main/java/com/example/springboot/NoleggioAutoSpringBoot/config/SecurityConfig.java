package com.example.springboot.NoleggioAutoSpringBoot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private static final String[] ADMIN_UTENTI_MATCHER =
            {
                    "/utente/aggiungi_utente**",
                    "/utente/cancella_utente**",
                    "/utente/gestione_utenti**",
                    "/utente/aggiungi_utente",
                    "/utente/prenotazioni_da_approvare",
                    "/utente/prenotazioni_da_cancellare"
            };

    private static final String[] ADMIN_PRENOTAZIONI_MATCHER =
            {
                    "/prenotazione/prenotazioni_da_approvare**",
                    "/prenotazione/approva_prenotazione**",
                    "/prenotazione/prenotazioni_da_cancellare**"
            };

    private static final String[] ADMIN_AUTO_MATCHER =
            {
                    "/auto/gestione_auto",
                    "/auto/gestione_modifiche_auto",
                    "/auto/elimina_auto**",
                    "/auto/modifica_auto_{autoId}"
            };
    private static final String[] USER_UTENTI_MATCHER =
            {
                    "/utente/profilo",
                    "/utente/modifica_credenziali**",
                    "/utente/prenota_auto**"
            };

    private static final String[] USER_PRENOTAZIONI_MATCHER =
            {
                    "/prenotazione/auto_disponibili",
                    "/prenotazione/prenota_auto**",
            };


    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable()
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/resources/**").permitAll()
                .antMatchers("/index/**").permitAll()
                .antMatchers(ADMIN_AUTO_MATCHER).access("hasRole('ADMIN')")
                .antMatchers(ADMIN_UTENTI_MATCHER).access("hasRole('ADMIN')")
                .antMatchers(ADMIN_PRENOTAZIONI_MATCHER).access("hasRole('ADMIN')")
                .antMatchers(USER_UTENTI_MATCHER).access("hasRole('USER')")
                .antMatchers(USER_PRENOTAZIONI_MATCHER).access("hasRole('USER')");
    }

}



