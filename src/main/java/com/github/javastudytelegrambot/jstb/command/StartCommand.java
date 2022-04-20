package com.github.javastudytelegrambot.jstb.command;

import com.github.javastudytelegrambot.jstb.service.SendBotMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

/**
 * START {@link Command}.
 */

public class StartCommand implements Command {
    private final SendBotMessageService sendBotMessageService;

    public final static String START_MESSAGE = "Хай! Я JavaStudy Bot, я могу экономить тебе время!\n" +
                                                "Как?! Все очень просто.\n" +
                                                "Я могу подписать тебя на группы и " +
                                                "присылать уведомления, когда в группе выйдет новый пост.\n" +
                                                "Тебе нужно будет каждый раз заходить в десятки групп, а просто заглянуть ко мне!";

    public StartCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), START_MESSAGE);
    }
}
