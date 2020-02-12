package ru.icl.telegram.bot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.telegram.telegrambots.extensions.bots.commandbot.commands.IBotCommand;
import org.telegram.telegrambots.extensions.bots.commandbot.commands.ICommandRegistry;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.bots.AbsSender;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import ru.icl.telegram.bot.command.BotCommand;

public class ListCommand extends BotCommand {

	private ICommandRegistry commandRegistry;
	public ListCommand(final ICommandRegistry commandRegistry) {
		super("list", "");
		this.commandRegistry = commandRegistry;
	}

	@Override
	public void execute(AbsSender absSender, User user, Chat chat, String[] arguments) {
		Map<String, List<IBotCommand>> res = new HashMap<>();
		commandRegistry.getRegisteredCommands().stream().filter(e -> e instanceof ru.icl.telegram.bot.command.BotCommand).map(e -> ru.icl.telegram.bot.command.BotCommand.class.cast(e)).forEach(e -> {
			List<IBotCommand> botCommands = res.get(e.getCommandCategory());
			if (botCommands == null) {
				botCommands =  new ArrayList<>();
				res.put(e.getCommandCategory(), botCommands);
			}
			botCommands.add(e);
		});
		SendMessage message = new SendMessage();
		message.setChatId(chat.getId());
		StringBuilder sb = new StringBuilder();
		for(Entry<String, List<IBotCommand>> entry : res.entrySet()) {
			sb.append(entry.getKey()).append('\n');
			for(IBotCommand iBotCommand : entry.getValue()) {
				sb.append('\\' + iBotCommand.getCommandIdentifier() + " - " + iBotCommand.getDescription()).append('\n');
			}
		}
		
		message.setText(sb.toString());
		try {
			absSender.execute(message);
		} catch (TelegramApiException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	@Override
	public String getCommandCategory() {
		return "Info";
	}

}
