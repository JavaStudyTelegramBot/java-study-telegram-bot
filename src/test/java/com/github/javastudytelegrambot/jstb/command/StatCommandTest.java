package com.github.javastudytelegrambot.jstb.command;

import org.junit.jupiter.api.DisplayName;

import static com.github.javastudytelegrambot.jstb.command.CommandName.STAT;
import static com.github.javastudytelegrambot.jstb.command.StatCommand.STAT_MESSAGE;

@DisplayName("Test for STAT command")
public class StatCommandTest extends AbstractCommandTest {
    @Override
    String getCommandName() {
        return STAT.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return STAT_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new StatCommand(sendBotMessageService, telegramUserService);
    }
}
