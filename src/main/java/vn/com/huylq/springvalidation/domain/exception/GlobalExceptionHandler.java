package vn.com.huylq.springvalidation.domain.exception;

import jakarta.servlet.ServletRequest;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.util.ContentCachingRequestWrapper;
import vn.com.huylq.springvalidation.domain.dto.response.ErrorResponse;
import vn.com.huylq.springvalidation.domain.dto.response.GeneralResponse;
import vn.com.huylq.springvalidation.domain.dto.response.ResponseStatusCode;
import vn.com.huylq.springvalidation.kernel.utils.JsonUtils;

import java.nio.charset.StandardCharsets;
import java.util.List;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({MethodArgumentNotValidException.class})
    public GeneralResponse<ErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException e, WebRequest request) {
        log.error("Request Body is invalid", e);
        ContentCachingRequestWrapper requestWrapper = (ContentCachingRequestWrapper) ((ServletWebRequest) request).getNativeRequest();
        String requestJson = new String(requestWrapper.getContentAsByteArray(), StandardCharsets.UTF_8);
        ErrorResponse errorResponse = JsonUtils.fromJson(requestJson, ErrorResponse.class);
        return GeneralResponse.<ErrorResponse>builder()
                .status(ResponseStatusCode.builder()
                        .code("01")
                        .message(e.getBindingResult().getAllErrors().get(0).getDefaultMessage())
                        .build())
                .data(errorResponse)
                .build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({ConstraintViolationException.class})
    public GeneralResponse<Void> handleConstraintViolationException(ConstraintViolationException e) {
        log.error("Request Parameter is invalid", e);
        return GeneralResponse.<Void>builder()
                .status(ResponseStatusCode.builder()
                        .code("01")
                        .message(e.getMessage())
                        .build())
                .build();
    }
}
