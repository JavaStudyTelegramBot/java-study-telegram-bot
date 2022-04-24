package com.github.javastudytelegrambot.jstb.command;

import com.github.javastudytelegrambot.jstb.repository.entity.TelegramUser;
import com.github.javastudytelegrambot.jstb.service.SendBotMessageService;
import com.github.javastudytelegrambot.jstb.service.TelegramUserService;
import org.telegram.telegrambots.meta.api.objects.Update;

/**
 * START {@link Command}.
 */

public class StartCommand implements Command {
    private final SendBotMessageService sendBotMessageService;
    private final TelegramUserService telegramUserService;

    public final static String START_MESSAGE = "Хай! Я JavaStudy Bot, я могу экономить тебе время!\n" +
                                                "Как?! Все очень просто.\n" +
                                                "Я могу подписать тебя на группы и " +
                                                "присылать уведомления, когда в группе выйдет новый пост.\n" +
                                                "Тебе нужно будет каждый раз заходить в десятки групп, а просто заглянуть ко мне!";

    public StartCommand(SendBotMessageService sendBotMessageService, TelegramUserService telegramUserService) {
        this.sendBotMessageService = sendBotMessageService;
        this.telegramUserService = telegramUserService;
    }

    @Override
    public void execute(Update update) {
        String chatId = update.getMessage().getChatId().toString();

        telegramUserService.findByChatId(chatId).ifPresentOrElse(
                telegramUser -> {
                    telegramUser.setActive(true);
                    telegramUserService.save(telegramUser);
                },
                () -> {
                    TelegramUser telegramUser = new TelegramUser();
                    telegramUser.setChatId(chatId);
                    telegramUser.setActive(true);
                    telegramUserService.save(telegramUser);
                }
        );

        sendBotMessageService.sendMessage(chatId, START_MESSAGE);
    }
}
