package com.github.javastudytelegrambot.jstb.command;

import org.junit.jupiter.api.DisplayName;

import static com.github.javastudytelegrambot.jstb.command.CommandName.START;
import static com.github.javastudytelegrambot.jstb.command.StartCommand.START_MESSAGE;

@DisplayName("Test for UNKNOWN command")
public class StartCommandTest extends AbstractCommandTest {
    @Override
    String getCommandName() {
        return START.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return START_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new StartCommand(sendBotMessageService);
    }
}
