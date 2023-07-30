package vn.com.huylq.springvalidation.domain.service.impl;

import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import vn.com.huylq.springvalidation.domain.dto.Input;
import vn.com.huylq.springvalidation.domain.service.ValidationService;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ValidationServiceImplTest {

    @Autowired
    ValidationService validationService;

    @Test
    void validateUsingManuallyConfiguredValidator() {
        Input input = Input.builder()
                .field1("     ")
                .field2(-2)
                .field3(null)
                .field4("@asd.com")
                .build();
        assertThrows(ConstraintViolationException.class, () -> validationService.validateUsingManuallyConfiguredValidator(input));
    }

    @Test
    void validateUsingPreconfiguredValidator() {
        Input input = Input.builder()
                .field1("     ")
                .field2(-2)
                .field3(null)
                .field4("@asd.com")
                .build();
        assertThrows(ConstraintViolationException.class, () -> validationService.validateUsingPreconfiguredValidator(input));
    }
}