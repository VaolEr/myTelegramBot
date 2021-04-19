package ru.VaolEr.myTelegramBot.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import ru.VaolEr.myTelegramBot.service.EchoBot;

@Component
@RequiredArgsConstructor
public class EchoBotController {

    private final EchoBot echoBot;

    @EventListener(ContextRefreshedEvent.class)
    public void bot_activity() throws TelegramApiException {
        TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
        botsApi.registerBot(echoBot);
    }
}
