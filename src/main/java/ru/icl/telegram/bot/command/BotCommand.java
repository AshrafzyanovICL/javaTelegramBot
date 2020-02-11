package ru.icl.telegram.bot.command;

public abstract class BotCommand extends org.telegram.telegrambots.extensions.bots.commandbot.commands.BotCommand {
	
	public BotCommand(String commandIdentifier, String description) {
		super(commandIdentifier, description);
	}

	public abstract String getCommandCategory();

}
