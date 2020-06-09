package pl.kurs.java.encrypt.error;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ValidAlgoValidator.class)
public @interface ValidAlgo {
    String message() default "Unknown algo name";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
