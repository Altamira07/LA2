package analizador.lexico;

import java.util.ArrayList;

public class TablaSimbolos {
	private ArrayList<Token> tablaSimbolos;

	public TablaSimbolos() {
		tablaSimbolos = new ArrayList<>();
	}
	public void agregar(Token token) {
		tablaSimbolos.add(token);
	}

	public boolean buscar(Token t) {
		return true;
	}
	
	public void imprimeTabla()
	{
		System.out.println("Id \t Tipo \t lexema");
		for(Token token: tablaSimbolos)
			System.out.println(token.toString());
	}
}
