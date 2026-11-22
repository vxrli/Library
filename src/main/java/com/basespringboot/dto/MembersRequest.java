package com.basespringboot.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
public class MembersRequest {

    @NotBlank(message = "name is required")
    private String name;

    @NotBlank(message = "firstName is required")
    private String firstName;

    @NotBlank(message = "email is required")
    @Email(message = "email must be valid")
    private String email;

    private String phone;

    private Date inscriptionDate;
}
