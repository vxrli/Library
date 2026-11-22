package com.basespringboot.controller;

import com.basespringboot.dto.MembersRequest;
import com.basespringboot.dto.MembersResponse;
import com.basespringboot.service.MembersService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class MembersController {

    private final MembersService membersService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MembersResponse createMember(@Valid @RequestBody MembersRequest membersRequest) {
        return membersService.createMembers(membersRequest);
    }

    @GetMapping("/{id}")
    public MembersResponse getMembersById(@PathVariable Long id) {
        return membersService.getMembersById(id);
    }

    @GetMapping
    public List<MembersResponse> getAllMembers() {
        return membersService.getAllMembers();
    }

    @GetMapping("/search")
    public List<MembersResponse> searchByNom(@RequestParam String name) {
        return membersService.searchByNom(name);
    }

    @PutMapping("/{id}")
    public MembersResponse updateMember(@PathVariable Long id, @Valid @RequestBody MembersRequest membersRequest) {
        return membersService.updateMembers(id, membersRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMember(@PathVariable Long id) {
        membersService.deleteMembers(id);
    }
}
