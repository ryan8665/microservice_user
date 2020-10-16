package com.ns.user.backend.service;

import com.ns.core.model.UserDetails;
import com.ns.user.backend.entity.Users;

import java.util.List;

public interface UserService {

    Users getUserByCellphone(String cellphone);

    void saveUser(Users user);

    void saveUser(UserDetails userDetails);

    void deleteUserById(String cellphone);

    void deleteUserByCellphone(String cellphone);

    List<Users> findAllUsers();

}
