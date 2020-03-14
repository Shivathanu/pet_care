package pt.uporto.les.petcare.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class CorsConfiguration implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry){
         //Here we have to check the port of client service: 4200.
        registry.addMapping("*").allowedOrigins("*").
                allowedMethods("GET","POST", "PUT", "DELETE","OPTIONS","HEAD","TRACE","CONNECT");
    }
}
