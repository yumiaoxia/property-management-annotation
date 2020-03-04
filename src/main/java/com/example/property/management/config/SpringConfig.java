package com.example.property.management.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itsherman.dto.assembler.config.DtoMappingScannerRegister;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.RestController;

@Configuration
@ComponentScan(value = "com.example.property.management", useDefaultFilters = false,
        excludeFilters = {
                @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {RestController.class})
        })
public class SpringConfig {


    @Bean(initMethod = "registerDtoDefinitions")
    public DtoMappingScannerRegister dtoMappingScannerRegister() {
        DtoMappingScannerRegister dtoMappingScannerRegister = new DtoMappingScannerRegister();
        dtoMappingScannerRegister.setRecursion(true);
        dtoMappingScannerRegister.setBasePackage("com.example.property.management.web.dto");
        return dtoMappingScannerRegister;
    }

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setLocale(LocaleContextHolder.getLocale());
        return new ObjectMapper();
    }


}
