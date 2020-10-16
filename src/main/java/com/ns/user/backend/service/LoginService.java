package com.ns.user.backend.service;

public interface LoginService {
    boolean validate (String password, String salt , String hash) throws Exception;
}
