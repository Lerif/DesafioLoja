package Fachada;

import java.util.List;

import Agregadores.LojaComGeladeiras;
import Entidades.Caracteristica;
import Entidades.Geladeira;
import Entidades.Loja;
import Servicos.ServicoCaracteristica;
import Servicos.ServicoGeladeira;
import Servicos.ServicoLoja;
import Servicos.ServicoLojaComGeladeiras;

public class Fachada {

	private static ServicoGeladeira servicoGeladeira = ServicoGeladeira.novo();
	private static ServicoLoja servicoLoja = ServicoLoja.novo();
	private static ServicoLojaComGeladeiras servicoLojaComGeladeiras = ServicoLojaComGeladeiras.novo();
	private static ServicoCaracteristica servicoCaracteristica = ServicoCaracteristica.nova();

	/**
	 * Servicos de Geladeira
	 */

	public static Geladeira criarNovaGeladeira(String nome, String marca, String fabricante) {
		return ServicoGeladeira.criarGeladeira(nome, marca, fabricante);
	}

	public static List<Geladeira> buscarGeladeira(String nomeDaGeladeira) {
		return servicoGeladeira.buscarGeladeira(nomeDaGeladeira);
	}

	public static List<Geladeira> buscarTodasGeladeiras() {
		return servicoGeladeira.buscarTodasGelardeiras();
	}

	public boolean excluirGeladeira(Geladeira geladeira) {
		return servicoGeladeira.excluirGeladeira(geladeira);
	}

	/**
	 * Servicos de Loja
	 */

	public static Loja criarNovaLoja(String nome, String foto) {
		return servicoLoja.criarLoja(nome, foto);
	}

	public static Loja buscarLoja(String nome) {
		return servicoLoja.buscarLoja(nome);
	}

	public static List<Loja> buscarTodasLojas() {
		return servicoLoja.buscarTodasLojas();
	}

	public boolean excluirLoja(Loja loja) {
		return servicoLoja.excluirLoja(loja);
	}
	
	public static Loja buscarUltimaLoja(){
		return servicoLoja.buscarUltimaLoja();
	}

	/**
	 * Servicos de LojaComGeladeira
	 */

	public static LojaComGeladeiras criarNovaLojaComGeladeiras(Loja loja, List<Geladeira> geladeiras) {
		return servicoLojaComGeladeiras.criarLojaComGeladeiras(loja, geladeiras);
	}

	public static LojaComGeladeiras buscarLojaComGeladeiras(LojaComGeladeiras lojaComGeladeiras) {
		return servicoLojaComGeladeiras.buscarLojaComGeladeira(lojaComGeladeiras);
	}

	public static List<LojaComGeladeiras> buscarTodasLojasComGeladeiras() {
		return servicoLojaComGeladeiras.buscarTodasLojaComGeladeiras();
	}

	public static boolean excluirLojaComGeladeiras(LojaComGeladeiras lojaComGeladeiras) {
		return servicoLojaComGeladeiras.excluirLojaComGeladeiras(lojaComGeladeiras);
	}
	
	public static List<Geladeira> buscarTodasGeladeirasDaLoja(Loja loja){
		return servicoLojaComGeladeiras.buscarTodasGeladeirasDaLoja(loja);
	}

	/**
	 * Servicos de Caracteristica
	 */

	public static Caracteristica criarNovaCaracteristica(String tipo, boolean existe) {
		return servicoCaracteristica.criarCaracteristica(tipo, existe);
	}

	public static Caracteristica buscarCaracteristica(String caracteristica) {
		return servicoCaracteristica.buscarCaracteristica(caracteristica);
	}

	public static List<Caracteristica> buscarTodasCaracteristicas() {
		return servicoCaracteristica.buscarTodasCaracteristica();
	}

	public static boolean excluirCaracteristica(Caracteristica caracteristica) {
		return servicoCaracteristica.excluirCaracteristica(caracteristica);
	}
}
