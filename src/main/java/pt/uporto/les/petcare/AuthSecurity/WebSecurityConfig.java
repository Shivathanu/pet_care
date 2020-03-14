package pt.uporto.les.petcare.AuthSecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
    @Autowired
    private UserDetailsService jwtUserDetailsService;
    @Autowired
    private JwtRequestFilter jwtRequestFilter;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        // configure AuthenticationManager so that it knows from where to load
        // user for matching credentials
        // Use BCryptPasswordEncoder
        auth.userDetailsService(jwtUserDetailsService).passwordEncoder(passwordEncoder());
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
        httpSecurity.csrf().disable()
                // dont authenticate this particular request
                .authorizeRequests().antMatchers(
                "/api/utils/fillrecords",
                "/authenticate",
                "/register",
                "/api/pet-management/pets",
                "/api/pet-management/pets/0",
                "/api/pet-management/pets/1",
                "/api/pet-management/pets/2",
                "/api/pet-management/pets/3",
                "/api/pet-management/pets/4",
                "/api/pet-management/pets/petOwner/1",
                "/api/pet-management/pets/petOwner/2",
                "/api/pet-management/pets/petOwner/3",
                "/api/pet-management/pets/petOwner/4",
                "/api/pet-management/pets/petOwner/5",
                "/api/species",
                "/api/breeds",
                "/api/breeds/species/",
                "/api/breeds/species/1",
                "/api/breeds/species/2",
                "/api/species/1",
                "/api/species/2",
                "/api/breeds/1",
                "/api/breeds/2",
                "/api/pet_sitter",
                "/api/pet_sitter/-1",
                "/api/pet_sitter/0",
                "/api/pet_sitter/1",
                "/api/pet_sitter/2",
                "/api/pet_sitter/3",
                "/api/pet_sitter/4",
                "/api/pet_sitter/5",
                "/api/pet_sitter/6",
                "/api/pet_sitter/7",
                "/api/pet_sitter/8",
                "/api/pet_sitter/9",
                "/api/pet_sitter/10",
                "/api/pet_owner",
                "/api/pet_owner/-1",
                "/api/pet_owner/0",
                "/api/pet_owner/1",
                "/api/pet_owner/2",
                "/api/pet_owner/3",
                "/api/pet_owner/4",
                "/api/pet_owner/5",
                "/api/pet_owner/6",
                "/api/pet_owner/7",
                "/api/pet_owner/8",
                "/api/pet_owner/9",
                "/api/pet_owner/10",
                "api/pet_owner/1/image",
                "api/pet_owner/2/image",
                "api/pet_owner/3/image",
                "api/pet_owner/4/image",
                "api/pet_owner/5/image",
                "api/pet_owner/6/image",
                "api/pet_owner/7/image",
                "api/pet_owner/8/image",
                "api/pet_owner/9/image",
                "api/pet_owner/10/image",
                "/api/pet_sitter/1/image",
                "/api/pet_sitter/2/image",
                "/api/pet_sitter/3/image",
                "/api/pet_sitter/4/image",
                "/api/pet_sitter/5/image",
                "/api/pet_sitter/6/image",
                "/api/pet_sitter/7/image",
                "/api/pet_sitter/8/image",
                "/api/pet_sitter/9/image",
                "/api/pet_sitter/10/image",
                "/api/pet_sitter/find/**",
                "/api/region",
                "/api/region/1",
                "/api/region/2",
                "/api/region/3",
                "/api/region/4",
                "/api/country",
                "/api/country/1",
                "/api/country/2",
                "/api/region/country/1",
                "/api/region/country/2",
                "petownerform/1",
                "petownerform/2",
                "/api/review"
                ).permitAll().
                // all other requests need to be authenticated
                        anyRequest().authenticated().and().
                // make sure we use stateless session; session won't be used to
                // store user's state.
                        exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint).and().sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);        // Add a filter to validate the tokens with every request
        httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
    }
}