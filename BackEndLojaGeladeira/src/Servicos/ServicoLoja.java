package Servicos;

import java.util.List;

import Entidades.Loja;
import Fabricas.FabricaLoja;
import Repositorios.RepoLoja;

public class ServicoLoja {

	public RepoLoja repoLoja = RepoLoja.novo();
	
	private ServicoLoja(){
	}
	
	public static ServicoLoja novo(){
		return new ServicoLoja();
	}
	
	/**
	 * Primeiro verifica se existe alguma loja com o mesmo nome. Se existir 
	 * nao deixar criar, Se nao existir cria.
	 * retorno:
	 * Retorna um objeto Loja caso nao exista uma loja criada com o mesmo nome.
	 * Retorna null caso ja tenho uma loja com o mesmo nome.
	 */
	public Loja criarLoja(String nome, String foto){
		
		for (Loja verificandoLoja : repoLoja.selecionarTudo()){
			if(verificandoLoja.getNome().equals(nome)){
				return null;
			}
		}
		
		FabricaLoja fabricaLoja = FabricaLoja.nova();
		Loja loja = fabricaLoja.retornaLoja(nome, foto);
		repoLoja.inserir(loja);
		return loja;
	}
	
	public Loja buscarUltimaLoja(){
		return repoLoja.buscarUltimaLoja();
	}
	
	public List<Loja> buscarTodasLojas(){
		return repoLoja.selecionarTudo();
	}
	
	public Loja buscarLoja(String nome){
		return repoLoja.selecionar(nome);
	}
	
	public boolean excluirLoja(Loja loja){
		return repoLoja.remover(loja);
	}
}
