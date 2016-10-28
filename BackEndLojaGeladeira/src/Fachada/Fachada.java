package Fachada;

import java.util.List;

import Entidades.Geladeira;
import Servicos.ServicoGeladeira;
import Servicos.ServicoLoja;

public class Fachada {

	public ServicoGeladeira servicoGeladeira = ServicoGeladeira.novo();
	public ServicoLoja servicoLoja = ServicoLoja.novo();
	
	public Geladeira criarNovaGeladeira(String nome, String marca, String fabricante, List<String> fotos){
		return servicoGeladeira.criarGeladeira(nome, marca, fabricante, fotos);
	}
	
	public List<Geladeira> buscarGeladeira(String nomeDaGeladeira){
		return servicoGeladeira.buscarGeladeira(nomeDaGeladeira);
	}
	
}
