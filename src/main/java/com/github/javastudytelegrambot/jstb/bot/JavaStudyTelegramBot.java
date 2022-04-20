package com.github.javastudytelegrambot.jstb.bot;

import com.github.javastudytelegrambot.jstb.command.CommandContainer;
import com.github.javastudytelegrambot.jstb.service.SendBotMessageServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.Locale;

import static com.github.javastudytelegrambot.jstb.command.CommandName.NO;

@Component
public class JavaStudyTelegramBot extends TelegramLongPollingBot {
    public static String PREFIX_FOR_COMMAND = "/";

    @Value("${bot.username}")
    String username;

    @Value("${bot.token}")
    String token;

    private final CommandContainer commandContainer;

    public JavaStudyTelegramBot() {
        this.commandContainer = new CommandContainer(new SendBotMessageServiceImpl(this));
    }

    @Override
    public String getBotUsername() {
        return username;
    }

    @Override
    public String getBotToken() {
        return token;
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String message = update.getMessage().getText().trim();
            if (message.startsWith(PREFIX_FOR_COMMAND)) {
                String commandIdentifier = message.split(" ")[0].toLowerCase(Locale.ROOT);
                commandContainer.retrieveCommand(commandIdentifier).execute(update);
            } else {
                commandContainer.retrieveCommand(NO.getCommandName()).execute(update);
            }
        }
    }
}
