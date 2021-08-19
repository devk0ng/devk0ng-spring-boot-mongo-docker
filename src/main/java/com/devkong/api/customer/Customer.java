package com.devkong.api.customer;


import lombok.*;

@ToString
@Getter
@Setter
@AllArgsConstructor
public class Customer {
    private String id;
    private String firstName;
    private String lastName;
}
