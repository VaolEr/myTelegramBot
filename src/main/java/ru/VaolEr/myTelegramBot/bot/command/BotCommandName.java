package ru.VaolEr.myTelegramBot.bot.command;

public enum BotCommandName {
    NOT_EXIST(""),
    START("/start"),
    STOP("/stop"),
    HELP("/help");

    private final String botCommandName;

    BotCommandName(String botCommandName) {
        this.botCommandName = botCommandName;
    }

    public String getCommandName() {
        return botCommandName;
    }
}
