package ru.VaolEr.myTelegramBot.service.botapi.keyboard.handlers.callbackquery;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.Message;
import ru.VaolEr.myTelegramBot.botapi.keyboard.handlers.callbackquery.*;
import ru.VaolEr.myTelegramBot.service.ReplyMessageService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

public class CallbackQueryParserTest {

    private final ReplyMessageService messageService = Mockito.mock(ReplyMessageService.class);
    private final CallbackQuery callbackQuery = Mockito.mock(CallbackQuery.class);

    private final PaymentCallbackQueryHandler paymentCallbackQueryHandler = Mockito.mock(PaymentCallbackQueryHandler.class);
    private final HelpCallbackQueryHandler helpCallbackQueryHandler = Mockito.mock(HelpCallbackQueryHandler.class);

    List<CallbackQueryHandler> callbackQueryHandlers = new ArrayList<>();
    CallbackQueryParser callbackQueryParser;

    private final String testChatID = "123456";
    Chat chat;
    Message message;


    @BeforeEach
    public void setUp(){
//        callbackQueryHandlers.add(new PaymentCallbackQueryHandler(messageService));
//        callbackQueryHandlers.add(new HelpCallbackQueryHandler(messageService));

        callbackQueryHandlers.add(paymentCallbackQueryHandler);
        callbackQueryHandlers.add(helpCallbackQueryHandler);

        callbackQueryParser = new CallbackQueryParser(messageService, callbackQueryHandlers);

        chat = new Chat();
        chat.setId(Long.parseLong(testChatID));

        message = new Message();
        message.setChat(chat);
        message.setText("text");

    }

    @Test
    @Disabled
    public void processCallbackQueryTest(){

        //when(CallbackQueryType.valueOf(CallbackQueryType.class, "PAYMENT")).thenReturn(CallbackQueryType.PAYMENT);
        //TODO разобраться с моком енама

        when(messageService.getReplyMessage(any(), any())).thenReturn(SendMessage.builder()
                .chatId(testChatID)
                .text("query.test")
                .build());
        callbackQueryParser.processCallbackQuery(callbackQuery);
        assertEquals(callbackQueryParser.processCallbackQuery(callbackQuery), message.getText());


    }

}
