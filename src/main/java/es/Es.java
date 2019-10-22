package es;

import java.util.Scanner;

public class Es {
	public Archivos archivos;
	public Consola consola;
	public Interprete interprete;
	
	public Es()
	{
		consola = new Consola(new Scanner(System.in));
		archivos = new Archivos();
		interprete = new Interprete();
	}

	
}
