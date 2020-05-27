package com.thcha.mini.config;

//import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceAccessor;
//import org.springframework.web.servlet.LocaleResolver;

@Configurable
public class MessageConfig {

    @Autowired
    MessageSource messageSource;

    //@Autowired
    //private LocaleResolver localeResolver;

    @Autowired
    private static MessageSourceAccessor msAcc;

    // public void setMessageSourceAccessor(MessageSourceAccessor msAcc) {
    //     MessageConfig.msAcc = msAcc;
    // }

    public static String getMessage(String code) {

        //return msAcc.getMessage(code, Locale.getDefault());
        return msAcc.getMessage(code);

        // HttpServletRequest httpRequest = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        // return msAcc.getMessage(code, httpRequest.getLocale());
    }

    public static String getMessage(String code, Object[] objs) {    
        //return msAcc.getMessage(code, objs, Locale.getDefault());
        return msAcc.getMessage(code, objs);
    }
}