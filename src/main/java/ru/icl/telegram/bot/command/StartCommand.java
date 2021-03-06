package ru.icl.telegram.bot.command;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.bots.AbsSender;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class StartCommand extends BotCommand {

	public StartCommand() {
		super("start", "Start command");
	}

	@Override
	public void execute(AbsSender absSender, User user, Chat chat, String[] arguments) {
		SendMessage message = new SendMessage();
		message.setChatId(chat.getId());
		message.setText("Добрый день!");
		try {
			absSender.execute(message);
		} catch (TelegramApiException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String getCommandCategory() {
		return "Test";
	}

	
}
