package com.basespringboot.service;
import com.basespringboot.dto.MembersRequest;
import com.basespringboot.dto.MembersResponse;

public interface MembersService {
    MembersResponse createMember(MembersRequest formRequest);
    
}
