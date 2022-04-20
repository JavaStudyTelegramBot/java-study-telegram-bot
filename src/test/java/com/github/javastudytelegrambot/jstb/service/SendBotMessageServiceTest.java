package com.github.javastudytelegrambot.jstb.service;

import com.github.javastudytelegrambot.jstb.bot.JavaStudyTelegramBot;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@DisplayName("Tests for SendBotMessageService")
public class SendBotMessageServiceTest {

    private JavaStudyTelegramBot javaStudyTelegramBot;
    private SendBotMessageService sendBotMessageService;

    @BeforeEach
    public void init() {
        javaStudyTelegramBot = Mockito.mock(JavaStudyTelegramBot.class);
        sendBotMessageService = new SendBotMessageServiceImpl(javaStudyTelegramBot);
    }

    @Test
    @DisplayName("The correctness of the message sent")
    public void shouldCorrectSendMessage() throws TelegramApiException {
        String chatId = "t_chatId";
        String message = "t_message";

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText(message);
        sendMessage.enableHtml(true);

        sendBotMessageService.sendMessage(chatId, message);

        Mockito.verify(javaStudyTelegramBot).execute(sendMessage);
    }
}
