package vn.com.huylq.springvalidation.domain.entity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Address {

    private String street;
    private String city;
}
