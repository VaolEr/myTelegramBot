package ru.VaolEr.myTelegramBot.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import ru.VaolEr.myTelegramBot.bot.CommandTesterBot;
import ru.VaolEr.myTelegramBot.bot.EchoBot;
import ru.VaolEr.myTelegramBot.bot.PaymentYookassaWebhookBot;

@Component
@RequiredArgsConstructor
public class BotsController {

    private final EchoBot echoBot;
    private final CommandTesterBot commandTesterBot;
    private final PaymentYookassaWebhookBot paymentBot;

    @EventListener(ContextRefreshedEvent.class)
    public void bot_activity() throws TelegramApiException {

        TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
        botsApi.registerBot(echoBot);

        TelegramBotsApi botsApi2 = new TelegramBotsApi(DefaultBotSession.class);
        botsApi2.registerBot(commandTesterBot);

    }
}
