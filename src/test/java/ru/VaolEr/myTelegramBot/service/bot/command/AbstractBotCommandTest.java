package ru.VaolEr.myTelegramBot.service.bot.command;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.VaolEr.myTelegramBot.botapi.command.BotCommand;
import ru.VaolEr.myTelegramBot.service.BotSendMessageService;
import ru.VaolEr.myTelegramBot.service.bot.TestPollingBot;
import ru.VaolEr.myTelegramBot.service.impl.TestPollingBotSendMessageServiceImpl;

/**
 * Abstract class for testing {@link BotCommand}s.
 */
abstract class AbstractBotCommandTest {

    protected TestPollingBot testPollingBot = Mockito.mock(TestPollingBot.class);
    protected BotSendMessageService botSendMessageService = new TestPollingBotSendMessageServiceImpl(testPollingBot);

    abstract String getCommandName();

    abstract String getCommandMessage();

    abstract BotCommand getCommand();

    @Test
    public void shouldProperlyExecuteCommand() throws TelegramApiException {
        //given
        Long chatId = 1234567824356L;

        Update update = new Update();
        Message message = Mockito.mock(Message.class);
        Mockito.when(message.getChatId()).thenReturn(chatId);
        Mockito.when(message.getText()).thenReturn(getCommandName());
        update.setMessage(message);

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId.toString());
        sendMessage.setText(getCommandMessage());
        sendMessage.enableHtml(true);

        //when
        getCommand().execute(update);

        //then
        Mockito.verify(testPollingBot).execute(sendMessage);
    }

}
