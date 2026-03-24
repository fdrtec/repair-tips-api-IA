package org.openapitools.configuration;

import com.repairsystem.dto.CategoriaEquipamento;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;

@Configuration
public class EnumConverterConfiguration {

    @Bean(name = "org.openapitools.configuration.EnumConverterConfiguration.categoriaEquipamentoConverter")
    Converter<String, CategoriaEquipamento> categoriaEquipamentoConverter() {
        return new Converter<String, CategoriaEquipamento>() {
            @Override
            public CategoriaEquipamento convert(String source) {
                return CategoriaEquipamento.fromValue(source);
            }
        };
    }

}
