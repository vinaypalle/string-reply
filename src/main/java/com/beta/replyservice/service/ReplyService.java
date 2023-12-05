package com.beta.replyservice.service;

import com.beta.replyservice.exception.InvalidArgumentException;
import org.springframework.stereotype.Service;
@Service
public class ReplyService {

    public String processStringV2(String message)
    {
        String[] parts = message.split("-");
        if(parts.length != 2)
        {
            throw new InvalidArgumentException("Invalid input");
        }

        String rule = parts[0];
        String value = parts[1];

        String processedValue = applyRules(rule,value);
        return processedValue;
    }
    private String applyRules(String rule,String value)
    {
        String processedValue = value;
        for(int i=0;i<rule.length();i++)
        {
            StringOperationStrategy stringOperationStrategy = StringOperationFactory.getStringOperationStrategy(rule.charAt(i));
            StringOperationProcessor stringOperationProcessor = new StringOperationProcessor(stringOperationStrategy);
            processedValue = stringOperationProcessor.apply(processedValue);
        }
        return processedValue;
    }
}
