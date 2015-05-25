package io.commands;

import helper.language.Messages;
import main.EinUndAusgabe;
import business.Rechner;

public class Addieren implements Command {
	private Rechner rechner;

	public Addieren(Rechner rechner) {
		this.rechner = rechner;
	}

	@Override
	public Command execute() {
		Undo undo = new Undo(this.rechner);
		undo.setAltAnzeige(this.rechner.getAnzeige());
		undo.setAltSpeicher(this.rechner.getSpeicher());

		System.out.print(Messages.getString("Command.0")); //$NON-NLS-1$
		this.rechner.addieren(new EinUndAusgabe().leseInteger());

		return undo;
	}

	@Override
	public String toString() {
		return Messages.getString("Command.1"); //$NON-NLS-1$
	}

}
