package Repositorios;

import java.util.ArrayList;
import java.util.List;
import Entidades.Caracteristica;

public class RepoCaracteristica {
	
	public List<Caracteristica> repoCaracteristica = new ArrayList<Caracteristica>();
	
	private RepoCaracteristica(){
	}
	
	public static RepoCaracteristica nova(){
		return new RepoCaracteristica();
	}
	
	public boolean inserir (Caracteristica caracteristica){
		
		if (repoCaracteristica.add(caracteristica)){
			return true;
		}
		return false;
	}
	
	public Caracteristica selecionar(String nomeDaCaracteristicaParaSelecionar){
		
		for(Caracteristica caracteristica : repoCaracteristica){
			if(caracteristica.equals(nomeDaCaracteristicaParaSelecionar)){
				return caracteristica;
			}
		}
		return null;
	}
	
	public List<Caracteristica> selecionarTudo(){
		return repoCaracteristica;
	}
	
	public boolean remover(Caracteristica caracteristicaParaRemover){
		return repoCaracteristica.remove(caracteristicaParaRemover);
	}
}
