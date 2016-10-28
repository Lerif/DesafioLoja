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

	public ServicoGeladeira servicoGeladeira = ServicoGeladeira.novo();
	public ServicoLoja servicoLoja = ServicoLoja.novo();
	public ServicoLojaComGeladeiras servicoLojaComGeladeiras = ServicoLojaComGeladeiras.novo();
	public ServicoCaracteristica servicoCaracteristica = ServicoCaracteristica.nova();
	
	/**
	 * Servicos de Geladeira 
	 */
	 
	public Geladeira criarNovaGeladeira(String nome, String marca, String fabricante,
			 List<Caracteristica> caracteristicas, List<String> fotos){
		return servicoGeladeira.criarGeladeira(nome, marca, fabricante, caracteristicas, fotos);
	}
	
	public List<Geladeira> buscarGeladeira(String nomeDaGeladeira){
		return servicoGeladeira.buscarGeladeira(nomeDaGeladeira);
	}
	
	public List<Geladeira> buscarTodasGeladeiras(){
		return servicoGeladeira.buscarTodasGelardeiras();
	}
	
	public boolean excluirGeladeira(Geladeira geladeira){
		return servicoGeladeira.excluirGeladeira(geladeira);
	}
	
	/**
	 * Servicos de Loja 
	 */
	
	public Loja criarNovaLoja(String nome, String foto){
		return servicoLoja.criarLoja(nome, foto);
	}
	
	public Loja buscarLoja(String nome){
		return servicoLoja.buscarLoja(nome);
	}
	
	public List<Loja> buscarTodasLojas(){
		return servicoLoja.buscarTodasLojas();
	}
	
	public boolean excluirLoja(Loja loja){
		return servicoLoja.excluirLoja(loja);
	}
	
	/**
	 * Servicos de LojaComGeladeira 
	 */
	
	public LojaComGeladeiras criarNovaLojaComGeladeiras(Loja loja, List<Geladeira> geladeiras){
		return servicoLojaComGeladeiras.criarLojaComGeladeiras(loja, geladeiras);
	}
	
	public LojaComGeladeiras buscarLojaComGeladeiras(LojaComGeladeiras lojaComGeladeiras){
		return servicoLojaComGeladeiras.buscarLojaComGeladeira(lojaComGeladeiras);
	}
	
	public List<LojaComGeladeiras> buscarTodasLojasComGeladeiras(){
		return servicoLojaComGeladeiras.buscarTodasLojaComGeladeiras();
	}
	
	public boolean excluirLojaComGeladeiras(LojaComGeladeiras lojaComGeladeiras){
		return servicoLojaComGeladeiras.excluirLojaComGeladeiras(lojaComGeladeiras);
	}
	
	/**
	 * Servicos de Caracteristica 
	 */
	
	public Caracteristica criarNovaCaracteristica(String tipo, boolean existe){
		return servicoCaracteristica.criarCaracteristica(tipo, existe);
	}
	
	public Caracteristica buscarCaracteristica(String caracteristica){
		return servicoCaracteristica.buscarCaracteristica(caracteristica);
	}
	
	public List<Caracteristica> buscarTodasCaracteristicas(){
		return servicoCaracteristica.buscarTodasCaracteristica();
	}
	
	public boolean excluirCaracteristica(Caracteristica caracteristica){
		return servicoCaracteristica.excluirCaracteristica(caracteristica);
	}
}
