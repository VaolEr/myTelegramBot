package ru.VaolEr.myTelegramBot.botapi.command;

import org.telegram.telegrambots.meta.api.objects.Update;
import ru.VaolEr.myTelegramBot.service.BotSendMessageService;

public class StartCommand implements BotCommand{

    private final BotSendMessageService botSendMessageService;

    private final static String START_MESSAGE = "Привет, путник! Я маленький бот и у меня лапки. Не ожидай большого функционала, пока я только познаю себя и этот мир.";

    public StartCommand(BotSendMessageService botSendMessageService) {
        this.botSendMessageService = botSendMessageService;
    }

    public static String getMessageText() {
        return START_MESSAGE;
    }

    @Override
    public void execute(Update update) {
        botSendMessageService.sendMessage(update.getMessage().getChatId().toString(), START_MESSAGE);
    }
}
