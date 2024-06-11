package com.evraz.rabbitmq.controller;

import com.evraz.rabbitmq.producer.MessageSender;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/messages")
@RequiredArgsConstructor
public class MessageController {

    private final MessageSender messageSender;

    @PostMapping
    public String sendMessage(@RequestBody String message) {

        return "Message sent: " + message;
    }
}
