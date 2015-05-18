package main;

import helper.language.Messages;
import io.commands.Addieren;
import io.commands.AnzeigeSpeichern;
import io.commands.Command;
import io.commands.Redo;
import io.commands.Reset;
import io.commands.SpeicherAddieren;
import io.commands.SpeicherSubtrahieren;
import io.commands.Subtrahieren;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;




import business.Rechner;

public class Dialog {

  private Rechner rechner = new Rechner();
  private Map<Integer,Command> aktionen = new HashMap<>();
  private Stack<Command> zuletzt = new Stack<Command>();
  private Stack<Command> wieder = new Stack<Command>();
	
public Dialog(){
	this.aktionen.put(1, new Reset(this.rechner));
    this.aktionen.put(2, new Addieren(this.rechner));
    this.aktionen.put(3, new Subtrahieren(this.rechner));
    this.aktionen.put(4, new AnzeigeSpeichern(this.rechner));
    this.aktionen.put(5, new SpeicherAddieren(this.rechner));
    this.aktionen.put(6, new SpeicherSubtrahieren(this.rechner)); 
  }


  
  public void dialog() {
    EinUndAusgabe ea = new EinUndAusgabe();
    int eingabe = -1;
    while (eingabe != 0) {
      System.out.println(Messages.getString("Dialog.0")); //$NON-NLS-1$
      for(int tmp:this.aktionen.keySet()){
        System.out.println("("+tmp+") "+ this.aktionen.get(tmp)); //$NON-NLS-1$ //$NON-NLS-2$
      }    
      if(!this.zuletzt.isEmpty()){
      	System.out.println("(98) " + Messages.getString("Command.98"));

      }
      if(!this.wieder.isEmpty()){
    	  System.out.println("(99) " + Messages.getString("Command.99"));
      }
      eingabe = ea.leseInteger();
      Command com;
      
      if(eingabe == 98){
    	  this.wieder.push(new Redo(this.rechner));
    	  this.zuletzt.pop().execute();
    	  System.out.println("Elemente auf dem Stack zuletzt: " + this.zuletzt.size());
    	  System.out.println("Elemente auf dem Stack wieder: " + this.wieder.size());
      }
      if(eingabe == 99){
    	  this.wieder.pop().execute();
    	  System.out.println("Elemente auf dem Stack wieder: " + this.wieder.size());
      }
      com = this.aktionen.get(eingabe);
      
      if(com !=null){
         this.zuletzt.push(com.execute());
    		  for(int i = 0; i < this.wieder.size();i++){
    			  this.wieder.pop();
    			  System.out.println("Elemente auf dem Stack wieder: " + this.wieder.size());
    		  }
         System.out.println("Elemente auf dem Stack: " + this.zuletzt.size());
      }
      System.out.println(this.rechner);
    }
  }

}
