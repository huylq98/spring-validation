package vn.com.huylq.springvalidation.domain.service;

public interface ValidationService {

    void validateUsingManuallyConfiguredValidator(Object input);

    void validateUsingPreconfiguredValidator(Object input);
}
