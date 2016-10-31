package Repositorios;

import java.util.ArrayList;
import java.util.List;

import Entidades.Geladeira;

public class RepoGeladeira {

	private static List<Geladeira> repoGeladeiras = new ArrayList<Geladeira>();

	private RepoGeladeira() {
	}

	public static RepoGeladeira novo() {
		return new RepoGeladeira();
	}

	public boolean inserir(Geladeira geladeira) {
		return repoGeladeiras.add(geladeira);
	}

	public boolean remover(Geladeira geladeiraParaRemover) {
		return repoGeladeiras.remove(geladeiraParaRemover);
	}

	public List<Geladeira> selecionarTudo() {
		return repoGeladeiras;
	}
}
