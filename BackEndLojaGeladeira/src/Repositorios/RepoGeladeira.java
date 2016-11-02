package Repositorios;

import java.util.ArrayList;
import java.util.List;

import Entidades.Caracteristica;
import Entidades.Geladeira;

public class RepoGeladeira {

	public List<Geladeira> repoGeladeiras = new ArrayList<Geladeira>();
	
	private  RepoGeladeira(){
		
	}
	
	public static RepoGeladeira novo(){
		return new RepoGeladeira();
	}
	
	public Geladeira inserir (Geladeira geladeira){
		
		if (repoGeladeiras.add(geladeira)){
			return geladeira;
		}
		return null;
	}
	
	public List<Caracteristica> buscarTodasCaracteristicasDaGeladeira(String nomeGeladeira){
		
		for(Geladeira geladeira : repoGeladeiras){
			if(geladeira.getNome().equals(nomeGeladeira)){
				return geladeira.getCaracteristicas();
			}
		}
		return new ArrayList<Caracteristica>();
	}
	
	
	public List<Geladeira> selecionar(String nomeDaGeladeiraParaSelecionar){
		
		List<Geladeira> geladeirasComNomeSelecionado = new ArrayList<Geladeira>();
		
		for(Geladeira geladeira : repoGeladeiras){
			if(geladeira.equals(nomeDaGeladeiraParaSelecionar)){
				geladeirasComNomeSelecionado.add(geladeira);
			}
		}
		return geladeirasComNomeSelecionado;
	}
	
	public List<Geladeira> selecionarTudo(){
		return repoGeladeiras;
	}
	
	public boolean remover(Geladeira geladeiraParaRemover){
		return repoGeladeiras.remove(geladeiraParaRemover);
	}
}
