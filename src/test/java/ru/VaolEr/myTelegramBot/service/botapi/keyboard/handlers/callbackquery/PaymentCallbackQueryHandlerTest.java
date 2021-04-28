package ru.VaolEr.myTelegramBot.service.botapi.keyboard.handlers.callbackquery;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.Message;
import ru.VaolEr.myTelegramBot.botapi.keyboard.handlers.callbackquery.CallbackQueryType;
import ru.VaolEr.myTelegramBot.botapi.keyboard.handlers.callbackquery.PaymentCallbackQueryHandler;
import ru.VaolEr.myTelegramBot.service.ReplyMessageService;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

import static org.mockito.Mockito.when;

public class PaymentCallbackQueryHandlerTest {

    private final ReplyMessageService messageService = Mockito.mock(ReplyMessageService.class);

    Chat chat;
    Message message;
    CallbackQuery callbackQuery;

    PaymentCallbackQueryHandler paymentCallbackQueryHandler;



    private final String testChatID = "123456";

    @BeforeEach
    public void setUp() throws Exception {
        paymentCallbackQueryHandler = new PaymentCallbackQueryHandler(messageService);

        callbackQuery = new CallbackQuery();

        chat = new Chat();
        chat.setId(Long.parseLong(testChatID));

        message = new Message();
        message.setChat(chat);
        message.setText("text");
        callbackQuery.setMessage(message);


    }

    @Test
    @DisplayName("Return SendMessage when handleCallbackQuery")
    public void handleCallbackQueryTest() {
        //when
        when(messageService.getReplyMessage(any(), any())).thenReturn(SendMessage.builder()
                .chatId(testChatID)
                .text("query.test")
                .build());

        paymentCallbackQueryHandler.handleCallbackQuery(callbackQuery);

        //then
        assertThat(paymentCallbackQueryHandler.handleCallbackQuery(callbackQuery)).isNotNull();
        assertEquals(SendMessage.builder()
                .chatId(testChatID)
                .text("query.test")
                .build(), paymentCallbackQueryHandler.handleCallbackQuery(callbackQuery));
    }

    @Test
    @DisplayName("Return correct query type")
    public void getHandlerQueryTypeTest(){
        assertEquals(paymentCallbackQueryHandler.getHandlerQueryType(), CallbackQueryType.PAYMENT);
    }

}
