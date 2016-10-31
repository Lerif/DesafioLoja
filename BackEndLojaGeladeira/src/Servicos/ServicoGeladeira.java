package Servicos;

import java.util.List;

import Entidades.Geladeira;
import Fabricas.FabricaGeladeira;
import Repositorios.RepoGeladeira;

public class ServicoGeladeira {

	static private RepoGeladeira repoGeladeira = RepoGeladeira.novo();

	private ServicoGeladeira() {
	}

	public static ServicoGeladeira novo() {
		return new ServicoGeladeira();
	}

	public static void criarGeladeira(String nome, String marca, String fabricante) {
		repoGeladeira.inserir(FabricaGeladeira.nova().retornaGeladeira(nome, marca, fabricante));

	}

	public List<Geladeira> buscarTodasGelardeiras() {
		return repoGeladeira.selecionarTudo();
	}

	public void excluirGeladeira(Geladeira geladeira) {
		repoGeladeira.remover(geladeira);
	}
}
