package Entidades;

public class Caracteristica {
	private String tipo;
	private Boolean existe;

	private Caracteristica(String tipo, Boolean existe) {
		this.tipo = tipo;
		this.existe = existe;
	}

	public static Caracteristica novaCaracteristica(String tipo, Boolean existe) {
		return new Caracteristica(tipo, existe);
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Boolean getExiste() {
		return existe;
	}

	public void setExiste(Boolean existe) {
		this.existe = existe;
	}

}
