package com.github.javastudytelegrambot.jstb.command;

import com.github.javastudytelegrambot.jstb.service.SendBotMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

import static com.github.javastudytelegrambot.jstb.command.CommandName.*;

/**
 * HELP {@link Command}.
 */
public class HelpCommand implements Command {

    private final SendBotMessageService sendBotMessageService;

    public static final String HELP_MESSAGE = String.format("✨<b>Дотупные команды</b>✨\n\n" +
                                                "<b>Начать/закончить работу с ботом</b>\n" +
                                                "%s - начать работу со мной\n" +
                                                "%s - приостановить работу со мной\n\n" +
                                                "%s - получить помощь в работе со мной\n" +
                                                "%s - получить статистику бота",
                                    START.getCommandName(), STOP.getCommandName(), HELP.getCommandName(), STAT.getCommandName());

    public HelpCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        String chatId = update.getMessage().getChatId().toString();
        sendBotMessageService.sendMessage(chatId, HELP_MESSAGE);
    }
}