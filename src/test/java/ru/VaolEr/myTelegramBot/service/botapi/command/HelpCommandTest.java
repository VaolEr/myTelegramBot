package ru.VaolEr.myTelegramBot.service.botapi.command;

import org.junit.jupiter.api.DisplayName;
import ru.VaolEr.myTelegramBot.botapi.command.BotCommand;
import ru.VaolEr.myTelegramBot.botapi.command.HelpCommand;

import static ru.VaolEr.myTelegramBot.botapi.command.BotCommandName.HELP;

@DisplayName("Unit-level testing for HelpCommand")
public class HelpCommandTest extends AbstractBotCommandTest {

    @Override
    String getCommandName() {
        return HELP.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return HelpCommand.getMessageText();
    }

    @Override
    BotCommand getCommand() {
        return new HelpCommand(botSendMessageService);
    }
}
