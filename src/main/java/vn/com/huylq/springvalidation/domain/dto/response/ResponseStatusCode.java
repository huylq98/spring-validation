package vn.com.huylq.springvalidation.domain.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ResponseStatusCode {

    private String code;
    private String message;
    @Builder.Default
    private LocalDateTime responseTime = LocalDateTime.now();
}
