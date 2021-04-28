package ru.VaolEr.myTelegramBot.service.impl;

import lombok.RequiredArgsConstructor;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.VaolEr.myTelegramBot.service.BotSendMessageService;
import ru.VaolEr.myTelegramBot.service.botapi.TestPollingBot;

@RequiredArgsConstructor
public class TestPollingBotSendMessageServiceImpl implements BotSendMessageService {

    private final TestPollingBot bot;

    @Override
    public void sendMessage(String chatId, String message) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.enableHtml(true);
        sendMessage.setText(message);

        try {
            bot.execute(sendMessage);
        } catch (TelegramApiException e){

            //TODO add logging to the project!!!
            e.printStackTrace();
        }
    }
}
