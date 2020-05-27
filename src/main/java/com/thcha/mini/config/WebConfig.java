package com.thcha.mini.config;


import com.thcha.mini.interceptor.HttpInterceptor;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.context.MessageSource;
// import org.springframework.context.annotation.Bean;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.context.MessageSource;
// import org.springframework.context.annotation.Bean;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.context.MessageSource;
// import org.springframework.context.annotation.Bean;

// import java.util.Locale;

// import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties.LocaleResolver;
import org.springframework.context.annotation.Configuration;
// import org.springframework.context.support.MessageSourceAccessor;
// import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
// import org.springframework.context.support.ReloadableResourceBundleMessageSource;
// import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
// import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
// import org.springframework.web.servlet.i18n.SessionLocaleResolver;


@Configuration
@EnableJpaRepositories(basePackages = "com.thcha.mini.repository", repositoryImplementationPostfix = "Impl")
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private HttpInterceptor httpInterceptor; 

    @Override
	public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(httpInterceptor) //new HttpInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/login","/admin/**");

        WebMvcConfigurer.super.addInterceptors(registry);            
    }
    
    // @Bean
    // // 메세지 소스 세팅
    // public MessageSource messageSource() {
    //     ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
    //     // WEB-INF 밑에 해당 폴더에서 properties를 찾는다.
    //     messageSource.setBasenames("classpath:/message/messages", "classpath:/message/label");
    //     //messageSource.setBasename("classpath:/message/messages");
    //     messageSource.setDefaultEncoding("UTF-8");
    //     messageSource.setCacheSeconds(3); // reload messages every 10 seconds
    //     return messageSource;
    // }
 
    // @Bean
    // // 메세지 엑세서 MessageSource 사용해도 되는데, 메소드가 더 많음
    // public MessageSourceAccessor getMessageSourceAccessor(MessageSource messageSource) {
    //     return new MessageSourceAccessor(messageSource);
    // }
 
 
    // @Autowired
    // public MessageSource messageSource;

    // @Bean
    // public ReloadableResourceBundleMessageSource messageSource() {
    //     ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
    //     //messageSource.setBasename("classpath:message/messages,classpath:message/label");
    //     //messageSource.setCacheSeconds(3);
    //     //messageSource.setDefaultEncoding("UTF-8");

    //     return messageSource;
    // }

    // /** Register intercepter **/
    // @Override
    // public void addInterceptors(InterceptorRegistry registry) {
    //     registry.addInterceptor(localeChangeInterceptor());

    // }


    // @Bean(name = "localeResolver")
    // public LocaleResolver sessionlocaleResolver() {
    //     SessionLocaleResolver localeResolver = new SessionLocaleResolver();

    //     localeResolver.setDefaultLocale(new Locale("ko"));
    //     return localeResolver;
    // }

    // @Bean
    // public LocaleChangeInterceptor localeChangeInterceptor() {
    //     LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
    //     localeChangeInterceptor.setParamName("locale");
    //     return localeChangeInterceptor;
    // }

    // /**
    //  * 메세지 소스를 생성한다.
    //  */
    // @Bean
    // public ReloadableResourceBundleMessageSource messageSource() {

    //     ReloadableResourceBundleMessageSource source = new ReloadableResourceBundleMessageSource();

    //     // 메세지 프로퍼티파일의 위치와 이름을 지정한다.
    //     source.setBasename("classpath:/message/**");

    //     // 기본 인코딩을 지정한다.
    //     source.setDefaultEncoding("UTF-8");

    //     // 프로퍼티 파일의 변경을 감지할 시간 간격을 지정한다.
    //     source.setCacheSeconds(5);

    //     // 없는 메세지일 경우 예외를 발생시키는 대신 코드를 기본 메세지로 한다.
    //     source.setUseCodeAsDefaultMessage(true);

    //     return source;
    // }

    // /**
    //  * 변경된 언어 정보를 기억할 로케일 리졸버를 생성한다. 여기서는 세션에 저장하는 방식을 사용한다.
    //  * 
    //  * @return
    //  */
    // @Bean
    // public SessionLocaleResolver localeResolver() {
    //     return new SessionLocaleResolver();
    // }

    // /**
    //  * 언어 변경을 위한 인터셉터를 생성한다.
    //  */
    // @Bean
    // public LocaleChangeInterceptor localeChangeInterceptor() {
    //     LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();

    //     interceptor.setParamName("lang");

    //     return interceptor;
    // }

    // /**
    //  * 인터셉터를 등록한다.
    //  */
    // @Override
    // public void addInterceptors(InterceptorRegistry registry) {
    //     registry.addInterceptor(this.localeChangeInterceptor());
    // }
}