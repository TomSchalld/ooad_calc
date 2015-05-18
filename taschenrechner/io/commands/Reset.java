package io.commands;

import helper.language.Messages;
import business.Rechner;

public class Reset implements Command{

	private Rechner rechner;
	
	public Reset(Rechner rechner){
		this.rechner = rechner;
	}
	
	@Override
	public Command execute() {
		Undo undo = new Undo(this.rechner);
		undo.setAltAnzeige(this.rechner.getAnzeige());
		undo.setAltSpeicher(this.rechner.getSpeicher());
		this.rechner.reset();
		return undo;
	}
	
	  @Override
	  public String toString(){
	    return Messages.getString("Command.6");   //$NON-NLS-1$
	  }
	
}
