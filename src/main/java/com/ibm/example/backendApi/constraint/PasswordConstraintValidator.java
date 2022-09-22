package com.ibm.example.backendApi.constraint;


import org.springframework.context.annotation.Bean;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class PasswordConstraintValidator implements ConstraintValidator<ValidPassword, String> {
    private Pattern pattern;
    private Matcher matcher;
    private static final String PASSWORD_PATTERN="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,}$";
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        pattern= Pattern.compile(PASSWORD_PATTERN);
        matcher=pattern.matcher(value);
        return matcher.matches();
    }

    @Bean
    public javax.validation.Validator localValidatorFactoryBean() {
        return new LocalValidatorFactoryBean();
    }
}
