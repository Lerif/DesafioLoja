package Fachada;

import java.util.List;
import Agregadores.LojaComGeladeiras;
import Entidades.Geladeira;
import Entidades.Loja;
import Repositorios.RepoLojaComGeladeiras;
import Servicos.ServicoGeladeira;
import Servicos.ServicoLoja;
import Servicos.ServicoLojaComGeladeiras;

public class Fachada {

	private static ServicoGeladeira servicoGeladeira = ServicoGeladeira.novo();
	private static ServicoLoja servicoLoja = ServicoLoja.novo();
	private static ServicoLojaComGeladeiras servicoLojaComGeladeiras = ServicoLojaComGeladeiras.novo();

	// Servicos de Geladeira
	public static void criarNovaGeladeira(String nome, String marca, String fabricante) {
		ServicoGeladeira.criarGeladeira(nome, marca, fabricante);
	}

	public static List<Geladeira> buscarTodasGeladeiras() {
		return servicoGeladeira.buscarTodasGelardeiras();
	}

	public static void excluirGeladeira(Geladeira geladeira) {
		servicoGeladeira.excluirGeladeira(geladeira);
	}

	// Servicos de Loja
	public static void criarNovaLoja(String nome, String foto) {
		servicoLoja.criarLoja(nome, foto);
	}

	public static List<Loja> buscarTodasLojas() {
		return servicoLoja.buscarTodasLojas();
	}

	public static void excluirLoja(Loja loja) {
		servicoLoja.excluirLoja(loja);
	}

	// Servicos de LojaComGeladeira
	public static void criarNovaLojaComGeladeiras(Loja loja, List<Geladeira> geladeiras) {
		servicoLojaComGeladeiras.criarLojaComGeladeiras(loja, geladeiras);
	}

	public static List<LojaComGeladeiras> buscarTodasLojasComGeladeiras() {
		return servicoLojaComGeladeiras.buscarTodasLojaComGeladeiras();
	}

	public static List<Geladeira> buscaGeladeira(String busca) {
		return RepoLojaComGeladeiras.buscarUmaPalavraGenerica(busca);
	}

	public static List<Geladeira> buscaGeladeiraLoja(String busca, Loja loja) {
		return RepoLojaComGeladeiras.buscarUmaPalavraGenericaLoja(busca, loja);
	}

}
