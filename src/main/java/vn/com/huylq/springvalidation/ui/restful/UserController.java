package vn.com.huylq.springvalidation.ui.restful;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import vn.com.huylq.springvalidation.domain.dto.request.UserRequestDTO;
import vn.com.huylq.springvalidation.domain.dto.response.GeneralResponse;
import vn.com.huylq.springvalidation.domain.dto.response.ResponseStatusCode;
import vn.com.huylq.springvalidation.domain.dto.response.UserResponseDTO;
import vn.com.huylq.springvalidation.domain.enums.ResponseStatusCodeEnum;
import vn.com.huylq.springvalidation.domain.validator.group.OnCreate;
import vn.com.huylq.springvalidation.domain.validator.group.OnUpdate;

@RestController
@RequestMapping("/users")
@Validated
public class UserController {

    @GetMapping("/{id}")
    public GeneralResponse<UserResponseDTO> getUser(@PathVariable("id") @Min(5) int id) {
        return GeneralResponse.<UserResponseDTO>builder()
                .status(ResponseStatusCodeEnum.SUCCESS.getResponseStatusCode())
                .data(UserResponseDTO.builder().build())
                .build();
    }

    @PostMapping
    @Validated({OnCreate.class})
    public GeneralResponse<UserResponseDTO> createUser(@Valid @RequestBody UserRequestDTO request) {
        return GeneralResponse.<UserResponseDTO>builder()
                .status(ResponseStatusCodeEnum.SUCCESS.getResponseStatusCode())
                .data(UserResponseDTO.builder().build())
                .build();
    }

    @PutMapping("/{id}")
    @Validated({OnUpdate.class})
    public GeneralResponse<UserResponseDTO> updateUser(@PathVariable("id") Long id,
                                                       @Valid @RequestBody UserRequestDTO request) {
        return GeneralResponse.<UserResponseDTO>builder()
                .status(ResponseStatusCodeEnum.SUCCESS.getResponseStatusCode())
                .data(UserResponseDTO.builder().build())
                .build();
    }
}
