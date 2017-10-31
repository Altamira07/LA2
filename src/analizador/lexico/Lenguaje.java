package analizador.lexico;


public class Lenguaje {
	public static final String[] palabrasReservadas = {"Real" , "Cadena", "Booleano" , "si", "entonces" , "mientras", "imprime", "leer" , "falso", "verdadero", "sino" };
	public static final char identificadores[] = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_-".toCharArray();
	public static final char Real[] = "0123456789.".toCharArray();
	public static final char[]operadoresAritmeticos = "+-*/".toCharArray();
	public static final String[]operadoresComparacion = "==,!=,<,<=,>,>=".split(",");
	public static final String asignacion = "=>";
	public static final String[] operadoresLogicos = "&&,||,!".split(",");
	public static final char[] signosEspeciales = "{}()".toCharArray();
}
