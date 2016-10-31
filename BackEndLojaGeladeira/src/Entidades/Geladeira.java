package Entidades;

import java.util.List;

public class Geladeira {
	private String nome;
	private String marca;
	private String fabricante;
	private List<String> lista;

	private Geladeira(String nome, String marca, String fabricante) {
		this.nome = nome;
		this.marca = marca;
		this.fabricante = fabricante;
	}

	public static Geladeira nova(String nome, String marca, String fabricante) {
		return new Geladeira(nome, marca, fabricante);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}
	
	public void adicionaCarac(String carac){
		lista.add(carac);
	}
	
	public void RemoveCarac(String carac){
		lista.remove(carac);
	}
	
}
