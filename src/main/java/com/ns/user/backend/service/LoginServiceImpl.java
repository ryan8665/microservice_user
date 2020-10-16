package com.ns.user.backend.service;

import org.apache.commons.codec.binary.Base64;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

@Service
public class LoginServiceImpl implements LoginService {

    private static final int iterations = 20 * 1000;
    private static final int desiredKeyLen = 256;


    @Override
    public boolean validate(String password, String salt, String hash) throws Exception {
        String hashOfInput = hash(password, Base64.decodeBase64(salt));
        return hashOfInput.equals(hash);
    }


    private String hash(String password, byte[] salt) throws Exception {
        if (password == null || password.length() == 0)
            throw new IllegalArgumentException("Empty passwords are not supported.");
        SecretKeyFactory f = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        SecretKey key = f.generateSecret(new PBEKeySpec(
                password.toCharArray(), salt, iterations, desiredKeyLen));
        return Base64.encodeBase64String(key.getEncoded());
    }

}
