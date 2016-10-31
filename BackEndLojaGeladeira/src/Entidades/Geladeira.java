package Entidades;

import java.util.List;

public class Geladeira {
	private String nome;
	private String marca;
	private String fabricante;
	private List<Caracteristica> caracteristicas;

	private Geladeira(String nome, String marca, String fabricante, List<Caracteristica> caracteristicas) { 
		this.nome = nome;
		this.marca = marca;
		this.fabricante = fabricante;
		this.caracteristicas = caracteristicas;
	}

	public static Geladeira nova(String nome, String marca, String fabricante, List<Caracteristica> caracteristicas) {
		return new Geladeira(nome, marca, fabricante, caracteristicas);
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

	public List<Caracteristica> getCaracteristicas() {
		return caracteristicas;
	}

	public void setCaracteristicas(List<Caracteristica> caracteristicas) {
		this.caracteristicas = caracteristicas;
	}
	
}
