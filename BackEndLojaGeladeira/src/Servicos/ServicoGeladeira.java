package Servicos;

import java.util.List;

import Entidades.Geladeira;
import Fabricas.FabricaGeladeira;
import Repositorios.RepoGeladeira;

public class ServicoGeladeira {

	public RepoGeladeira repoGeladeira =  RepoGeladeira.novo(); 
	
	private ServicoGeladeira(){
		
	}
	
	public static ServicoGeladeira novo(){
		return new ServicoGeladeira();
	}
	
	public Geladeira criarGeladeira(String nome, String marca, String fabricante, List<String> fotos){
		FabricaGeladeira fabricaGeladeira = FabricaGeladeira.nova();
		Geladeira geladeira = fabricaGeladeira.retornaGeladeira(nome, marca, fabricante, fotos);
		repoGeladeira.inserir(geladeira);
		return geladeira;
	}
}
