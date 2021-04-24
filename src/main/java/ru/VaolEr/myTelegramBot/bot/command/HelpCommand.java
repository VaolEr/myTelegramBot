package ru.VaolEr.myTelegramBot.bot.command;

import org.telegram.telegrambots.meta.api.objects.Update;
import ru.VaolEr.myTelegramBot.service.BotSendMessageService;

import static ru.VaolEr.myTelegramBot.bot.command.BotCommandName.*;

public class HelpCommand implements BotCommand{

    private final BotSendMessageService botSendMessageService;

    private final static String HELP_MESSAGE = String.format("✨<b>Дотупные команды</b>✨\n\n"
                    + "<b>Начать\\закончить работу с ботом</b>\n"
                    + "%s - начать работу со мной\n"
                    + "%s - приостановить работу со мной\n\n"
                    + "%s - получить помощь в работе со мной\n",
            START.getCommandName(), STOP.getCommandName(), HELP.getCommandName()

    );

    public HelpCommand(BotSendMessageService botSendMessageService) {
        this.botSendMessageService = botSendMessageService;
    }

    public static String getMessageText() {
        return HELP_MESSAGE;
    }

    @Override
    public void execute(Update update) {
        botSendMessageService.sendMessage(update.getMessage().getChatId().toString(), HELP_MESSAGE);
    }
}
