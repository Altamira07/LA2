package analizador.lexico;

public class Token {
	private int id;
	private String tipo;
	private String lexema;
	
	public Token(int id, String tipo, String lexema) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.lexema = lexema;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getLexema() {
		return lexema;
	}
	public void setLexema(String lexema) {
		this.lexema = lexema;
	}
	
	@Override
	public String toString() {
		return  id + "\t" + tipo + "\t" + lexema;
	}
	
}
