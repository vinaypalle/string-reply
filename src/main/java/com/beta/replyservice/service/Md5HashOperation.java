package com.beta.replyservice.service;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5HashOperation implements StringOperationStrategy{

    @Override
    public String apply(String value)
    {
        try{
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digest = md.digest(value.getBytes());

            BigInteger num = new BigInteger(1, digest);

            String hashtext = num.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        }
        catch(NoSuchAlgorithmException exception)
        {
            throw new RuntimeException(exception);
        }
    }
}
