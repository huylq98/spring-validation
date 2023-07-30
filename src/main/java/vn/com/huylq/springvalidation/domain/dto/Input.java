package vn.com.huylq.springvalidation.domain.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Input {

    @NotBlank
    private String field1;

    @Min(0)
    @Max(10)
    private Integer field2;

    @NotNull
    private Long field3;

    @Email
    private String field4;
}
