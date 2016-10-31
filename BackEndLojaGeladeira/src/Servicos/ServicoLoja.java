package Servicos;

import java.util.List;

import Entidades.Loja;
import Fabricas.FabricaLoja;
import Repositorios.RepoLoja;

public class ServicoLoja {

	static private RepoLoja repoLoja = RepoLoja.novo();

	private ServicoLoja() {
	}

	public static ServicoLoja novo() {
		return new ServicoLoja();
	}

	public void criarLoja(String nome, String foto) {
		FabricaLoja fabricaLoja = FabricaLoja.nova();
		Loja loja = fabricaLoja.retornaLoja(nome, foto);
		repoLoja.inserir(loja);
	}

	public List<Loja> buscarTodasLojas() {
		return repoLoja.selecionarTudo();
	}

	public void excluirLoja(Loja loja) {
		repoLoja.remover(loja);
	}
}
