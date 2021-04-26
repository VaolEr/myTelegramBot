package ru.VaolEr.myTelegramBot.service.bot.command;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.VaolEr.myTelegramBot.botapi.command.BotCommand;
import ru.VaolEr.myTelegramBot.botapi.command.BotCommandContainer;
import ru.VaolEr.myTelegramBot.botapi.command.BotCommandName;
import ru.VaolEr.myTelegramBot.botapi.command.UnknownCommand;
import ru.VaolEr.myTelegramBot.service.BotSendMessageService;

import java.util.Arrays;

@DisplayName("Unit-level testing for BotCommandContainer")
public class BotCommandContainerTest {

    private BotCommandContainer botCommandContainer;

    @BeforeEach
    public void init() {
        BotSendMessageService botSendMessageService = Mockito.mock(BotSendMessageService.class);
        botCommandContainer = new BotCommandContainer(botSendMessageService);
    }

    @Test
    public void shouldGetAllTheExistingCommands() {
        //when-then
        Arrays.stream(BotCommandName.values())
                .forEach(commandName -> {
                    BotCommand command = botCommandContainer.retrieveCommand(commandName.getCommandName());
                    Assertions.assertNotEquals(UnknownCommand.class, command.getClass());
                });
    }

    @Test
    public void shouldReturnUnknownCommand() {
        //given
        String unknownCommand = "/fgjhdfgdfg";

        //when
        BotCommand command = botCommandContainer.retrieveCommand(unknownCommand);

        //then
        Assertions.assertEquals(UnknownCommand.class, command.getClass());
    }

}
