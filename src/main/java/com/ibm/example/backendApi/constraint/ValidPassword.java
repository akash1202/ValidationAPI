package com.ibm.example.backendApi.constraint;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
@Documented
@Constraint(validatedBy = PasswordConstraintValidator.class)
@Target({FIELD,TYPE,ANNOTATION_TYPE})
@Retention(RUNTIME)
public @interface ValidPassword {
String message() default "Invalid password";
Class<?>[] groups() default{};
Class<? extends Payload>[] payload() default {};
}
