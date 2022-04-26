package com.github.javastudytelegrambot.jstb.command;

public enum CommandName {

    START("/start"),
    STOP("/stop"),
    HELP("/help"),
    NO("not_command"),
    STAT("/stat"),
    ADD_GROUP_SUB("/addGroupSub"),
    LIST_GROUP_SUB("/listGroupSub"),
    DELETE_GROUP_SUB("/deleteGroupSub");

    private final String commandName;

    CommandName (String commandName) {
        this.commandName = commandName;
    }

    public String getCommandName() {
        return commandName;
    }
}
