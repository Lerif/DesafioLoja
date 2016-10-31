package Servicos;

import java.util.List;

import Agregadores.LojaComGeladeiras;
import Entidades.Geladeira;
import Entidades.Loja;
import Fabricas.FabricaLojaComGeladeiras;
import Repositorios.RepoLojaComGeladeiras;

public class ServicoLojaComGeladeiras {

	static private RepoLojaComGeladeiras repoLojaComGeladeiras = RepoLojaComGeladeiras.novo();

	private ServicoLojaComGeladeiras() {
	}

	public static ServicoLojaComGeladeiras novo() {
		return new ServicoLojaComGeladeiras();
	}

	public void criarLojaComGeladeiras(Loja loja, List<Geladeira> geladeiras) {
		repoLojaComGeladeiras.inserir(FabricaLojaComGeladeiras.nova().retornaLojaComGeladeiras(loja, geladeiras));
	}

	public List<LojaComGeladeiras> buscarTodasLojaComGeladeiras() {
		return repoLojaComGeladeiras.selecionarTudo();
	}

	public void excluirLojaComGeladeiras(LojaComGeladeiras lojaComGeladeiras) {
		repoLojaComGeladeiras.remover(lojaComGeladeiras);
	}

	public List<Geladeira> buscaPalavra(String busca) {
		return RepoLojaComGeladeiras.buscarUmaPalavraGenerica(busca);
	}

	public List<Geladeira> buscaPalavraporLoja(String busca, Loja loja) {
		return RepoLojaComGeladeiras.buscarUmaPalavraGenericaLoja(busca, loja);
	}

}
