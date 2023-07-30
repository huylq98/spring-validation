package vn.com.huylq.springvalidation.domain.service.impl;

import jakarta.validation.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vn.com.huylq.springvalidation.domain.service.ValidationService;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class ValidationServiceImpl implements ValidationService {

    private final Validator validator;

    @Override
    public void validateUsingManuallyConfiguredValidator(Object input) {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator manualValidator = validatorFactory.getValidator();
        Set<ConstraintViolation<Object>> violations = manualValidator.validate(input);
        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }
    }

    @Override
    public void validateUsingPreconfiguredValidator(Object input) {
        Set<ConstraintViolation<Object>> violations = validator.validate(input);
        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }
    }
}
