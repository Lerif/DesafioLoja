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

	public Boolean Inserir(Geladeira g) {
		for (Geladeira gel : listaGeladeiras) {
			if (gel.getNome().equals(g.getNome()))
				return false;
		}
		listaGeladeiras.add(g);
		return true;
	}

	public Boolean Remover(String nome) {
		for (Geladeira gel : listaGeladeiras) {
			if (gel.getNome().equals(nome))
				listaGeladeiras.remove(gel);
			return true;
		}
		return false;
	}

	public Boolean AtualizarMarca(String nome, String marca) {
		for (Geladeira gel : listaGeladeiras) {
			if (gel.getNome().equals(nome)) {
				gel.setMarca(marca);
				return true;
			}
		}
		return false;
	}

	public Boolean AtualizarFabricante(String nome, String fabricante) {
		for (Geladeira gel : listaGeladeiras) {
			if (gel.getNome().equals(nome)) {
				gel.setFabricante(fabricante);
				return true;
			}
		}
		return false;
	}

}
