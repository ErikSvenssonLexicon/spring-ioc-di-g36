package se.lexicon.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "se.lexicon")
public class ComponentScanConfig {

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

}
