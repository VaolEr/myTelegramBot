package ru.VaolEr.myTelegramBot.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.VaolEr.myTelegramBot.botapi.CommandTesterBot;
import ru.VaolEr.myTelegramBot.service.BotSendMessageService;

import java.util.Arrays;

@Slf4j
@Service
@RequiredArgsConstructor
public class CommandTesterBotSendMessageServiceImpl implements BotSendMessageService {

    private final CommandTesterBot bot;

    @Override
    public void sendMessage(String chatId, String message) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.enableHtml(true);
        sendMessage.setText(message);

        try {
            bot.execute(sendMessage);
        } catch (TelegramApiException e){
            log.error(Arrays.toString(e.getStackTrace()));
        }
    }
}
