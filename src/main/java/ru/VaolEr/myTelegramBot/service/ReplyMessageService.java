package ru.VaolEr.myTelegramBot.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import ru.VaolEr.myTelegramBot.service.LocaleMessageService;

@Service
@RequiredArgsConstructor
public class ReplyMessageService {

    private final LocaleMessageService localeMessageService;

//    public ReplyMessageService(LocaleMessageService messageService) {
//        this.localeMessageService = messageService;
//    }

    public SendMessage getReplyMessage(String chatId, String replyMessage) {
        return new SendMessage(chatId, localeMessageService.getMessage(replyMessage));
    }

    public SendMessage getReplyMessage(String chatId, String replyMessage, Object... args) {
        return new SendMessage(chatId, localeMessageService.getMessage(replyMessage, args));
    }


//    public SendMessage getSuccessReplyMessage(long chatId, String replyMessage) {
//        return new SendMessage(chatId, getEmojiReplyText(replyMessage, Emojis.SUCCESS_MARK));
//    }

        public SendMessage getWarningReplyMessage(String chatId, String replyMessage) {
        return new SendMessage(chatId, replyMessage);
    }

//    public SendMessage getWarningReplyMessage(long chatId, String replyMessage) {
//        return new SendMessage(chatId, getEmojiReplyText(replyMessage, Emojis.NOTIFICATION_MARK_FAILED));
//    }

    public String getReplyText(String replyText) {
        return localeMessageService.getMessage(replyText);
    }

    public String getReplyText(String replyText, Object... args) {
        return localeMessageService.getMessage(replyText, args);
    }

//    public String getEmojiReplyText(String replyText, Emojis emoji) {
//        return localeMessageService.getMessage(replyText, emoji);
//    }
}
