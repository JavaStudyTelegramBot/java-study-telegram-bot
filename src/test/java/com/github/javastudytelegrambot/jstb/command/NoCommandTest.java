package com.github.javastudytelegrambot.jstb.command;

import org.junit.jupiter.api.DisplayName;

import static com.github.javastudytelegrambot.jstb.command.CommandName.NO;
import static com.github.javastudytelegrambot.jstb.command.NoCommand.NO_MESSAGE;

@DisplayName("Test for NO command")
public class NoCommandTest extends AbstractCommandTest {
    @Override
    String getCommandName() {
        return NO.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return NO_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new NoCommand(sendBotMessageService);
    }
}
