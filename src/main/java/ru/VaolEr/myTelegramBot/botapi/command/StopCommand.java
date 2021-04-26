package ru.VaolEr.myTelegramBot.botapi.command;

import org.telegram.telegrambots.meta.api.objects.Update;
import ru.VaolEr.myTelegramBot.service.BotSendMessageService;

public class StopCommand implements BotCommand{

    private final BotSendMessageService botSendMessageService;

    private static final String STOP_MESSAGE = "Уже уходите? Так жаль...";

    public StopCommand(BotSendMessageService botSendMessageService) {
        this.botSendMessageService = botSendMessageService;
    }

    public static String getMessageText() {
        return STOP_MESSAGE;
    }

    @Override
    public void execute(Update update) {
        botSendMessageService.sendMessage(update.getMessage().getChatId().toString(), STOP_MESSAGE);
    }
}
