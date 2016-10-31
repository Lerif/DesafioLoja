package Agregadores;

import java.util.List;

import Entidades.*;

public class LojaComGeladeiras {
	private Loja loja;
	private List<Geladeira> listaGeladeiras;


	private LojaComGeladeiras(Loja loja, List<Geladeira> geladeiras) {
		this.loja = loja;
		this.listaGeladeiras = geladeiras;
	}

	public static LojaComGeladeiras nova(Loja loja, List<Geladeira> geladeiras) {
		return new LojaComGeladeiras(loja, geladeiras);
	}

	public Loja getLoja() {
		return loja;
	}

	public void setLoja(Loja loja) {
		this.loja = loja;
	}
	
	public List<Geladeira> getListaGeladeiras() {
		return listaGeladeiras;
	}

	public void setListaGeladeiras(List<Geladeira> listaGeladeiras) {
		this.listaGeladeiras = listaGeladeiras;
	}

	public void Inserir(Geladeira g) {
		listaGeladeiras.add(g);
	}

	public void Remover(Geladeira g) {
		listaGeladeiras.remove(g);
	}

}
