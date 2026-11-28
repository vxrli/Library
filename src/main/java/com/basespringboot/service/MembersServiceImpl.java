package com.basespringboot.service;

import com.basespringboot.dto.MembersRequest;
import com.basespringboot.dto.MembersResponse;
import com.basespringboot.entity.Members;
import com.basespringboot.repository.MembersRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Locale;
import java.util.Objects;

@Service
public class MembersServiceImpl implements MembersService {

    private final MembersRepository membersRepository;

    public MembersServiceImpl(MembersRepository membersRepository) {
        this.membersRepository = membersRepository;
    }

    @Override
    @Transactional
    public MembersResponse createMembers(MembersRequest membersRequest) {
        if (membersRepository.findByEmail(membersRequest.getEmail()).isPresent()) {
            throw new RuntimeException("Member with email " + membersRequest.getEmail() + " already exists");
        }
        Members members = new Members();
        members.setName(membersRequest.getName());
        members.setFirstName(membersRequest.getFirstName());
        members.setEmail(membersRequest.getEmail());
        members.setPhone(membersRequest.getPhone());
        members.setInscriptionDate(membersRequest.getInscriptionDate());
        return toResponse(membersRepository.save(members));
    }

    @Override
    @Transactional(readOnly = true)
    public List<MembersResponse> searchByNom(String nom) {
        return membersRepository.findByNameContainingIgnoreCase(nom).stream()
                .map(this::toResponse)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public MembersResponse getMembersById(Long id) {
        Members members = membersRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Member not found with id: " + id));
        return toResponse(members);
    }

    @Override
    @Transactional(readOnly = true)
    public List<MembersResponse> getAllMembers() {
        return membersRepository.findAll().stream()
                .map(this::toResponse)
                .toList();
    }

    @Override
    @Transactional
    public MembersResponse updateMembers(Long id, MembersRequest membersRequest) {
        Members members = membersRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Member not found with id: " + id));
        members.setName(membersRequest.getName());
        members.setFirstName(membersRequest.getFirstName());
        members.setEmail(membersRequest.getEmail());
        members.setPhone(membersRequest.getPhone());
        members.setInscriptionDate(membersRequest.getInscriptionDate());
        return toResponse(membersRepository.save(members));
    }

    @Override
    @Transactional
    public void deleteMembers(Long id) {
        if (!membersRepository.existsById(id)) {
            throw new RuntimeException("Member not found with id: " + id);
        }
        membersRepository.deleteById(id);
    }

    private MembersResponse toResponse(Members members) {
        return new MembersResponse(
                members.getId(),
                members.getName(),
                members.getFirstName(),
                members.getEmail(),
                members.getPhone(),
                members.getInscriptionDate());
    }
}
