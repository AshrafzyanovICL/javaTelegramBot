package ru.icl.telegram.bot.command;

public enum CommandCategory {
	
	ONE(""), TWO("");
	
	private String categoryName;
	
	CommandCategory(final String categoryName) {
		this.categoryName = categoryName;
	}

}
