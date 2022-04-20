package com.github.javastudytelegrambot.jstb.command;

import org.junit.jupiter.api.DisplayName;

import static com.github.javastudytelegrambot.jstb.command.UnknownCommand.UNKNOWN_MESSAGE;

@DisplayName("Test for UNKNOWN command")
public class UnknownCommandTest extends AbstractCommandTest {
    @Override
    String getCommandName() {
        return "/unknown_command";
    }

    @Override
    String getCommandMessage() {
        return UNKNOWN_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new UnknownCommand(sendBotMessageService);
    }
}
