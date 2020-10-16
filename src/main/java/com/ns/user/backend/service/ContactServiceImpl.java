package com.ns.user.backend.service;


import com.ns.core.model.UserProfile;
import com.ns.core.util.Empty;
import com.ns.user.backend.dto.ContactDto;
import com.ns.user.backend.entity.Contacts;
import com.ns.user.backend.exceptions.DataNotCorrectException;
import com.ns.user.backend.exceptions.DuplicateException;
import com.ns.user.backend.exceptions.OwnerException;
import com.ns.user.backend.exceptions.TokenValidationException;
import com.ns.user.backend.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    ContactRepository contactRepository;

    @Autowired
    TokenService tokenService;

    @Override
    public void saveContact(ContactDto contact,String token) throws TokenValidationException {
        UserProfile profile = tokenService.findByToken(token);

        if(Empty.isEmpty(profile.getUserDetails().getId())){
            throw new TokenValidationException();
        }

        Contacts cn = new Contacts();
        cn.setName(contact.getName());
        cn.setPhone(contact.getPhone());
        cn.setUsersId(profile.getUserDetails().getId());
        contactRepository.save(cn);

    }



    @Override
    public void updateContact(ContactDto contact,String token) throws TokenValidationException ,DataNotCorrectException ,OwnerException ,
            DataNotCorrectException , DuplicateException{

        UserProfile profile = tokenService.findByToken(token);

        if(Empty.isEmpty(profile.getUserDetails().getId())){
            throw new TokenValidationException();
        }

        if(Empty.isEmpty(contact.getId())){
            throw new DataNotCorrectException();
        }

        Contacts co = contactRepository.getContactsByIdAndUsersId(contact.getId(),
                profile.getUserDetails().getId());


        if(Empty.isEmpty(co)){
            throw new OwnerException();
        }



        Contacts cn = new Contacts();
        cn.setId(contact.getId());
        cn.setName(contact.getName());
        cn.setPhone(contact.getPhone());
        cn.setUsersId(profile.getUserDetails().getId());
        contactRepository.save(cn);
    }

    @Override
    public void deleteContact(Long id,String token) throws TokenValidationException {
        UserProfile profile = tokenService.findByToken(token);
        if(Empty.isEmpty(profile.getUserDetails().getId())){
            throw new TokenValidationException();
        }
        contactRepository.deleteById(id);
    }

    @Override
    public List<ContactDto> retrieveContact(String token) throws TokenValidationException {
        UserProfile profile = tokenService.findByToken(token);
        if(Empty.isEmpty(profile.getUserDetails().getId())){
            throw new TokenValidationException();
        }
        List<Contacts> list = contactRepository.findByUsersId(profile.getUserDetails().getId());

        if(Empty.isNotEmpty(list)){
            List<ContactDto>  contactDtoList =  new ArrayList<>();
            for (Contacts contacts : list) {
                contactDtoList.add(new ContactDto(contacts.getId(),
                        contacts.getPhone(),contacts.getName()));
            }
            return contactDtoList;
        }

        return null;
    }
}
