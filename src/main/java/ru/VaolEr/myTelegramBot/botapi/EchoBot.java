package ru.VaolEr.myTelegramBot.botapi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Service
public class EchoBot extends TelegramLongPollingBot {

    // This is telegram bot token
    @Value("${app.bots.tokens.echoBotToken}")
    private String botToken;

    // This is telegram bot username
    @Value("${app.bots.usernames.echoBotUsername}")
    private String botUsername;


    @Override
    public String getBotUsername() {
        return botUsername;
    }

    @Override
    public String getBotToken() { return botToken; }

    @Override
    public void onUpdateReceived(Update update) {
        try {
            if (update.hasMessage() && update.getMessage().hasText()) {
                Message inMessage = update.getMessage();
                SendMessage outMessage = new SendMessage();
                outMessage.setChatId(String.valueOf(inMessage.getChatId()));
                outMessage.setText(inMessage.getText());
                execute(outMessage);
            }
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
