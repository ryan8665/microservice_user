package com.ns.user.backend.service;

import com.ns.core.model.UserDetails;
import com.ns.core.model.UserProfile;
import com.ns.core.repository.ProfileRepository;
import com.ns.user.backend.entity.Users;
import com.ns.user.util.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenServiceImpl implements TokenService{

    @Autowired
    private ProfileRepository profileRepository;

    @Override
    public Boolean isTokenValid(String token) {
        return null;
    }

    @Override
    public String save(Users user , Boolean isLogin){
        String token = Token.generateNewToken();
        profileRepository.save(new UserProfile(token, null, getUserDetails(user), new Date(), false));
        return token;
    }

    @Override
    public void update(UserProfile user) {
        profileRepository.Update(user);
    }

    @Override
    public UserProfile findByToken(String token) {
        UserProfile user = profileRepository.fidById(token);
        return user;
    }


    public  UserDetails getUserDetails(Users user) {
        UserDetails userDetails = new UserDetails();
        userDetails.setAddress(user.getAddress());
        userDetails.setCellphone(user.getCellphone());
        userDetails.setCreateDate(user.getCreateDate());
        userDetails.setDescription(user.getDescription());
        userDetails.setEmail(user.getEmail());
        userDetails.setExpire(user.getExpire());
        userDetails.setFamily(user.getFamily());
        userDetails.setName(user.getName());
        userDetails.setId(user.getId());
        userDetails.setLocal(user.getLocail());
        userDetails.setLocation(user.getLocation());
        userDetails.setLock(user.getDisable());
        userDetails.setLoginTry(user.getLoginTry());
        userDetails.setPassword(user.getPassword());
        userDetails.setSalt(user.getSalt());
        userDetails.setWebsite(user.getWebsite());
        return userDetails;
    }


}
