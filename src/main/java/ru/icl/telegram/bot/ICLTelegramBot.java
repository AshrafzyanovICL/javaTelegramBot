package ru.icl.telegram.bot;

import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.extensions.bots.commandbot.TelegramLongPollingCommandBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class ICLTelegramBot extends TelegramLongPollingCommandBot {
	
	public ICLTelegramBot(DefaultBotOptions defaultBotOptions) {
		super(defaultBotOptions);
		register(new StartCommand());
	}

	@Override
	public void processNonCommandUpdate(Update update) {
		if (update.hasMessage()) {
			Message message = update.getMessage();
			SendMessage sendMessage = new SendMessage();
			sendMessage.setChatId(message.getChatId());
			sendMessage.setText("Иди нахуй!");
			try {
				execute(sendMessage);
			} catch (TelegramApiException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public String getBotToken() {
		return "977486525:AAEIcz4gUltMW57XNIuE2QDrw_dbLTT3Pp8";
	}

}
