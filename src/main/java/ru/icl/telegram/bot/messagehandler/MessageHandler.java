package ru.icl.telegram.bot.messagehandler;

import org.telegram.telegrambots.meta.api.objects.Message;

public interface MessageHandler {
	
	String handleMassge(final Message message);

}
