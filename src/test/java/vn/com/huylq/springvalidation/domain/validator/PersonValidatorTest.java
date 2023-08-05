package vn.com.huylq.springvalidation.domain.validator;

import org.junit.jupiter.api.Test;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.ValidationUtils;
import vn.com.huylq.springvalidation.domain.entity.Address;
import vn.com.huylq.springvalidation.domain.entity.Person;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

class PersonValidatorTest {

    AddressValidator addressValidator = new AddressValidator();
    PersonValidator personValidator = new PersonValidator(addressValidator);

    @Test
    void validateInvalidPerson_expectViolations() {
        Person person = Person.builder()
                .address(Address.builder().build())
                .build();
        BeanPropertyBindingResult bindingResult = new BeanPropertyBindingResult(person, Person.class.getName());
        ValidationUtils.invokeValidator(personValidator, person, bindingResult);
        assertTrue(bindingResult.getErrorCount() > 0);
        bindingResult.getAllErrors().forEach(error -> {
            Arrays.stream(error.getCodes()).forEach(System.out::println);
        });
    }
}