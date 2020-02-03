package ru.icl.telegram.bot;

import java.util.ResourceBundle;

import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.extensions.bots.commandbot.TelegramLongPollingCommandBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import ru.icl.telegram.bot.command.StartCommand;
import ru.icl.telegram.bot.messagehandler.MessageHandler;
import ru.icl.telegram.bot.messagehandler.impl.MessageHandlerImpl;

public class ICLTelegramBot extends TelegramLongPollingCommandBot {
	
	private MessageHandler messageHandler = new MessageHandlerImpl();
	
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
			sendMessage.setText(messageHandler.handleMassge(message));
			SendPhoto photo = new SendPhoto();
			photo.setPhoto("someimage", getClass().getResourceAsStream("/image.jpg"));
			photo.setChatId(message.getChatId());

			try {
				if (message.getText().equals("Photo")) {
					execute(photo);
				} else {
					execute(sendMessage);
				}
			} catch (TelegramApiException e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public String getBotToken() {
		String value = ResourceBundle.getBundle("api_key").getString("bot_key");
		if (value.startsWith("$")) {
			value = System.getenv(value.substring(1));
		}
		return value;
	}
	
}
