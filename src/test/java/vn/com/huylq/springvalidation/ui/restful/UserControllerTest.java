package vn.com.huylq.springvalidation.ui.restful;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import vn.com.huylq.springvalidation.domain.dto.request.UserRequestDTO;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = {UserController.class})
class UserControllerTest {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;

    @Test
    void givenNullRequestBodyAttributes_whenCreateUser_expectBadRequest() throws Exception {
        // given
        UserRequestDTO request = UserRequestDTO.builder()
                .requestId("12345")
                .build();

        // then
        mockMvc.perform(post("/users")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(objectMapper.writeValueAsString(request)))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    void givenEmptyRequestBodyAttributes_whenCreateUser_expectBadRequest() throws Exception {
        // given
        UserRequestDTO request = UserRequestDTO.builder()
                .username(" ")
                .requestId("12345")
                .build();

        // then
        mockMvc.perform(post("/users")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(objectMapper.writeValueAsString(request)))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    void givenInvalidRequestParameters_whenGetUser_expectBadRequest() throws Exception {
        mockMvc.perform(get("/users/4"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    void givenInvalidIpAddress_whenCreateUser_expectBadRequest() throws Exception {
        // given
        UserRequestDTO request = UserRequestDTO.builder()
                .username("huylq33")
                .password("123123a@")
                .ipAddress("255.255.255.256")
                .requestId("12345")
                .age(1)
                .build();

        // then
        mockMvc.perform(post("/users")
                        .header("lang", "vi")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(objectMapper.writeValueAsString(request)))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    void givenInvalidAge_whenCreateUser_expectBadRequest() throws Exception {
        // given
        UserRequestDTO request = UserRequestDTO.builder()
                .username("huylq33")
                .password("123123a@")
                .ipAddress("255.255.255.255")
                .requestId("12345")
                .age(-1)
                .build();

        // then
        mockMvc.perform(post("/users")
                        .header("lang", "vi")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(objectMapper.writeValueAsString(request)))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    void givenValidRequest_whenCreateUser_expectSuccess() throws Exception {
        // given
        UserRequestDTO request = UserRequestDTO.builder()
                .username("huylq33")
                .password("123123a@")
                .ipAddress("255.255.255.255")
                .requestId("12345")
                .age(2)
                .build();

        // then
        mockMvc.perform(post("/users")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(objectMapper.writeValueAsString(request)))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void givenInvalidCreateRequest_whenCreateUser_expectBadRequest() throws Exception {
        // given
        UserRequestDTO request = UserRequestDTO.builder()
                .id(1L)
                .username("huylq33")
                .password("123123a@")
                .ipAddress("255.255.255.255")
                .requestId("12345")
                .build();

        // then
        mockMvc.perform(post("/users")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(objectMapper.writeValueAsString(request)))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    void givenValidCreateRequest_whenCreateUser_expectBadRequest() throws Exception {
        // given
        UserRequestDTO request = UserRequestDTO.builder()
                .id(null)
                .username("huylq33")
                .password("123123a@")
                .ipAddress("255.255.255.255")
                .requestId("12345")
                .age(3)
                .build();

        // then
        mockMvc.perform(post("/users")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(objectMapper.writeValueAsString(request)))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void givenInvalidUpdateRequest_whenUpdateUser_expectBadRequest() throws Exception {
        // given
        UserRequestDTO request = UserRequestDTO.builder()
                .id(null)
                .username("huylq33")
                .password("123123a@")
                .ipAddress("255.255.255.255")
                .requestId("12345")
                .build();

        // then
        mockMvc.perform(put("/users/1")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(objectMapper.writeValueAsString(request)))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    void givenValidUpdateRequest_whenUpdateUser_expectBadRequest() throws Exception {
        // given
        UserRequestDTO request = UserRequestDTO.builder()
                .id(1L)
                .username("huylq33")
                .password("123123a@")
                .ipAddress("255.255.255.255")
                .requestId("12345")
                .age(2)
                .build();

        // then
        mockMvc.perform(put("/users/1")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(objectMapper.writeValueAsString(request)))
                .andDo(print())
                .andExpect(status().isOk());
    }
}