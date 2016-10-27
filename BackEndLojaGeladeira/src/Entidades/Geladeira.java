package Entidades;

import java.util.List;

import Agregadores.Caracteristicas;

public class Geladeira {
	private String nome;
	private String marca;
	private String fabricante;
	private Caracteristicas lista;
	private List<String> fotos;

	private Geladeira(String nome, String marca, String fabricante, Caracteristicas lista, List<String> fotos) {
		this.nome = nome;
		this.marca = marca;
		this.fabricante = fabricante;
		this.lista = lista;
		this.fotos = fotos;
	}

	public static Geladeira nova(String nome, String marca, String fabricante, Caracteristicas lista, List<String> fotos) {
		return new Geladeira(nome, marca, fabricante, lista, fotos);
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

	public Caracteristicas getLista() {
		return lista;
	}

	public void setLista(Caracteristicas lista) {
		this.lista = lista;
	}

	public List<String> getFotos() {
		return fotos;
	}

	public void setFotos(List<String> fotos) {
		this.fotos = fotos;
	}

}
