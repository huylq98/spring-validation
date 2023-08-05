package vn.com.huylq.springvalidation.domain.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import vn.com.huylq.springvalidation.domain.entity.Address;
import vn.com.huylq.springvalidation.domain.entity.Person;

public class PersonValidator implements Validator {

    private final AddressValidator addressValidator;

    public PersonValidator(AddressValidator addressValidator) {
        if (addressValidator == null) {
            throw new IllegalArgumentException("The supplied [Validator] is required and must not be null.");
        }
        if (!addressValidator.supports(Address.class)) {
            throw new IllegalArgumentException("The supplied [Validator] must support the validation of [Address] instances.");
        }
        this.addressValidator = addressValidator;
    }

    /**
     * This validator validates only Person instances
     */
    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "name", "name.empty");
        Person p = (Person) target;
        if (p.getAge() < 0) {
            errors.rejectValue("age", "negativeValue");
        } else if (p.getAge() > 100) {
            errors.rejectValue("age", "too.darn.old");
        }
        try {
            errors.pushNestedPath("address");
            ValidationUtils.invokeValidator(addressValidator, p.getAddress(), errors);
        } finally {
            errors.popNestedPath();
        }
    }
}
