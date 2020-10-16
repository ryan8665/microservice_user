package com.ns.user.backend.service;

import com.ns.user.backend.entity.Authorities;

import java.util.List;

public interface AuthorityService {

    List<Authorities> getUserAuthority(Long id);
}
