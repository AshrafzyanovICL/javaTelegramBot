package ru.icl.telegram.bot.messagehandler.impl;

import org.telegram.telegrambots.meta.api.objects.Message;

import ru.icl.telegram.bot.messagehandler.MessageHandler;

public class MessageHandlerImpl implements MessageHandler {

	@Override
	public String handleMassge(Message message) {
		return "Добрый день. Ваш телефон: " + message.getChatId();
	}

}
