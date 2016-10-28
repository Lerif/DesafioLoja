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
	
	public Loja criarLoja(String nome, String foto){
		FabricaLoja fabricaLoja = FabricaLoja.nova();
		Loja loja = fabricaLoja.retornaLoja(nome, foto);
		repoLoja.inserir(loja);
		return loja;
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
