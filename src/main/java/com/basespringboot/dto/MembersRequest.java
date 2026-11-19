package com.basespringboot.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;


@Getter 
@Setter 
public class MembersRequest {
    @NotBlank
    private String name;
    
    @NotBlank
    private String email;
}
