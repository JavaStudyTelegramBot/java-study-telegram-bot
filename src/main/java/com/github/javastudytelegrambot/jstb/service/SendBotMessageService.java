package com.github.javastudytelegrambot.jstb.service;

import org.springframework.stereotype.Service;

@Service
public interface SendBotMessageService {

    void sendMessage(String chatId, String message);
}
