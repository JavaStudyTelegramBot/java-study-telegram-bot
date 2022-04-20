package com.github.javastudytelegrambot.jstb.command;

import com.github.javastudytelegrambot.jstb.service.SendBotMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

/**
 * STOP {@link Command}.
 */


public class StopCommand implements Command {
    private final SendBotMessageService sendBotMessageService;

    public final static String STOP_MESSAGE = "Отписал от всех групп \ud83d\ude2e\u200d\ud83d\udca8";

    public StopCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), STOP_MESSAGE);
    }
}
