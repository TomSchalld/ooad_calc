package io.commands;

import business.Rechner;

public class Undo implements Command {

	private int altAnzeige;
	private int altSpeicher;
	private Rechner rechner;

	public Undo(Rechner rechner) {
		this.rechner = rechner;
		this.altAnzeige = this.rechner.getAnzeige();
		this.altSpeicher = this.rechner.getSpeicher();

	}

	public int getAltSpeicher() {
		return altSpeicher;
	}

	public void setAltSpeicher(int altSpeicher) {
		this.altSpeicher = altSpeicher;
	}

	public int getAltAnzeige() {
		return altAnzeige;
	}

	public void setAltAnzeige(int altAnzeige) {
		this.altAnzeige = altAnzeige;
	}

	@Override
	public String toString() {
		return "Undo [altAnzeige=" + altAnzeige + ", altSpeicher="
				+ altSpeicher + "]";
	}

	@Override
	public Command execute() {
		Undo u = new Undo(this.rechner);
		this.rechner.setAnzeige(this.altAnzeige);
		this.rechner.setSpeicher(this.altSpeicher);
		return u;
	}

}
