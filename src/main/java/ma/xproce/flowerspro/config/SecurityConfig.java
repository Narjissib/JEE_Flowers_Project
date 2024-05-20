package ma.xproce.flowerspro.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {

        http
                .csrf((csrf) -> csrf.disable())
                .authorizeRequests(authorize -> authorize
                        .requestMatchers("/ajouter-arbre", "/deleteArbre",
                                "/editArbre","/indexpage","/plantes","/fleurpage","/ajouter-fleur","/editFleur",
                                "/deleteFleur","/panier","/vider-panier","/afficher-commande","/ajouter-adresse",
                                "/passer-commande","/confirmation","liste-commandes","/livraison","/livraisons",
                                "/livreur","/ajouter-livreur","/favori","/vider-favorie").authenticated()
                        .requestMatchers("/homePage", "/", "/webjars/**").permitAll())
                .formLogin((form) -> form
                        .loginPage("/login")
                        .defaultSuccessUrl("/indexpage", true)
                        .permitAll()
                )
                        .logout(logout -> logout
                                .logoutUrl("/logout")
                                .logoutSuccessUrl("/homePage")
                                .permitAll())
                        .httpBasic(Customizer.withDefaults()
                        );

        return http.build();

    }


    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails admin = User.withUsername("admin")
                .password("12345")
                .roles("admin", "delete", "update")
                .build();
        UserDetails user = User.withUsername("user")
                .password("12345")
                .roles("user")
                .build();
        return new InMemoryUserDetailsManager(admin, user);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

}
