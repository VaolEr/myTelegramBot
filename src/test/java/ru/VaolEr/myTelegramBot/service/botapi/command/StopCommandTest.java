package ru.VaolEr.myTelegramBot.service.botapi.command;

import org.junit.jupiter.api.DisplayName;
import ru.VaolEr.myTelegramBot.botapi.command.BotCommand;
import ru.VaolEr.myTelegramBot.botapi.command.StopCommand;

import static ru.VaolEr.myTelegramBot.botapi.command.BotCommandName.STOP;

@DisplayName("Unit-level testing for StopCommand")
public class StopCommandTest extends AbstractBotCommandTest{
    @Override
    String getCommandName() {
        return STOP.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return StopCommand.getMessageText();
    }

    @Override
    BotCommand getCommand() {
        return new StopCommand(botSendMessageService);
    }
}
