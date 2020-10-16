package com.ns.user.backend.controller;

import com.ns.user.backend.dto.EducationResponse;
import com.ns.user.backend.dto.GeneralResponse;
import com.ns.user.backend.service.EducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/service")
public class EducationController {

    @Autowired
    EducationService service;

    @PutMapping("/education/")
    public GeneralResponse saveEducation(){
        GeneralResponse response = new GeneralResponse();
        return null;
    }

    @DeleteMapping("/education/")
    public GeneralResponse deleteEducation(){
        GeneralResponse response = new GeneralResponse();
        return null;
    }

    @GetMapping("/education/")
    public void retrieveEducation(){
        GeneralResponse response = new GeneralResponse();
    }

    @PostMapping("/education/")
    public EducationResponse updateEducation(){
        EducationResponse response = new EducationResponse();
       return null;

    }

}
