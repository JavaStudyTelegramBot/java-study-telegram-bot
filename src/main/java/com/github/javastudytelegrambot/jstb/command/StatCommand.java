package com.github.javastudytelegrambot.jstb.command;

import com.github.javastudytelegrambot.jstb.command.annotation.AdminCommand;
import com.github.javastudytelegrambot.jstb.service.SendBotMessageService;
import com.github.javastudytelegrambot.jstb.service.TelegramUserService;
import org.telegram.telegrambots.meta.api.objects.Update;

@AdminCommand
public class StatCommand implements Command {
    private final SendBotMessageService sendBotMessageService;
    private final TelegramUserService telegramUserService;

    public final static String STAT_MESSAGE = "JavaStudy Telegram Bot пользуются %s чел.";

    public StatCommand(SendBotMessageService sendBotMessageService, TelegramUserService telegramUserService) {
        this.sendBotMessageService = sendBotMessageService;
        this.telegramUserService = telegramUserService;
    }


    @Override
    public void execute(Update update) {
        String chatId = update.getMessage().getChatId().toString();
        int countActiveUsers = telegramUserService.retrieveAllActiveUsers().size();

        sendBotMessageService.sendMessage(chatId, String.format(STAT_MESSAGE, countActiveUsers));
    }
}
