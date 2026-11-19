package com.basespringboot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.basespringboot.service.MembersService;
import com.basespringboot.dto.MembersRequest;
import com.basespringboot.dto.MembersResponse;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequestMapping ("/members")
@RestController 
@RequiredArgsConstructor 

public class MembersController {
    private final MembersService formService;

    @PostMapping 
    @ResponseStatus(HttpStatus.CREATED)
    public MembersResponse createForm(@Valid @RequestBody MembersRequest formRequest) {
        return formService.createMember(formRequest);
    }
}
