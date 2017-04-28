package com.ua.codespace.service.impl;


import com.ua.codespace.service.MessageService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class MessageServiceProvider implements MessageService {
    @Value("${message.service.address}")
    private String address;

    private String message;

    @Value("#{T(java.time.LocalTime).now().hour < 12 ? 'Morning!' : 'Good afternoon!'}")
    private String greetings;

    public MessageServiceProvider(@Value("${message.service.defaultMessage}") String message) {
        this.message = message;
    }

    @Override
    public String printMessage() {
        return greetings + " " + message;
    }

    @Override
    public String getAddress() {
        return address;
    }

    public String getMessage() {
        return message;
    }

    public String getGreetings() {
        return greetings;
    }

}
