package ru.VaolEr.myTelegramBot.service.bot.command;

import org.junit.jupiter.api.DisplayName;
import ru.VaolEr.myTelegramBot.bot.command.BotCommand;
import ru.VaolEr.myTelegramBot.bot.command.NotExistCommand;

import static ru.VaolEr.myTelegramBot.bot.command.BotCommandName.NOT_EXIST;

@DisplayName("Unit-level testing for NotExistCommand")
public class NotExistCommandTest extends AbstractBotCommandTest{
    @Override
    String getCommandName() {
        return NOT_EXIST.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return NotExistCommand.getMessageText();
    }

    @Override
    BotCommand getCommand() {
        return new NotExistCommand(botSendMessageService);
    }
}
