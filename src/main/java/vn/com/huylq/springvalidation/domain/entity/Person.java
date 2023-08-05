package vn.com.huylq.springvalidation.domain.entity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Person {

    private String name;
    private int age;
    private Address address;
}
