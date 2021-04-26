package ru.VaolEr.myTelegramBot.service.bot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.VaolEr.myTelegramBot.botapi.command.BotCommandContainer;
import ru.VaolEr.myTelegramBot.service.impl.TestPollingBotSendMessageServiceImpl;

public class TestPollingBot extends TelegramLongPollingBot {

    public static String COMMAND_PREFIX = "/";

    // This is telegram bot token
    private String botToken = "botToken";

    // This is telegram bot username
    private String botUsername = "botName";

    private final BotCommandContainer botCommandContainer;

    public TestPollingBot() {
        this.botCommandContainer = new BotCommandContainer(new TestPollingBotSendMessageServiceImpl(this));
    }


    @Override
    public String getBotUsername() {
        return botUsername;
    }

    @Override
    public String getBotToken() {
        return botToken;
    }

    @Override
    public void onUpdateReceived(Update update) {

    }
}
