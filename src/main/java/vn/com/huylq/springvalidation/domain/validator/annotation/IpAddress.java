package vn.com.huylq.springvalidation.domain.validator.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import vn.com.huylq.springvalidation.domain.validator.IpAddressValidator;

import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {IpAddressValidator.class})
@Documented
public @interface IpAddress {

    String message() default "{IpAddress.invalid}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
