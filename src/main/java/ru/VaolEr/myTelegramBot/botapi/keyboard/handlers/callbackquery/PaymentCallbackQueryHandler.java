package ru.VaolEr.myTelegramBot.botapi.keyboard.handlers.callbackquery;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import ru.VaolEr.myTelegramBot.service.ReplyMessageService;

@Component
@RequiredArgsConstructor
public class PaymentCallbackQueryHandler implements CallbackQueryHandler {

    private static final CallbackQueryType HANDLER_QUERY_TYPE = CallbackQueryType.PAYMENT;
    private final ReplyMessageService messageService;

    @Override
    public SendMessage handleCallbackQuery(CallbackQuery callbackQuery) {

        //final long chatId = callbackQuery.getMessage().getChatId();
        final String chat = callbackQuery.getMessage().getChatId().toString();

        return messageService.getReplyMessage(chat, "reply.query.payment");
    }

    @Override
    public CallbackQueryType getHandlerQueryType() {
        return HANDLER_QUERY_TYPE;
    }
}
