package ru.VaolEr.myTelegramBot.service.bot.command;

import org.junit.jupiter.api.DisplayName;
import ru.VaolEr.myTelegramBot.botapi.command.BotCommand;
import ru.VaolEr.myTelegramBot.botapi.command.StartCommand;

import static ru.VaolEr.myTelegramBot.botapi.command.BotCommandName.START;

@DisplayName("Unit-level testing for StartCommand")
public class StartCommandTest extends AbstractBotCommandTest{
    @Override
    String getCommandName() {
        return START.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return StartCommand.getMessageText();
    }

    @Override
    BotCommand getCommand() {
        return new StartCommand(botSendMessageService);
    }
}
