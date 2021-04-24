package ru.VaolEr.myTelegramBot.bot.command;

import org.telegram.telegrambots.meta.api.objects.Update;

public interface BotCommand {

    /**
     * Main method, which is executing command logic.
     *
     * @param update provided {@link Update} object with all the needed data for command.
     */
    void execute(Update update);
}
