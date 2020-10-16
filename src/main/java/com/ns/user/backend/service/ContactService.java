package com.ns.user.backend.service;

import com.ns.user.backend.dto.ContactDto;
import com.ns.user.backend.exceptions.TokenValidationException;

import java.util.List;

public interface ContactService {
    void saveContact(ContactDto contact,String token) throws TokenValidationException;

    void updateContact(ContactDto contact,String token) throws TokenValidationException;

    void deleteContact(Long id,String token) throws TokenValidationException ;

    List<ContactDto> retrieveContact(String token) throws TokenValidationException ;
}
