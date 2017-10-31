package analizador.lexico.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import analizador.lexico.AnalizadorLexico;

class TestAnalisis {

	@Test
	void testPalabrasReservadas() {
		AnalizadorLexico al = new AnalizadorLexico();
		assertEquals(true, al.esPalabraReservada("Real"));
		assertEquals(true, al.esPalabraReservada("Booleano"));
		assertEquals(true, al.esPalabraReservada("Cadena"));
		assertEquals(true, al.esPalabraReservada("verdadero"));

	}

	@Test
	void testIdentificadores() {
		AnalizadorLexico al = new AnalizadorLexico();
		assertEquals(al.esIdentificador("Hola"), true);
	}

	@Test
	void testNumero() {
		AnalizadorLexico al = new AnalizadorLexico();
		assertEquals(true, al.esReal("234568.12124"));

	}

	@Test
	void testOperadoresAritmeticos() {
		AnalizadorLexico al = new AnalizadorLexico();
		assertEquals(true, al.esOperadorAritmetico("-"));
	}

	@Test
	void testOperadorLogico() {
		AnalizadorLexico al = new AnalizadorLexico();
		assertEquals(true, al.esOperadorLogico("&&"));
	}

	@Test
	void testOperadorComparacion() {
		AnalizadorLexico al = new AnalizadorLexico();
		assertEquals(false, al.esOperadorLogico("=>"));
	}

	@Test
	void testOperadorAsignacion() {
		AnalizadorLexico al = new AnalizadorLexico();
		assertEquals(true, al.esOperadorAsigacion("=>"));

	}
	@Test
	void testTexto()
	{
		AnalizadorLexico al = new AnalizadorLexico();
		assertEquals(true, al.esTexto("'asdasd'"));
	}
	@Test
	void testFinal()
	{
		AnalizadorLexico al = new AnalizadorLexico();
		assertEquals(true, al.esCaracterEspecial("{}}}}"));
	}
	@Test
	void testAnalisis()
	{
		AnalizadorLexico al = new AnalizadorLexico("src/analizador/lexico/test/prueba.dat");
		al.analizar();
		
	}
}
