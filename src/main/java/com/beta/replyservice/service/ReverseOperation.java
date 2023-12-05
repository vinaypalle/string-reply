package com.beta.replyservice.service;

public class ReverseOperation implements StringOperationStrategy{

    @Override
    public String apply(String value)
    {
        return new StringBuilder(value).reverse().toString();
    }
}
