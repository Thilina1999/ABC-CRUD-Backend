package com.example.abc.messages;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Setter
@Getter
public class Message {
    private String message;
    private HttpStatus status;
    private Object object;

    public Message(String message, HttpStatus status) {
        this.message = message;
        this.status = status;
    }

    public Message(String message, HttpStatus status, Object object) {
        this.message = message;
        this.status = status;
        this.object = object;
    }

}
