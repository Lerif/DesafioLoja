package Repositorios;

import java.util.ArrayList;
import java.util.List;

import Entidades.Loja;

public class RepoLoja {

	List<Loja> repoLojas = new ArrayList<Loja>();
	
	private RepoLoja (){
		
	}
	
	public static RepoLoja novo(){
		return new RepoLoja();
	}
	
	public boolean inserir(Loja loja){
		
		if(repoLojas.add(loja)){
			return true;
		}
		return false;
	}
	
	public Loja buscarUltimaLoja(){
		return repoLojas.get(repoLojas.size()-1);
	}
	
	public Loja selecionar(String lojaParaSelecionar){
		
		for (Loja loja : repoLojas){
			if(loja.getNome().equals(lojaParaSelecionar)){
				return loja;
			}
		}
		return null;
	}
	
	public List<Loja> selecionarTudo(){
		return repoLojas;
	}
	
	public boolean remover(Loja lojaParaRemover){
		return repoLojas.remove(lojaParaRemover);
	}
	
	
}
