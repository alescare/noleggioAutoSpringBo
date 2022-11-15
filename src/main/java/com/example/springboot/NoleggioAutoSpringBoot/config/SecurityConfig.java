package com.example.springboot.NoleggioAutoSpringBoot.config;

import com.example.springboot.NoleggioAutoSpringBoot.config.jwt.JwtAuthenticationEntryPoint;
import com.example.springboot.NoleggioAutoSpringBoot.config.jwt.JwtRequestFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

    private final UserDetailsService jwtUserDetailsService;

    private final JwtRequestFilter jwtRequestFilter;

    public SecurityConfig(JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint, UserDetailsService jwtUserDetailsService, JwtRequestFilter jwtRequestFilter) {
        this.jwtAuthenticationEntryPoint = jwtAuthenticationEntryPoint;
        this.jwtUserDetailsService = jwtUserDetailsService;
        this.jwtRequestFilter = jwtRequestFilter;
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        // configure AuthenticationManager so that it knows from where to load
        // user for matching credentials
        // Use BCryptPasswordEncoder
        auth.userDetailsService(jwtUserDetailsService).passwordEncoder(passwordEncoder());
    }
   @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("http://localhost:4200").allowedMethods("DELETE", "POST", "GET");
            }
        };
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }




    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        // We don't need CSRF for this example
        httpSecurity.cors().and().csrf().disable()
                // dont authenticate this particular request
                .authorizeRequests().antMatchers("/api/jwt/authenticate").permitAll().
                antMatchers("/**").permitAll().
                // all other requests need to be authenticated
                        anyRequest().authenticated().and().
                // make sure we use stateless session; session won't be used to
                // store user's state.
                        exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint).and().sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        // Add a filter to validate the tokens with every request
        httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
    }


    /*
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

*/
  /*  @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable()
                .authorizeRequests()
                .antMatchers("/**").permitAll()
                .antMatchers("/resources/**").permitAll()
                .antMatchers("/index/**").permitAll()
                .antMatchers(ADMIN_AUTO_MATCHER).access("hasRole('ADMIN')")
                .antMatchers(ADMIN_UTENTI_MATCHER).access("hasRole('ADMIN')")
                .antMatchers(ADMIN_PRENOTAZIONI_MATCHER).access("hasRole('ADMIN')")
                .antMatchers(USER_UTENTI_MATCHER).access("hasRole('USER')")
                .antMatchers(USER_PRENOTAZIONI_MATCHER).access("hasRole('USER')");
    }
*/
}



