package com.beta.replyservice.exception;

import com.beta.replyservice.ReplyMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {

    @ExceptionHandler(InvalidArgumentException.class)
    public ResponseEntity<ReplyMessage> handleInvalidArgumentException(InvalidArgumentException exception)
    {
        ReplyMessage replyMessage = new ReplyMessage(exception.getMessage());
        return new ResponseEntity<>(replyMessage, HttpStatus.BAD_REQUEST);
    }
}
