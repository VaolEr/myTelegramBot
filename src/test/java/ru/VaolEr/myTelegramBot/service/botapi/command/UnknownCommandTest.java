package ru.VaolEr.myTelegramBot.service.botapi.command;

import org.junit.jupiter.api.DisplayName;
import ru.VaolEr.myTelegramBot.botapi.command.BotCommand;
import ru.VaolEr.myTelegramBot.botapi.command.UnknownCommand;

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
