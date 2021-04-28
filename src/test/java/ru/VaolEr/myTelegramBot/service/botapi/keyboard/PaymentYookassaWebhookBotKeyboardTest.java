package ru.VaolEr.myTelegramBot.service.botapi.keyboard;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import ru.VaolEr.myTelegramBot.botapi.keyboard.PaymentYookassaWebhookBotKeyboard;
import ru.VaolEr.myTelegramBot.service.LocaleMessageService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class PaymentYookassaWebhookBotKeyboardTest {

    private final LocaleMessageService localeMessageService = Mockito.mock(LocaleMessageService.class);
    private PaymentYookassaWebhookBotKeyboard paymentYookassaWebhookBotKeyboard;

    private final String testChatID = "testChatID";
    private SendMessage testSendMessage;

    @BeforeEach
    public void setUp() throws Exception {
        paymentYookassaWebhookBotKeyboard = new PaymentYookassaWebhookBotKeyboard(localeMessageService);

        testSendMessage = new SendMessage();
        testSendMessage.setChatId(testChatID);
        testSendMessage.setText("keyboard.test_message");
    }

    @Test
    @DisplayName("Send inline keyboard-message test")
    public void testSendInlineKeyBoardMessage() {
        //when
        when(localeMessageService.getMessage(any())).thenReturn("keyboard.test_message");

        paymentYookassaWebhookBotKeyboard.sendInlineKeyBoardMessage(testChatID);

        //then
        assertThat(paymentYookassaWebhookBotKeyboard.sendInlineKeyBoardMessage(testChatID)).isNotNull();
        assertThat(paymentYookassaWebhookBotKeyboard.sendInlineKeyBoardMessage(testChatID).getReplyMarkup()).isNotNull();
        assertEquals(testSendMessage.getChatId(), paymentYookassaWebhookBotKeyboard.sendInlineKeyBoardMessage(testChatID).getChatId());
        assertEquals(testSendMessage.getText(), paymentYookassaWebhookBotKeyboard.sendInlineKeyBoardMessage(testChatID).getText());
    }
}
