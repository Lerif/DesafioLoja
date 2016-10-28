package Servicos;

import java.util.List;

import Agregadores.LojaComGeladeiras;
import Entidades.Geladeira;
import Entidades.Loja;
import Fabricas.FabricaGeladeira;
import Fabricas.FabricaLojaComGeladeiras;
import Repositorios.RepoLojaComGeladeiras;

public class ServicoLojaComGeladeiras {
	
	public RepoLojaComGeladeiras repoLojaComGeladeiras = RepoLojaComGeladeiras.novo();

	private ServicoLojaComGeladeiras(){
	}
	
	public static ServicoLojaComGeladeiras novo(){
		return new ServicoLojaComGeladeiras();
	}
	
	public LojaComGeladeiras criarLojaComGeladeiras(Loja loja, List<Geladeira> geladeiras){
		FabricaLojaComGeladeiras fabricaLojaComGeladeiras = FabricaLojaComGeladeiras.nova();
		LojaComGeladeiras lojaComGeladeiras = fabricaLojaComGeladeiras.retornaLojaComGeladeiras(loja, geladeiras);
		repoLojaComGeladeiras.inserir(lojaComGeladeiras);
		return lojaComGeladeiras;
	}
	
	public List<LojaComGeladeiras> buscarTodasGelardeiras(){
		return repoLojaComGeladeiras.selecionarTudo();
	}
	
	public LojaComGeladeiras buscarGeladeira(LojaComGeladeiras nomeDaLojaComGeladeiras){
		return repoLojaComGeladeiras.selecionar(nomeDaLojaComGeladeiras);
	}
	
	public boolean excluirLojaComGeladeiras(LojaComGeladeiras lojaComGeladeiras){
		return repoLojaComGeladeiras.remover(lojaComGeladeiras);
	}
	
}
