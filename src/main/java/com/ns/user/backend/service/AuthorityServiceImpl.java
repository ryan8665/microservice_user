package com.ns.user.backend.service;

import com.ns.user.backend.entity.Authorities;
import com.ns.user.backend.repository.AuthorityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorityServiceImpl implements AuthorityService {
    @Autowired
    private AuthorityRepository authorityRepository;


    @Override
    public List<Authorities> getUserAuthority(Long id) {
        List<Authorities> authority = authorityRepository.returnAuthorityByUserId(id);
        return authority;
    }
}
