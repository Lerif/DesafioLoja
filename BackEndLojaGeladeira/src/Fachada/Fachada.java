package Fachada;

import java.util.List;

import Entidades.Caracteristica;
import Entidades.Geladeira;
import Servicos.ServicoGeladeira;
import Servicos.ServicoLoja;

public class Fachada {

	public ServicoGeladeira servicoGeladeira = ServicoGeladeira.novo();
	public ServicoLoja servicoLoja = ServicoLoja.novo();
	
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
	
	
	
}
