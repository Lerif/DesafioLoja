package Repositorios;

import java.util.ArrayList;
import java.util.List;

import Entidades.Loja;

public class RepoLoja {

	private static List<Loja> repoLojas = new ArrayList<Loja>();

	private RepoLoja() {
	}

	public static RepoLoja novo() {
		return new RepoLoja();
	}

	public boolean inserir(Loja loja) {
		return repoLojas.add(loja);
	}

	public boolean remover(Loja lojaParaRemover) {
		return repoLojas.remove(lojaParaRemover);
	}

	public List<Loja> selecionarTudo() {
		return repoLojas;
	}
}
