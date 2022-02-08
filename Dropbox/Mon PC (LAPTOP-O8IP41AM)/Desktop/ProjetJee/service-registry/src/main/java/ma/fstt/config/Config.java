package ma.fstt.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class Config {

    @Configuration
    public class webConfig implements WebMvcConfigurer{
        @Override
        public void addCorsMappings(CorsRegistry corsRegistry) {
            corsRegistry.addMapping("/**").allowedOrigins("http://localhost:4200").allowedMethods("GET", "POST","PUT", "DELETE");
        }
    }
}