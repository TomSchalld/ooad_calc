package io.commands;

import helper.language.Messages;
import main.EinUndAusgabe;
import business.Rechner;

public class Subtrahieren implements Command {
  private Rechner rechner;
  
  public Subtrahieren(Rechner rechner){
    this.rechner = rechner;
  }

  @Override
  public Command execute() {
	Undo undo = new Undo(this.rechner);
	undo.setAltAnzeige(this.rechner.getAnzeige());
	undo.setAltSpeicher(this.rechner.getSpeicher());
    System.out.print(Messages.getString("Command.0"));
    this.rechner.subtrahieren(new EinUndAusgabe().leseInteger());
    return undo;
  }
  
  @Override
  public String toString(){
    return Messages.getString("Command.5");   //$NON-NLS-1$
  }

}