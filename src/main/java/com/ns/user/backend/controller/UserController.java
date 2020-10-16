package com.ns.user.backend.controller;


import com.ns.core.model.UserDetails;
import com.ns.core.model.UserProfile;
import com.ns.core.util.Empty;
import com.ns.user.backend.dto.GeneralResponse;
import com.ns.user.backend.dto.UserDto;
import com.ns.user.backend.dto.UserResponse;
import com.ns.user.backend.entity.Users;
import com.ns.user.backend.exceptions.DataNotCorrectException;
import com.ns.user.backend.exceptions.DuplicateException;
import com.ns.user.backend.service.TokenService;
import com.ns.user.backend.service.UserService;
import com.ns.user.enums.ResultEnum;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/service")
public class UserController {
    private static final Logger logger = LogManager.getLogger(UserController.class);

    @Autowired
    UserService userService;

    @Autowired
    TokenService tokenService;


    @PostMapping("/user")
    public GeneralResponse addUser(@RequestBody UserDetails userDetails) {
        GeneralResponse response = new GeneralResponse();
        try {
            if (Empty.isEmpty(userDetails.getCellphone())) {
                throw new DataNotCorrectException();
            }
            Users user = userService.getUserByCellphone(userDetails.getCellphone());
            if (Empty.isNotEmpty(user)) {
                throw new DuplicateException();
            }
            userService.saveUser(userDetails);
            response.setResultCode(ResultEnum.success.getCode());
            response.setResultDesc(ResultEnum.success.getDesc());

        } catch (DataNotCorrectException e) {
            response.setResultCode(ResultEnum.cellphone_not_valid.getCode());
            response.setResultDesc(ResultEnum.cellphone_not_valid.getDesc());
        } catch (DuplicateException e) {
            response.setResultCode(ResultEnum.success.getCode());
            response.setResultDesc(ResultEnum.success.getDesc());
        } catch (Exception e) {
            response.setResultCode(ResultEnum.success.getCode());
            response.setResultDesc(ResultEnum.success.getDesc());
        } finally {
            return response;
        }
    }

    @PutMapping("/user")
    public GeneralResponse updateUser(@RequestBody UserDetails userDetails) {
        GeneralResponse response = new GeneralResponse();
        try {
            if (Empty.isEmpty(userDetails.getCellphone())) {
                throw new DataNotCorrectException();
            }
            Users user = userService.getUserByCellphone(userDetails.getCellphone());
            if (Empty.isNotEmpty(user)) {
                throw new DuplicateException();
            }
            userService.saveUser(userDetails);

        } catch (DataNotCorrectException e) {
            e.printStackTrace();
        } catch (DuplicateException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return response;
        }
    }


    @DeleteMapping("/user/{cellphone}")
    public GeneralResponse deleteUser(@PathVariable String cellphone) {
        GeneralResponse response = new GeneralResponse();
        try {
            userService.deleteUserById(cellphone);
            response.setResultCode(ResultEnum.success.getCode());
            response.setResultDesc(ResultEnum.success.getDesc());
        } catch (Exception e) {
            response.setResultCode(ResultEnum.other.getCode());
            response.setResultDesc(ResultEnum.other.getDesc());
        } finally {
            return response;
        }

    }

    @GetMapping("/user")
    public List<Users> retrieveAllUsers() {
        List<Users> res = userService.findAllUsers();
        return res;
    }

    @GetMapping("/user/{token}")
    public UserResponse retrieveUser(@PathVariable String token) {
        UserResponse response = new UserResponse();
        try {
            UserProfile profile = tokenService.findByToken(token);
            Users user = userService.getUserByCellphone(profile.getUserDetails().getCellphone());
            UserDto dto = new UserDto();
            dto.setName(user.getName());
            dto.setFamily(user.getFamily());
            dto.setAddress(user.getAddress());
            dto.setCellphone(user.getCellphone());
            response.setUser(dto);

            response.setResultCode(ResultEnum.success.getCode());
            response.setResultDesc(ResultEnum.success.getDesc());
        } catch (Exception e) {
            response.setResultCode(ResultEnum.other.getCode());
            response.setResultDesc(ResultEnum.other.getDesc());
            e.printStackTrace();
        } finally {
            return response;
        }
    }
}
