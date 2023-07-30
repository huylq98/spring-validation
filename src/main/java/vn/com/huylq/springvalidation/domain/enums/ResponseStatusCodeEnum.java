package vn.com.huylq.springvalidation.domain.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import vn.com.huylq.springvalidation.domain.dto.response.ResponseStatusCode;

@RequiredArgsConstructor
@Getter
public enum ResponseStatusCodeEnum {
    SUCCESS(ResponseStatusCode.builder().code("00").build()),
    BAD_REQUEST(ResponseStatusCode.builder().code("01").build());

    private final ResponseStatusCode responseStatusCode;
}
