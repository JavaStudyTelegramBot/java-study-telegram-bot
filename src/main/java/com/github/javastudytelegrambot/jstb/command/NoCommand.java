package com.github.javastudytelegrambot.jstb.command;

import com.github.javastudytelegrambot.jstb.service.SendBotMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

/**
 * NO {@link Command}
 */

public class NoCommand implements Command {
    private final SendBotMessageService sendBotMessageService;

    public final static String NO_MESSAGE = "Я могу разобрать команды начинающтеся со слеша(\"/\").\n" +
                                            "Введите \"/help\" для просмотра команд.";

    public NoCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }


    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), NO_MESSAGE);
    }
}
