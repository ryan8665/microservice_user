package com.ns.user.backend.controller;





import com.ns.core.repository.ProfileRepository;
import com.ns.user.backend.entity.Users;
import com.ns.user.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    UserRepository repository;

    @Autowired
    private ProfileRepository profileRepository;


    @GetMapping("/test")
    public String getTest(){
        List<Users> users = repository.findAll();

        for (Users users1: users) {

            return "Hello! "+users1.getName() ;
        }
        return "khali";
    }
}
