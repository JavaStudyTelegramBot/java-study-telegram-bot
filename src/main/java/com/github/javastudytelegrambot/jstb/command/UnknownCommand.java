package com.github.javastudytelegrambot.jstb.command;

import com.github.javastudytelegrambot.jstb.service.SendBotMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

/**
 * UNKNOWN {@link Command}
 */

public class UnknownCommand implements Command {
    private final SendBotMessageService sendBotMessageService;

    public static final String UNKNOWN_MESSAGE = "Я не знаю такой команды.\n" +
                                                "Введите \"/help\" для просмотра команд.";

    public UnknownCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }


    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), UNKNOWN_MESSAGE);
    }
}
