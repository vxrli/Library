package com.basespringboot.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MembersResponse {

    private Long id;
    private String name;
    private String firstName;
    private String email;
    private String phone;
    private Date inscriptionDate;
}
