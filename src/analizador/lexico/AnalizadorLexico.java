package analizador.lexico;

import java.io.File;
import java.io.IOException;

import java.util.Scanner;

public class AnalizadorLexico {
	private String ruta;
	private int id;
	private int l =0;
	private TablaSimbolos ts = new TablaSimbolos();
	public AnalizadorLexico() {
		ruta = "";
	}

	public AnalizadorLexico(String ruta) {
		this.ruta = ruta;
	}

	public void analizar() {
		Scanner lector;
		String cadena = "";
		boolean b = true;
		Token tk = null;
		try {
			lector = new Scanner(new File(ruta));
			while (lector.hasNext()) {
				cadena =lector.next();
				tk = identificar(cadena);
				if(tk != null)
					ts.agregar(tk);
				else 
					System.out.println("Error "+cadena);
					
				
			}
			lector.close();
		} catch (IOException  EX) {
			System.out.println(EX.getMessage());
		}
		ts.imprimeTabla();
	}



	public Token identificar(String cadena) {
	
		if(esOperadorAsigacion(cadena))
			return new Token(++id,"Asignacion",cadena);
		
		if (esPalabraReservada(cadena)) 
			return new Token(++id, "Palabra Reservada", cadena);
		
		if(esReal(cadena))
			return new Token(++id, "Real", cadena);
		
		if(esOperadorAritmetico(cadena))
			return new Token(++id,"Operador aritmetico",cadena);
		
		if(esCaracterEspecial(cadena))
			return new Token(++id,"Caracter especial",cadena);
		
		if(esIdentificador(cadena))
			return new Token(++id,"Identificador",cadena);
		
		if(esOperadorComparacion(cadena))
			return new Token(++id,"OperadorComparacion",cadena);
		
		if(esOperadorLogico(cadena))
			return new Token(++id,"Caracter especial",cadena);
	
		if(esTexto(cadena))
			return new Token(++id,"Cadena",cadena);
	
		return null;
	}

	public boolean esOperadorComparacion(String cadena) {
		for (String operador : Lenguaje.operadoresComparacion) {
			if (operador.equals(cadena))
				return true;
		}
		return false;
	}

	public boolean esOperadorLogico(String cadena) {
		for (String operador : Lenguaje.operadoresLogicos) {
			if (operador.equals(cadena))
				return true;
		}
		return false;
	}

	public boolean esOperadorAsigacion(String cadena) {
		if (cadena.equals(Lenguaje.asignacion))
			return true;
		return false;
	}

	// Verificamos si es { } ;( )
	public boolean esCaracterEspecial(String cadena) {
		char[] caracteres = cadena.toCharArray();
		boolean bandera = false;
		for (char c : caracteres) {
			bandera = false;
			for (char cf : Lenguaje.signosEspeciales)
				if (cf == c) {
					bandera = true;
					break;
				}
			if (!bandera)
				return false;
		}
		return bandera;
	}

	public boolean esPalabraReservada(String cadena) {
		for (String palabraReservada : Lenguaje.palabrasReservadas)
			if (palabraReservada.equals(cadena))
				return true;
		return false;
	}

	public boolean esTexto(String cadena) {
		char[] caracteres = cadena.toCharArray();
		if (caracteres[0] == '\'' && caracteres[caracteres.length - 1] == '\'' && caracteres.length > 1)
			return true;
		return false;
	}

	public boolean esOperadorAritmetico(String cadena) {
		if (cadena.length() == 1) {
			for (char caracter : Lenguaje.operadoresAritmeticos) {
				if (cadena.charAt(0) == caracter)
					return true;
			}
		}
		return false;
	}

	public boolean esIdentificador(String cadena) {
		char[] caracteres = cadena.toCharArray();
		boolean bandera = false;
		for (int i = 0; i < caracteres.length; i++) {
			for (int j = 0; j < Lenguaje.identificadores.length; j++) {
				if (caracteres[i] == Lenguaje.identificadores[j]) {
					bandera = true;
					break;
				}
				bandera = false;
			}
			if (!bandera)
				return false;
		}
		return bandera;
	}

	public boolean esReal(String cadena) {
		boolean punto = false, bandera = false;
		char[] caracteres;
		int val = 0;
		if (cadena.length() < 18) {
			caracteres = cadena.toCharArray();
			for (int i = 0; i < caracteres.length; i++) {

				if (val > 7)
					return false;
				if (caracteres[i] == '.' && !punto) {
					punto = true;
					i++;
					val = 0;
					if (i >= caracteres.length)
						return false;
				} else if (punto && caracteres[i] == '.')
					return false;

				for (int j = 0; j < Lenguaje.Real.length; j++) {
					if (caracteres[i] == Lenguaje.Real[j]) {

						bandera = true;
						break;
					}
					bandera = false;
				}

				if (!bandera)
					return false;
				val++;
			}
			return true;
		}
		return false;
	}

	public void analizar(String ruta) {
		this.ruta = ruta;
		analizar();
	}
}
