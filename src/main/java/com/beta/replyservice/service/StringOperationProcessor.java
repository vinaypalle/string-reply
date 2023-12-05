package com.beta.replyservice.service;

public class StringOperationProcessor {

    private StringOperationStrategy stringOperationStrategy;

    public StringOperationProcessor(StringOperationStrategy stringOperationStrategy)
    {
        this.stringOperationStrategy = stringOperationStrategy;
    }

    public String apply(String value)
    {
        return stringOperationStrategy.apply(value);
    }
}
