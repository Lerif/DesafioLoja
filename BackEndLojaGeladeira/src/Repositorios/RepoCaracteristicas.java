package Repositorios;

import java.util.ArrayList;
import java.util.List;
import Agregadores.Caracteristicas;

public class RepoCaracteristicas {
	private static List<Caracteristicas> repoCaracteristicas = new ArrayList<Caracteristicas>();

	private RepoCaracteristicas() {
	}

	public static RepoCaracteristicas novo() {
		return new RepoCaracteristicas();
	}
	
	public boolean inserir(Caracteristicas caracteristicasParaInserir){
		
		if(repoCaracteristicas.add(caracteristicasParaInserir)){
			return true;
		}
		return false;
	}
	
	/*public Caracteristicas selecionar(Caracteristicas caracteristicasParaSelecionar){
		
		for(Caracteristicas caracteristicas : repoCaracteristicas){
			if(caracteristicas.equals(caracteristicasParaSelecionar.())){
				return caracteristicas;
			}
		}
		return null;
	}*/
	
	public List<Caracteristicas> selecionarTudo(){
		return repoCaracteristicas;
	}

	
	
	
	
	
	
	
	
	
	
	
}
