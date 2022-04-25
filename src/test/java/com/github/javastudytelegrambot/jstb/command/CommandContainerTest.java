package com.github.javastudytelegrambot.jstb.command;

import com.github.javastudytelegrambot.jstb.javarushclient.JavaRushGroupClient;
import com.github.javastudytelegrambot.jstb.service.GroupSubService;
import com.github.javastudytelegrambot.jstb.service.SendBotMessageService;
import com.github.javastudytelegrambot.jstb.service.TelegramUserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;

@DisplayName("Tests for CommandContainer")
public class CommandContainerTest {

    private CommandContainer commandContainer;

    @BeforeEach
    public void init() {
        SendBotMessageService sendBotMessageService = Mockito.mock(SendBotMessageService.class);
        TelegramUserService telegramUserService = Mockito.mock(TelegramUserService.class);
        JavaRushGroupClient javaRushGroupClient = Mockito.mock(JavaRushGroupClient.class);
        GroupSubService groupSubService = Mockito.mock(GroupSubService.class);
        commandContainer = new CommandContainer(sendBotMessageService, telegramUserService,
                                                javaRushGroupClient, groupSubService);
    }

    @Test
    @DisplayName("Getting all existing commands")
    public void shouldGetAllTheExistingCommands() {
        Arrays.stream(CommandName.values()).forEach(commandName -> {
                    Command command = commandContainer.retrieveCommand(commandName.getCommandName());
                    Assertions.assertNotEquals(UnknownCommand.class, command.getClass());
                    });
    }

    @Test
    @DisplayName("Getting UnknownCommand")
    public void shouldReturnUnknownCommand() {
        String unknownCommand = "/unknown_message";

        Command command = commandContainer.retrieveCommand(unknownCommand);

        Assertions.assertEquals(UnknownCommand.class, command.getClass());
    }

}
