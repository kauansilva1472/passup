
package br.com.soulpass.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {

        CorsConfiguration config = new CorsConfiguration();

        // Permite acesso do front-end React
        config.setAllowedOrigins(
                Arrays.asList(
                        "http://localhost:5173",
                        "http://127.0.0.1:5173",
                        "https://passup-three.vercel.app"
                )
        );

        // Metodos permitidos
        config.setAllowedMethods(
                Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS")
        );

        // Cabecalhos permitidos
        config.setAllowedHeaders(
                Arrays.asList("Content-Type", "Authorization")
        );

        UrlBasedCorsConfigurationSource source =
                new UrlBasedCorsConfigurationSource();

        source.registerCorsConfiguration("/**", config);

        return new CorsFilter(source);
    }
}
