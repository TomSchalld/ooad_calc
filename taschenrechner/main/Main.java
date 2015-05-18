package main;

import java.util.Locale;

public class Main {

  public static void main(String[] args) {
	  Locale.setDefault(new Locale("de","DE")); //$NON-NLS-1$ //$NON-NLS-2$
      new Dialog().dialog();
  }

}
