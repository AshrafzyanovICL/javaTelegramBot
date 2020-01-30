package ru.icl.telegram.bot;

import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.extensions.bots.commandbot.TelegramLongPollingCommandBot;
import org.telegram.telegrambots.meta.api.objects.Update;

public class ICLTelegramBot extends TelegramLongPollingCommandBot {
	
	public ICLTelegramBot(DefaultBotOptions defaultBotOptions) {
		super(defaultBotOptions);
		register(new StartCommand());
	}

	@Override
	public void processNonCommandUpdate(Update update) {
		// TODO Auto-generated method stub
	}

	@Override
	public String getBotToken() {
		return "977486525:AAEIcz4gUltMW57XNIuE2QDrw_dbLTT3Pp8";
	}

}
