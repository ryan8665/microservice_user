package com.ns.user.backend.controller;

import com.ns.core.model.Authority;
import com.ns.core.model.UserProfile;
import com.ns.core.util.Empty;
import com.ns.user.backend.dto.DoLoginResponse;
import com.ns.user.backend.dto.LoginResponse;
import com.ns.user.backend.dto.UserDto;
import com.ns.user.backend.entity.Authorities;
import com.ns.user.backend.entity.Users;
import com.ns.user.backend.exceptions.*;
import com.ns.user.backend.service.AuthorityService;
import com.ns.user.backend.service.LoginService;
import com.ns.user.backend.service.TokenService;
import com.ns.user.backend.service.UserService;
import com.ns.user.enums.ResultEnum;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/service")
public class LoginController {
    private static final Logger logger = LogManager.getLogger(LoginController.class);
    @Autowired
    private UserService userService;

    @Autowired
    TokenService tokenService;

    @Autowired
    private AuthorityService authorityService;

    @Autowired
    private LoginService loginService;

    @GetMapping("/login/{cellphone}")
    public LoginResponse login(@PathVariable String cellphone) {
        LoginResponse response = new LoginResponse();
        try {
            Users user = userService.getUserByCellphone(cellphone);
            if (Empty.isEmpty(user)) {
                throw new CellphoneNotFoundException();
            }

            String token = tokenService.save(user,false);
            response.setResultCode(ResultEnum.success.getCode());
            response.setResultDesc(ResultEnum.success.getDesc());
            response.setToken(token);
            response.setSalt(user.getSalt());


        } catch (CellphoneNotFoundException e) {
            logger.error(e.getStackTrace());
            response.setResultCode(ResultEnum.cellphone_not_valid.getCode());
            response.setResultDesc(ResultEnum.cellphone_not_valid.getDesc());
        } catch (Exception e) {
            logger.error(e.getStackTrace());
            response.setResultCode(ResultEnum.other.getCode());
            response.setResultDesc(ResultEnum.other.getDesc());
        } finally {
            return response;
        }
    }


    @GetMapping("/login")
    public DoLoginResponse doLogin(@RequestHeader("hash") String hash,
                                   @RequestHeader("token") String token) {
        DoLoginResponse response = new DoLoginResponse();
        try {

            UserProfile user = tokenService.findByToken(token);
            if (Empty.isEmpty(user)) {
                throw new TokenValidationException();
            }
//            if (!loginService.validate(user.getUserDetails().getPassword(),
//                    user.getUserDetails().getSalt(), hash)) {
//                throw new BadUserCredentialException();
//            }
            if (user.getUserDetails().getLock() == 1) {
                throw new UserLockedException();
            }
            if (new Date().after(user.getUserDetails().getExpire())) {
                throw new UserExpiredException();
            }

            List<Authorities> authority = authorityService.getUserAuthority(user.getUserDetails().getId());
            List<Authority> list = new ArrayList<>();
            for (Authorities authorities : authority) {
                list.add(new Authority(authorities.getAuthority()));
            }

            user.setAuthorities(list);
            user.setLogin(true);
            user.setLastActivity(new Date());

            tokenService.update(user);

            response.setAuthorities(list);
            response.setUser(prepareUserResponse(user));
            response.setResultCode(ResultEnum.success.getCode());
            response.setResultDesc(ResultEnum.success.getDesc());

        } catch (TokenValidationException e) {
            logger.error(e.getStackTrace());
            response.setResultCode(ResultEnum.token_not_valid.getCode());
            response.setResultDesc(ResultEnum.token_not_valid.getDesc());
        } catch (BadUserCredentialException e) {
            logger.error(e.getStackTrace());
            response.setResultCode(ResultEnum.bad_user_credential.getCode());
            response.setResultDesc(ResultEnum.bad_user_credential.getDesc());
        } catch (UserLockedException e) {
            logger.error(e.getStackTrace());
            response.setResultCode(ResultEnum.user_locked.getCode());
            response.setResultDesc(ResultEnum.user_locked.getDesc());
        } catch (UserExpiredException e) {
            logger.error(e.getStackTrace());
            response.setResultCode(ResultEnum.user_expired.getCode());
            response.setResultDesc(ResultEnum.user_expired.getDesc());
        } catch (Exception e) {
            logger.error(e.getStackTrace());
            response.setResultCode(ResultEnum.other.getCode());
            response.setResultDesc(ResultEnum.other.getDesc());
        } finally {
            return response;
        }
    }

    private UserDto prepareUserResponse(UserProfile user) {
        UserDto dto = new UserDto();
        dto.setCellphone(user.getUserDetails().getCellphone());
        dto.setAddress(user.getUserDetails().getAddress());
        dto.setFamily(user.getUserDetails().getFamily());
        dto.setName(user.getUserDetails().getName());
        dto.setCreateDate(user.getUserDetails().getCreateDate());
        dto.setDescription(user.getUserDetails().getDescription());
        dto.setEmail(user.getUserDetails().getEmail());
        dto.setExpire(user.getUserDetails().getExpire());
        dto.setFamily(user.getUserDetails().getFamily());
        dto.setId(user.getUserDetails().getId());
        dto.setLocal(user.getUserDetails().getLocal());
        dto.setLocation(user.getUserDetails().getLocation());
        dto.setLock(user.getUserDetails().getLock());
        dto.setLoginTry(user.getUserDetails().getLoginTry());
        dto.setWebsite(user.getUserDetails().getWebsite());
        return dto;
    }



}
