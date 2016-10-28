package Servicos;

import java.util.List;

import Entidades.Caracteristica;
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
	
	public Geladeira criarGeladeira(String nome, String marca, String fabricante, 
			List<Caracteristica> caracteristicas, List<String> fotos){
		FabricaGeladeira fabricaGeladeira = FabricaGeladeira.nova();
		Geladeira geladeira = fabricaGeladeira.retornaGeladeira(nome, marca, fabricante, caracteristicas, fotos);
		repoGeladeira.inserir(geladeira);
		return geladeira;
	}
	
	public List<Geladeira> buscarTodasGelardeiras(){
		return repoGeladeira.selecionarTudo();
	}
	
	public List<Geladeira> buscarGeladeira(String nomeDaGeladeira){
		return repoGeladeira.selecionar(nomeDaGeladeira);
	}
	
	public boolean excluirGeladeira(Geladeira geladeira){
		return repoGeladeira.remover(geladeira);
	}
}
