package com.github.javastudytelegrambot.jstb.command;

import org.junit.jupiter.api.DisplayName;

import static com.github.javastudytelegrambot.jstb.command.CommandName.STOP;
import static com.github.javastudytelegrambot.jstb.command.StopCommand.STOP_MESSAGE;

@DisplayName("Test for STOP command")
public class StopCommandTest extends AbstractCommandTest {
    @Override
    String getCommandName() {
        return STOP.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return STOP_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new StopCommand(sendBotMessageService, telegramUserService);
    }
}
