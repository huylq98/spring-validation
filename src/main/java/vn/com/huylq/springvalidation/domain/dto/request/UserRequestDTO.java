package vn.com.huylq.springvalidation.domain.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import vn.com.huylq.springvalidation.domain.validator.annotation.IpAddress;
import vn.com.huylq.springvalidation.domain.validator.group.OnCreate;
import vn.com.huylq.springvalidation.domain.validator.group.OnUpdate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UserRequestDTO {

    @Null(groups = {OnCreate.class})
    @NotNull(groups = {OnUpdate.class})
    private Long id;

    @NotNull(message = "Username cannot be null")
    @NotBlank(message = "Username cannot be blank")
    private String username;

    private String password;

    @IpAddress
    private String ipAddress;

    private String requestId;
}
