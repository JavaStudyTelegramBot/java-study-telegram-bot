package com.github.javastudytelegrambot.jstb.service;

import com.github.javastudytelegrambot.jstb.bot.JavaStudyTelegramBot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.List;

@Service
public class SendBotMessageServiceImpl implements SendBotMessageService {
    private final JavaStudyTelegramBot javaStudyTelegramBot;

    @Autowired
    public SendBotMessageServiceImpl(JavaStudyTelegramBot javaStudyTelegramBot) {
        this.javaStudyTelegramBot = javaStudyTelegramBot;
    }

    @Override
    public void sendMessage(String chatId, String message) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.enableHtml(true);
        sendMessage.setText(message);
        try {
            javaStudyTelegramBot.execute(sendMessage);
        } catch (TelegramApiException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void sendMessage(String chatId, List<String> listMessage) {
        if (listMessage.isEmpty())
            return;
        listMessage.forEach(message -> sendMessage(chatId, message));
    }
}
