package com.github.javastudytelegrambot.jstb.command;

import com.github.javastudytelegrambot.jstb.bot.JavaStudyTelegramBot;
import com.github.javastudytelegrambot.jstb.service.SendBotMessageService;
import com.github.javastudytelegrambot.jstb.service.SendBotMessageServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public abstract class AbstractCommandTest {
    protected JavaStudyTelegramBot javaStudyTelegramBot = Mockito.mock(JavaStudyTelegramBot.class);
    protected SendBotMessageService sendBotMessageService = new SendBotMessageServiceImpl(javaStudyTelegramBot);

    abstract String getCommandName();

    abstract String getCommandMessage();

    abstract Command getCommand();

    @Test
    @DisplayName("Command execution correctly")
    public void shouldCorrectExecuteCommand() throws TelegramApiException {
        Long chatId = 123654896596L;

        Update update = new Update();
        Message message = Mockito.mock(Message.class);
        Mockito.when(message.getChatId()).thenReturn(chatId);
        Mockito.when(message.getText()).thenReturn(getCommandName());
        update.setMessage(message);

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId.toString());
        sendMessage.setText(getCommandMessage());
        sendMessage.enableHtml(true);

        getCommand().execute(update);

        Mockito.verify(javaStudyTelegramBot).execute(sendMessage);
    }
}
