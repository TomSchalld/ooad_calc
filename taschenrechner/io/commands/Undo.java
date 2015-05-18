package io.commands;

import java.util.Stack;

import business.Rechner;

public class Undo implements Command{
	
	private int altAnzeige;
	private int altSpeicher;
	private Rechner rechner;
	private Stack<Command> wieder = new Stack<Command>();
	
	public Undo(Rechner rechner){
		this.rechner = rechner;
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
	
	public void pushItIn(Redo redo){
		this.wieder.push(redo);
	}
	
	public Command getRedoFromStack(){
		return this.wieder.pop();
	}
	
	@Override
	public String toString() {
		return "Undo [altAnzeige=" + altAnzeige + ", altSpeicher="
				+ altSpeicher + "]";
	}

	@Override
	public Command execute() {
		this.rechner.setAnzeige(this.altAnzeige);
		this.rechner.setSpeicher(this.altSpeicher);
		return this;
	}

}
