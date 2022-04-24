package com.github.javastudytelegrambot.jstb.command;

public enum CommandName {

    START("/start"),
    STOP("/stop"),
    HELP("/help"),
    NO("not_command"),
    STAT("/stat");

    private final String commandName;

    CommandName (String commandName) {
        this.commandName = commandName;
    }

    public String getCommandName() {
        return commandName;
    }
}
