package Repositorios;

import java.util.ArrayList;
import java.util.List;

import Entidades.Geladeira;

public class RepoGeladeira {

	public List<Geladeira> repoGeladeiras = new ArrayList<Geladeira>();
	
	private  RepoGeladeira(){
		
	}
	
	public static RepoGeladeira novo(){
		return new RepoGeladeira();
	}
	
	public boolean inserir (Geladeira geladeira){
		
		if (repoGeladeiras.add(geladeira)){
			return true;
		}
		return false;
	}
	
	public Geladeira selecionar(Geladeira geladeiraParaSelecionar){
		
		for(Geladeira geladeira : repoGeladeiras){
			if(geladeira.equals(geladeiraParaSelecionar.getNome())){
				return geladeira;
			}
		}
		return null;
	}
	
	public List<Geladeira> selecionarTudo(){
		return repoGeladeiras;
	}
	
	/**
	 * Remove geladeira da lista de geladeiras
	 * Retorna:
	 *  Se sucesso retorna geladeira removida 
	 *  Se falhar retorna null
	 * */
	public Geladeira remover(Geladeira geladeiraParaRemover){
		int indice = 0;
		
		for(Geladeira geladeira : repoGeladeiras){
			if (geladeira.equals(geladeiraParaRemover.getNome())){
				return repoGeladeiras.remove(indice);
			}
		}
		return null;
	}
}
