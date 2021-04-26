package ru.VaolEr.myTelegramBot.botapi.keyboard.handlers.callbackquery;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import ru.VaolEr.myTelegramBot.service.ReplyMessageService;

@Component
@RequiredArgsConstructor
public class HelpCallbackQueryHandler implements CallbackQueryHandler {

    private static final CallbackQueryType HANDLER_QUERY_TYPE = CallbackQueryType.HELP;
    private final ReplyMessageService messageService;

    @Override
    public SendMessage handleCallbackQuery(CallbackQuery callbackQuery) {

        final String chatID = callbackQuery.getMessage().getChatId().toString();

        return messageService.getReplyMessage(chatID, "reply.query.help");
    }

    @Override
    public CallbackQueryType getHandlerQueryType() {
        return HANDLER_QUERY_TYPE;
    }

}
