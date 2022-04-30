package com.github.javastudytelegrambot.jstb.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SendBotMessageService {
    void sendMessage(String chatId, String message);

    void sendMessage(String chatId, List<String> listMessage);
}
