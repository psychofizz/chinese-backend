package hn.unah.lenguajes.chinese.resources;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class Seguridad {
    @Bean
    public PasswordEncoder EncodificarContrasenia() {
        return new BCryptPasswordEncoder(); // You can choose other password encoders as well
    }
}
