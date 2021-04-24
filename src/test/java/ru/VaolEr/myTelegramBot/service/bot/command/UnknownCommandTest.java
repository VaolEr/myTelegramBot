package ru.VaolEr.myTelegramBot.service.bot.command;

import org.junit.jupiter.api.DisplayName;
import ru.VaolEr.myTelegramBot.bot.command.BotCommand;
import ru.VaolEr.myTelegramBot.bot.command.UnknownCommand;

@DisplayName("Unit-level testing for UnknownCommand")
public class UnknownCommandTest extends AbstractBotCommandTest{
    @Override
    String getCommandName() {
        return "/unknownCommand";
    }

    @Override
    String getCommandMessage() {
        return UnknownCommand.getMessageText();
    }

    @Override
    BotCommand getCommand() {
        return new UnknownCommand(botSendMessageService);
    }
}
