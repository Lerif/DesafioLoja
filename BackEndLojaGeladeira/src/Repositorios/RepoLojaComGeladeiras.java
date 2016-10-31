package Repositorios;

import java.util.ArrayList;
import java.util.List;
import Agregadores.LojaComGeladeiras;
import Entidades.Geladeira;
import Entidades.Loja;

public class RepoLojaComGeladeiras {

	private static List<LojaComGeladeiras> repoLojaComGeladeiras = new ArrayList<LojaComGeladeiras>();

	private RepoLojaComGeladeiras() {
	}

	public static RepoLojaComGeladeiras novo() {
		return new RepoLojaComGeladeiras();
	}

	public boolean inserir(LojaComGeladeiras lojaComGeladeirasParaInserir) {
		return repoLojaComGeladeiras.add(lojaComGeladeirasParaInserir);
	}

	public List<LojaComGeladeiras> selecionarTudo() {
		return repoLojaComGeladeiras;
	}

	public void remover(LojaComGeladeiras lojaComGeladeirasParaRemover) {
		repoLojaComGeladeiras.remove(lojaComGeladeirasParaRemover);
	}

	public static List<Geladeira> buscarUmaPalavraGenerica(String busca) {
		List<Geladeira> resposta = new ArrayList<Geladeira>();
		for (LojaComGeladeiras lojaComGeladeiras : repoLojaComGeladeiras) {
			for (Geladeira geladeira : lojaComGeladeiras.getListaGeladeiras()) {
				if (geladeira.getFabricante().equals(busca) || geladeira.getNome().equals(busca)
						|| geladeira.getMarca().equals(busca)) {
					resposta.add(geladeira);
				}
			}

		}
		return resposta;
	}

	public static List<Geladeira> buscarUmaPalavraGenericaLoja(String busca, Loja loja) {
		List<Geladeira> resposta = new ArrayList<Geladeira>();
		for (LojaComGeladeiras lojaComGeladeira : repoLojaComGeladeiras) {
			if (lojaComGeladeira.getLoja().equals(loja)) {
				for (Geladeira geladeira : lojaComGeladeira.getListaGeladeiras()) {
					if (geladeira.getFabricante().equals(busca) || geladeira.getNome().equals(busca)
							|| geladeira.getMarca().equals(busca)) {
						resposta.add(geladeira);
					}
				}
			}
		}
		return resposta;
	}

}
