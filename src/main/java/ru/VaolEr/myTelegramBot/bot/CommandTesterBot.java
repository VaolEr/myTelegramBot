package ru.VaolEr.myTelegramBot.bot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.VaolEr.myTelegramBot.bot.command.BotCommandContainer;
import ru.VaolEr.myTelegramBot.service.impl.CommandTesterBotSendMessageServiceImpl;

import static ru.VaolEr.myTelegramBot.bot.command.BotCommandName.NOT_EXIST;

@Component
public class CommandTesterBot extends TelegramLongPollingBot {

    public static String COMMAND_PREFIX = "/";

    // This is telegram bot token
    @Value("${app.bots.tokens.commandTestBotToken}")
    private String botToken;

    // This is telegram bot username
    @Value("${app.bots.usernames.commandTestBotUsername}")
    private String botUsername;

    private final BotCommandContainer botCommandContainer;

    public CommandTesterBot() {
        this.botCommandContainer = new BotCommandContainer(new CommandTesterBotSendMessageServiceImpl(this));
    }

    @Override
    public String getBotUsername() {
        return botUsername;
    }

    @Override
    public String getBotToken() { return botToken; }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String message = update.getMessage().getText().trim();
            if (message.startsWith(COMMAND_PREFIX)) {
                String commandIdentifier = message.split(" ")[0].toLowerCase();

                botCommandContainer.retrieveCommand(commandIdentifier).execute(update);
            } else {
                botCommandContainer.retrieveCommand(NOT_EXIST.getCommandName()).execute(update);
            }
        }
    }

}
