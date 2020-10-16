package com.ns.user.backend.service;

import com.ns.core.model.UserDetails;
import com.ns.user.backend.entity.Users;
import com.ns.user.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.sql.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public Users getUserByCellphone(String cellphone) {
        Users user = repository.getByCellphone(cellphone);
        return user;
    }

    @Override
    public void saveUser(Users user) {

    }

    @Override
    public void saveUser(UserDetails userDetails) {
        repository.save(preparerData(userDetails));
    }

    @Override
    public void deleteUserById(String cellphone) {
        repository.setUserDeleted(cellphone);
    }

    @Override
    public void deleteUserByCellphone(String cellphone) {
        repository.deleteByCellphone(cellphone);
    }

    @Override
    public List<Users> findAllUsers() {
        return repository.findAll();
    }


    private Users preparerData(UserDetails userDetails) {
        Users users = new Users();
        users.setAddress(userDetails.getAddress());
        users.setCellphone(userDetails.getCellphone());
        users.setCreateDate(new Date(System.currentTimeMillis()));
        users.setDescription(userDetails.getDescription());
        users.setEmail(userDetails.getEmail());
        users.setExpire(null);
        users.setFamily(userDetails.getFamily());
        users.setLocail(userDetails.getLocal());
        users.setLocation(userDetails.getLocation());
        users.setDeleted(0);
        users.setLoginTry("0");
        users.setPassword(userDetails.getPassword());
        users.setName(userDetails.getName());
        users.setSalt(generateSalt().toString());
        users.setWebsite(userDetails.getWebsite());
        return users;
    }

    public byte[] generateSalt() {
        SecureRandom random = new SecureRandom();
        byte bytes[] = new byte[20];
        random.nextBytes(bytes);
        return bytes;
    }


}
