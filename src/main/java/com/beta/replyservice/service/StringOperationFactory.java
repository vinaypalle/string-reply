package com.beta.replyservice.service;

import com.beta.replyservice.exception.InvalidArgumentException;

public class StringOperationFactory {

    public static StringOperationStrategy getStringOperationStrategy(Character character)
    {
        StringOperationStrategy stringOperationStrategy = null;
        if(character == '1')
        {
            stringOperationStrategy = new ReverseOperation();
        }
        else if(character == '2')
        {
            stringOperationStrategy = new Md5HashOperation();
        }
        else
        {
            throw new InvalidArgumentException("Invalid input");
        }
        return stringOperationStrategy;
    }
}
