package com.basespringboot.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter 
@AllArgsConstructor 
public class MembersResponse {

    private Long id;
    private String name;
    private String email;
}
