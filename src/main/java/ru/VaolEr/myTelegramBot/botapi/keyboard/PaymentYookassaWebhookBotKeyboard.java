package ru.VaolEr.myTelegramBot.botapi.keyboard;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import ru.VaolEr.myTelegramBot.service.LocaleMessageService;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class PaymentYookassaWebhookBotKeyboard {

    private final LocaleMessageService localeMessageService;

    public SendMessage sendInlineKeyBoardMessage(String chatId){

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();

        InlineKeyboardButton button_getPaymentLink = new InlineKeyboardButton();
        InlineKeyboardButton button_getHelp = new InlineKeyboardButton();

        button_getPaymentLink.setText("Payment");
        button_getPaymentLink.setCallbackData("PAYMENT");

        button_getHelp.setText("Help");
        button_getHelp.setCallbackData("HELP");

        List<InlineKeyboardButton> keyboardButtonsRow1 = new ArrayList<>();
        keyboardButtonsRow1.add(button_getPaymentLink);
        keyboardButtonsRow1.add(button_getHelp);

        List<List<InlineKeyboardButton>> rowsList = new ArrayList<>();
        rowsList.add(keyboardButtonsRow1);

        inlineKeyboardMarkup.setKeyboard(rowsList);

        SendMessage keyboardMessage = new SendMessage();
        keyboardMessage.setChatId(chatId);
        keyboardMessage.setText(localeMessageService.getMessage("keyboard.greeting_message"));
        keyboardMessage.setReplyMarkup(inlineKeyboardMarkup);

        return keyboardMessage;
    }

}
