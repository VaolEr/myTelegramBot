package ru.VaolEr.myTelegramBot.bot.command;

import com.google.common.collect.ImmutableMap;
import ru.VaolEr.myTelegramBot.service.BotSendMessageService;

import static ru.VaolEr.myTelegramBot.bot.command.BotCommandName.*;

public class BotCommandContainer {

    private final ImmutableMap<String, BotCommand> botCommandMap;
    private final BotCommand unknownCommand;

    public BotCommandContainer (BotSendMessageService botSendMessageService) {

        botCommandMap = ImmutableMap.<String, BotCommand>builder()
                .put(START.getCommandName(), new StartCommand(botSendMessageService))
                .put(STOP.getCommandName(), new StopCommand(botSendMessageService))
                .put(HELP.getCommandName(), new HelpCommand(botSendMessageService))
                .put(NOT_EXIST.getCommandName(), new NotExistCommand(botSendMessageService))
                .build();

        unknownCommand = new UnknownCommand(botSendMessageService);
    }

    public BotCommand retrieveCommand(String commandIdentifier) {
        return botCommandMap.getOrDefault(commandIdentifier, unknownCommand);
    }
}
