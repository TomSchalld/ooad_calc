package io.commands;

import business.Rechner;


public class Redo implements Command{
	
	private int vorherAnzeige;
	private int vorherSpeicher;
	private Rechner rechner;
	Undo undo = new Undo(this.rechner);

		
	
	public Redo(Rechner rechner){
		this.rechner = rechner;
		undo.setAltAnzeige(this.rechner.getAnzeige());
		undo.setAltSpeicher(this.rechner.getSpeicher()); 
		this.vorherAnzeige = this.rechner.getAnzeige();
		this.vorherSpeicher = this.rechner.getSpeicher();
	}
	
	public int getVorherAnzeige() {
		return vorherAnzeige;
	}

	public void setVorherAnzeige(int vorherAnzeige) {
		this.vorherAnzeige = vorherAnzeige;
	}


	public int getVorherSpeicher() {
		return vorherSpeicher;
	}

	public void setVorherSpeicher(int vorherSpeicher) {
		this.vorherSpeicher = vorherSpeicher;
	}

	@Override
	public Command execute() {

		this.rechner.setAnzeige(this.vorherAnzeige);
		this.rechner.setSpeicher(this.vorherSpeicher);
		
		return undo;
	}

}
