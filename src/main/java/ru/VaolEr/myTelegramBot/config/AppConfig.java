package ru.VaolEr.myTelegramBot.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import ru.VaolEr.myTelegramBot.bot.PaymentYookassaWebhookBot;

@Configuration
public class AppConfig {

//    private RZDTelegramBotConfig botConfig;

//    public AppConfig(RZDTelegramBotConfig rzdTelegramBotConfig) {
//        this.botConfig = rzdTelegramBotConfig;
//    }

//    @Bean
//    public MessageSource messageSource() {
//        ReloadableResourceBundleMessageSource messageSource
//                = new ReloadableResourceBundleMessageSource();
//
//        messageSource.setBasename("classpath:messages");
//        messageSource.setDefaultEncoding("UTF-8");
//        return messageSource;
//    }
//
//    @Bean
//    public PaymentYookassaWebhookBot PaymentYookassaWebhookBot() {
////        DefaultBotOptions options = new TelegramBotsApi(DefaultBotSession.class)
////                .getInstance(DefaultBotOptions.class);
//
////        options.setProxyHost(botConfig.getProxyHost());
////        options.setProxyPort(botConfig.getProxyPort());
////        options.setProxyType(botConfig.getProxyType());
//
//        PaymentYookassaWebhookBot paymentYookassaWebhookBot = new PaymentYookassaWebhookBot();
////        rzdTelegramBot.setBotUsername(botConfig.getUserName());
////        rzdTelegramBot.setBotToken(botConfig.getBotToken());
////        rzdTelegramBot.setBotPath(botConfig.getWebHookPath());
//
//        return paymentYookassaWebhookBot;
//    }

}
