package com.pig.dead.utils;

import com.pig.dead.constants.EncryptConstant;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.Objects;

public class RSAUtil {
    private RSAUtil(){}

    private static final KeyPair keyPair = generateKey();

    private static KeyPair generateKey(){
        try{
            KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
            generator.initialize(EncryptConstant.SIZE);
            return generator.generateKeyPair();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static RSAPublicKey getRsaPublicKey(){
        return (RSAPublicKey) Objects.requireNonNull(keyPair).getPublic();
    }
    public static RSAPrivateKey getRsaPrivateKey(){
        return (RSAPrivateKey) Objects.requireNonNull(keyPair).getPrivate();
    }
}
