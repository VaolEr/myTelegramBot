package ru.VaolEr.myTelegramBot.botapi;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramWebhookBot;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.VaolEr.myTelegramBot.botapi.keyboard.handlers.callbackquery.CallbackQueryParser;
import ru.VaolEr.myTelegramBot.botapi.keyboard.PaymentYookassaWebhookBotKeyboard;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Objects;

@Component
@RequiredArgsConstructor
public class PaymentYookassaWebhookBot extends TelegramWebhookBot {

    private final CallbackQueryParser callbackQueryParser;
    private final PaymentYookassaWebhookBotKeyboard paymentYookassaWebhookBotKeyboard;

    private static final Logger logger = LoggerFactory.getLogger(PaymentYookassaWebhookBot.class);

    public static String COMMAND_PREFIX = "/";

    // This is telegram bot Username
    @Value("app.bots.usernames.paymentYookassaWebhookBotUsername")
    private String botUsername;

    // This is telegram bot token
    @Value("${app.bots.tokens.paymentYookassaWebhookBotToken}")
    private String botToken;


    @Value("api.bots.webhookPaths.paymentYookassaWebhookBotPath")
    private String botPath;

    @Override
    public String getBotUsername() {
        return this.botUsername;
    }

    @Override
    public String getBotToken() {
        return this.botToken;
    }

    @Override
    public String getBotPath() {
        return botPath;
    }

    @Override
    public BotApiMethod<?> onWebhookUpdateReceived(Update update) {

        if (update.hasCallbackQuery()) {
            logger.info("New callbackQuery from User: {} with data: {}", update.getCallbackQuery().getFrom().getUserName(),
                    update.getCallbackQuery().getData());
            return callbackQueryParser.processCallbackQuery(update.getCallbackQuery());
        }


        Message message = update.getMessage();

        if (message != null && message.hasText()) {

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MMMM-d HH:mm:ss", Locale.ENGLISH);
            logger.info("New message from User: {}, isBot: {}, chatId: {}, date: {}, with text: {}",
                        message.getFrom().getUserName(),
                        message.getFrom().getIsBot(),
                        message.getChatId(),
                        LocalDateTime.ofEpochSecond(message.getDate(), 0, ZoneOffset.ofHours(3)).format(formatter),
                        message.getText());
        }

        if(Objects.requireNonNull(update.getMessage()).getText().equals("KBD")){
            return paymentYookassaWebhookBotKeyboard.sendInlineKeyBoardMessage(message.getChatId().toString());
        }

        if (update.hasMessage() && update.getMessage().hasText()) {
            SendMessage sendMessage = new SendMessage();
            sendMessage.setChatId(message.getChatId().toString());
            sendMessage.setText("Well, all information looks like noise until you break the code.");
            return sendMessage;
        }
        return null;
    }


}
