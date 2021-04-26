package ru.VaolEr.myTelegramBot.botapi.command;

import org.telegram.telegrambots.meta.api.objects.Update;
import ru.VaolEr.myTelegramBot.service.BotSendMessageService;

public class UnknownCommand implements BotCommand{

    private final BotSendMessageService botSendMessageService;

    private static final String UNKNOWN_MESSAGE = "Не понимаю вас \uD83D\uDE1F, напишите /help чтобы узнать что я понимаю.";

    public UnknownCommand(BotSendMessageService botSendMessageService) {
        this.botSendMessageService = botSendMessageService;
    }

    public static String getMessageText() {
        return UNKNOWN_MESSAGE;
    }

    @Override
    public void execute(Update update) {
        botSendMessageService.sendMessage(update.getMessage().getChatId().toString(), UNKNOWN_MESSAGE);
    }
}
