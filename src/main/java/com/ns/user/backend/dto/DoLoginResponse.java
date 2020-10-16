package com.ns.user.backend.dto;

import com.ns.core.model.Authority;

import java.io.Serializable;
import java.util.List;

public class DoLoginResponse  implements Serializable {
    private String resultCode;
    private String resultDesc;
    private UserDto user;
    private List<Authority> authorities;


    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultDesc() {
        return resultDesc;
    }

    public void setResultDesc(String resultDesc) {
        this.resultDesc = resultDesc;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public List<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<Authority> authorities) {
        this.authorities = authorities;
    }
}
