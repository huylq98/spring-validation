package vn.com.huylq.springvalidation.domain.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ErrorResponse {

    private String requestId;
    private String errorCode;
    private String errorMessage;
}
