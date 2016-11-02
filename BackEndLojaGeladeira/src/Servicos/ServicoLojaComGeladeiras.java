package Servicos;

import java.util.List;

import Agregadores.LojaComGeladeiras;
import Entidades.Geladeira;
import Entidades.Loja;
import Fabricas.FabricaLojaComGeladeiras;
import Repositorios.RepoLojaComGeladeiras;

public class ServicoLojaComGeladeiras {
	
	public RepoLojaComGeladeiras repoLojaComGeladeiras = RepoLojaComGeladeiras.novo();

	private ServicoLojaComGeladeiras(){
	}
	
	public static ServicoLojaComGeladeiras novo(){
		return new ServicoLojaComGeladeiras();
	}
	
	/**
	 * Procura Lojas com mesmo nome se nao existir criar novo agregador de loja com lista de geladerias,
	 * se existir update com lista de geladeiras nova 
	 */
	public LojaComGeladeiras criarLojaComGeladeiras(Loja loja, List<Geladeira> geladeiras){
		
		for(LojaComGeladeiras verificandoLojaComGeladeiras : repoLojaComGeladeiras.selecionarTudo()){
			if(verificandoLojaComGeladeiras.getLoja().getNome().equals(loja.getNome())){
				verificandoLojaComGeladeiras.setListaGeladeiras(geladeiras);
				return verificandoLojaComGeladeiras;
			}
		}
		
		FabricaLojaComGeladeiras fabricaLojaComGeladeiras = FabricaLojaComGeladeiras.nova();
		LojaComGeladeiras lojaComGeladeiras = fabricaLojaComGeladeiras.retornaLojaComGeladeiras(loja, geladeiras);
		repoLojaComGeladeiras.inserir(lojaComGeladeiras);
		return lojaComGeladeiras;
	}
	
	public List<Geladeira> buscarTodasGeladeirasDaLoja(String loja){
		return repoLojaComGeladeiras.buscarTodasGeladeirasDaLoja(loja);
	}
	
	public List<LojaComGeladeiras> buscarTodasLojaComGeladeiras(){
		return repoLojaComGeladeiras.selecionarTudo();
	}
	
	public LojaComGeladeiras buscarLojaComGeladeira(LojaComGeladeiras nomeDaLojaComGeladeiras){
		return repoLojaComGeladeiras.selecionar(nomeDaLojaComGeladeiras);
	}
	
	public boolean excluirLojaComGeladeiras(LojaComGeladeiras lojaComGeladeiras){
		return repoLojaComGeladeiras.remover(lojaComGeladeiras);
	}
	
}
