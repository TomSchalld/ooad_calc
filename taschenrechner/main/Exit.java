package main;

import helper.language.Messages;
import io.commands.Command;

public class Exit implements Command {

	@Override
	public Command execute() {
		System.exit(0);
		return null;
	}

	@Override
	public String toString() {
		return Messages.getString("Dialog.0");
	}
}
