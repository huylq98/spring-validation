package vn.com.huylq.springvalidation.domain.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import vn.com.huylq.springvalidation.domain.entity.Address;

import java.util.Stack;

public class AddressValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Address.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "street", "street.required");
        ValidationUtils.rejectIfEmpty(errors, "city", "city.required");
    }
}
