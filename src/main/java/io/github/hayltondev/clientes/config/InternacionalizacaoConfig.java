package io.github.hayltondev.clientes.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import java.util.Locale;

@Configuration
public class InternacionalizacaoConfig {

    //definindo o arquivo de mensagens e o configurando
    @Bean
    public MessageSource messageSource(){
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:messages"); //classpath: é reconhecido pelo spring como ir direto no diretório raiz do projeto
        messageSource.setDefaultEncoding("UTF-8");
        messageSource.setDefaultLocale(Locale.getDefault());
        return messageSource;
    }

    //LocalValidatorFactoryBean é o responsável por fazer a interpolação das mensagens lá nos bean validations das Entity
    @Bean
    public LocalValidatorFactoryBean validatorFactoryBean(){
        LocalValidatorFactoryBean beanValidatior = new LocalValidatorFactoryBean();
        beanValidatior.setValidationMessageSource(messageSource());
        return beanValidatior;
    }


}
