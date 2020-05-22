package com.thcha.mini.config;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//import org.springframework.web.servlet.i18n.CookieLocaleResolver;
//import org.springframework.web.servlet.i18n.FixedLocaleResolver;
//import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Configuration
public class LocaleConfig implements WebMvcConfigurer {
    
    @Bean
    public LocaleResolver localeResolver() {
        String lang = System.getProperty("lang");
        System.out.printf("\n\t>>> --- LocaleConfig.localeResolver : lang=[%s] --- <<<\n\n", lang);

        SessionLocaleResolver sessionLocaleResolver = new SessionLocaleResolver();
        sessionLocaleResolver.setDefaultLocale(new Locale(lang)); 
        return sessionLocaleResolver;

        //FixedLocaleResolver fixedLocaleResolver = new FixedLocaleResolver();
        //fixedLocaleResolver.setDefaultLocale(new Locale(lang)); 
        //fixedLocaleResolver.setDefaultLocale(Locale.KOREA); 
        //return fixedLocaleResolver;

        // CookieLocaleResolver cookieLocaleResolver = new CookieLocaleResolver();
        // cookieLocaleResolver.setDefaultLocale(Locale.KOREAN);
        // cookieLocaleResolver.setCookieName("APPLICATION_LOCALE");
        // return cookieLocaleResolver;
    }

    // @Bean
    // public LocaleChangeInterceptor localeChangeInterceptor() {
    //     LocaleChangeInterceptor lci = new LocaleChangeInterceptor();

    //     System.out.printf("\n\t>>> --- LocaleConfig.localeChangeInterceptor : lang=[%s] --- <<<\n\n", System.getProperty("lang"));
    //     lci.setParamName("locale");
    //     return lci;
    // }

    // @Override
    // public void addInterceptors(InterceptorRegistry registry) {
    //     registry.addInterceptor(localeChangeInterceptor());
    // }   
}