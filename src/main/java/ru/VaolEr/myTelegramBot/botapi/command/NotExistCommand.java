package ru.VaolEr.myTelegramBot.botapi.command;

import org.telegram.telegrambots.meta.api.objects.Update;
import ru.VaolEr.myTelegramBot.service.BotSendMessageService;

public class NotExistCommand implements BotCommand{

    private final BotSendMessageService botSendMessageService;

    private static final String NO_MESSAGE = "Я поддерживаю команды, начинающиеся со слеша(/).\n"
            + "Чтобы посмотреть список команд введите /help";

    public NotExistCommand(BotSendMessageService botSendMessageService) {
        this.botSendMessageService = botSendMessageService;
    }

    public static String getMessageText() {
        return NO_MESSAGE;
    }

    @Override
    public void execute(Update update) {
        botSendMessageService.sendMessage(update.getMessage().getChatId().toString(), NO_MESSAGE);
    }
}
