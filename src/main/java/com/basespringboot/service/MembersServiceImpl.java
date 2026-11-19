package com.basespringboot.service;

import com.basespringboot.dto.MembersRequest;
import com.basespringboot.dto.MembersResponse;
import com.basespringboot.entity.Members;
import com.basespringboot.repository.MembersRepository;
import org.springframework.stereotype.Service;

@Service
public class MembersServiceImpl implements MembersService {

    private final MembersRepository membersRepository;

    public MembersServiceImpl(MembersRepository membersRepository) {
        this.membersRepository = membersRepository;
    }

    @Override
    public MembersResponse createMember(MembersRequest request) {
        Members member = new Members();
        member.setName(request.getName());
        member.setEmail(request.getEmail());

        Members saved = membersRepository.save(member);
        return new MembersResponse(saved.getId(), saved.getName(), saved.getEmail());
    }
}