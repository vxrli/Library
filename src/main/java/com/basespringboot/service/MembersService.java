package com.basespringboot.service;

import com.basespringboot.dto.MembersRequest;
import com.basespringboot.dto.MembersResponse;

import java.util.List;

public interface MembersService {

    MembersResponse createMembers(MembersRequest membersRequest);

    MembersResponse getMembersById(Long id);

    List<MembersResponse> getAllMembers();

    List<MembersResponse> searchByNom(String name);

    MembersResponse updateMembers(Long id, MembersRequest membersRequest);

    void deleteMembers(Long id);
}
