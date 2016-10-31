package Servicos;

import java.util.List;

import Entidades.Caracteristica;
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

	public static Geladeira criarGeladeira(String nome, String marca, String fabricante, List<Caracteristica> caracteristicas) {
		return repoGeladeira.inserir(FabricaGeladeira.nova().retornaGeladeira(nome, marca, fabricante, caracteristicas));
	}

	public List<Geladeira> buscarTodasGelardeiras() {
		return repoGeladeira.selecionarTudo();
	}

	public List<Geladeira> buscarGeladeira(String nomeDaGeladeira) {
		return repoGeladeira.selecionar(nomeDaGeladeira);
	}

	public boolean excluirGeladeira(Geladeira geladeira) {
		return repoGeladeira.remover(geladeira);
	}
}
