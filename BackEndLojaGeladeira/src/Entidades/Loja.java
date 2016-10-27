package Entidades;

public class Loja {
	private String nome;
	private String foto;

	private Loja(String nome, String foto) {
		this.nome = nome;
		this.foto = foto;
	}

	public static Loja novaLoja(String nome, String foto) {
		return new Loja(nome, foto);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

}
