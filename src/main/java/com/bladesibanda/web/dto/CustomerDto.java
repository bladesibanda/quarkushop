package com.bladesibanda.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {
    private Long id;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;
    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String telephone;
}
