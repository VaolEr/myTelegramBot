package ru.VaolEr.myTelegramBot.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.VaolEr.myTelegramBot.bot.CommandTesterBot;
import ru.VaolEr.myTelegramBot.service.impl.CommandTesterBotSendMessageServiceImpl;

@DisplayName("Unit-level testing for CommandTesterBotSendMessageService")
public class CommandTesterBotSendMessageServiceTest {

    private BotSendMessageService botSendMessageService;
    private CommandTesterBot commandTesterBot;

    @BeforeEach
    public void init() {
        commandTesterBot = Mockito.mock(CommandTesterBot.class);
        botSendMessageService = new CommandTesterBotSendMessageServiceImpl(commandTesterBot);
    }

    @Test
    public void shouldProperlySendMessage() throws TelegramApiException {
        //given
        String chat_id = "Test_chat_id";
        String message = "Test message.";

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chat_id);
        sendMessage.setText(message);
        sendMessage.enableHtml(true);

        //when
        botSendMessageService.sendMessage(chat_id, message);

        //then
        Mockito.verify(commandTesterBot).execute(sendMessage);
    }

}
