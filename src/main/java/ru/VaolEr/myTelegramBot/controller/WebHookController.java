package ru.VaolEr.myTelegramBot.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.VaolEr.myTelegramBot.botapi.PaymentYookassaWebhookBot;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "${app.endpoints.base_path}" + "${app.endpoints.telegram-bots.base_url}",
        produces = MediaType.APPLICATION_JSON_VALUE)
public class WebHookController {
    private final PaymentYookassaWebhookBot paymentYookassaWebhookBot;

    @PostMapping(path = "/yookassa-payment-bot")
    public BotApiMethod<?> onUpdateReceived(@RequestBody Update update) {
        return paymentYookassaWebhookBot.onWebhookUpdateReceived(update);
    }
}
