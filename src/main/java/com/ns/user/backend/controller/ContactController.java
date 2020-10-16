package com.ns.user.backend.controller;

import com.ns.user.backend.dto.ContactDto;
import com.ns.user.backend.dto.ContactResponse;
import com.ns.user.backend.dto.GeneralResponse;
import com.ns.user.backend.exceptions.DataNotCorrectException;
import com.ns.user.backend.exceptions.OwnerException;
import com.ns.user.backend.exceptions.TokenValidationException;
import com.ns.user.backend.service.ContactService;
import com.ns.user.enums.ResultEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/service")
public class ContactController {

    @Autowired
    ContactService contactService;



    @PutMapping("/contact/")
    public GeneralResponse saveContact(@RequestHeader String token,
                                       @RequestBody ContactDto contactDto) {
        GeneralResponse response = new GeneralResponse();

        try {
            contactService.saveContact(contactDto,token);
            response.setResultCode(ResultEnum.success.getCode());
            response.setResultDesc(ResultEnum.success.getDesc());
        } catch (TokenValidationException e) {
            response.setResultCode(ResultEnum.token_not_valid.getCode());
            response.setResultDesc(ResultEnum.token_not_valid.getDesc());
            e.printStackTrace();
        } catch (NullPointerException e) {
            response.setResultCode(ResultEnum.token_not_valid.getCode());
            response.setResultDesc(ResultEnum.token_not_valid.getDesc());
            e.printStackTrace();
        } catch (Exception e) {
            response.setResultCode(ResultEnum.other.getCode());
            response.setResultDesc(ResultEnum.other.getDesc());
            e.printStackTrace();
        }finally {
            return response;
        }
    }

    @DeleteMapping("/contact")
    public GeneralResponse deleteContact(@RequestHeader String token,
                                         @RequestHeader Long id) {
        GeneralResponse response = new GeneralResponse();

        try {
            contactService.deleteContact(id,token);
            response.setResultCode(ResultEnum.success.getCode());
            response.setResultDesc(ResultEnum.success.getDesc());
        } catch (TokenValidationException e) {
            response.setResultCode(ResultEnum.token_not_valid.getCode());
            response.setResultDesc(ResultEnum.token_not_valid.getDesc());
            e.printStackTrace();
        } catch (NullPointerException e) {
            response.setResultCode(ResultEnum.token_not_valid.getCode());
            response.setResultDesc(ResultEnum.token_not_valid.getDesc());
            e.printStackTrace();
        } catch (Exception e) {
            response.setResultCode(ResultEnum.other.getCode());
            response.setResultDesc(ResultEnum.other.getDesc());
            e.printStackTrace();
        }finally {
            return response;
        }
    }

    @PostMapping("/contact")
    public GeneralResponse updateContact(@RequestHeader String token,
                                         @RequestBody ContactDto contactDto) {
        GeneralResponse response = new GeneralResponse();

        try {
            contactService.updateContact(contactDto,token);
            response.setResultCode(ResultEnum.success.getCode());
            response.setResultDesc(ResultEnum.success.getDesc());
        } catch (TokenValidationException e) {
            response.setResultCode(ResultEnum.token_not_valid.getCode());
            response.setResultDesc(ResultEnum.token_not_valid.getDesc());
            e.printStackTrace();
        } catch (NullPointerException e) {
            response.setResultCode(ResultEnum.token_not_valid.getCode());
            response.setResultDesc(ResultEnum.token_not_valid.getDesc());
            e.printStackTrace();
        } catch (OwnerException e) {
            response.setResultCode(ResultEnum.bad_user.getCode());
            response.setResultDesc(ResultEnum.bad_user.getDesc());
            e.printStackTrace();
        } catch (DataNotCorrectException e) {
            response.setResultCode(ResultEnum.dara_not_correct.getCode());
            response.setResultDesc(ResultEnum.dara_not_correct.getDesc());
            e.printStackTrace();
        } catch (Exception e) {
            response.setResultCode(ResultEnum.other.getCode());
            response.setResultDesc(ResultEnum.other.getDesc());
            e.printStackTrace();
        }finally {
            return response;
        }
    }

    @GetMapping("/contact")
    public ContactResponse retrieveContacts(@RequestHeader String token) {
        ContactResponse response = new ContactResponse();
        try {
            List<ContactDto> res =  contactService.retrieveContact(token);
            response.setContacts(res);
            response.setResultCode(ResultEnum.success.getCode());
            response.setResultDesc(ResultEnum.success.getDesc());
        } catch (TokenValidationException e) {
            response.setResultCode(ResultEnum.token_not_valid.getCode());
            response.setResultDesc(ResultEnum.token_not_valid.getDesc());
            e.printStackTrace();
        } catch (Exception e) {
            response.setResultCode(ResultEnum.other.getCode());
            response.setResultDesc(ResultEnum.other.getDesc());
            e.printStackTrace();
        }finally {
            return response;
        }
    }

}
