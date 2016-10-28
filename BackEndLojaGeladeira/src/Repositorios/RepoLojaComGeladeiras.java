package Repositorios;

import java.util.ArrayList;
import java.util.List;
import Agregadores.LojaComGeladeiras;

public class RepoLojaComGeladeiras {

	List<LojaComGeladeiras> repoLojaComGeladeiras = new ArrayList<>();
	
	private RepoLojaComGeladeiras(){
		
	}
	
	public static RepoLojaComGeladeiras novo(){
		return new RepoLojaComGeladeiras();
	}
	
	public boolean inserir(LojaComGeladeiras lojaComGeladeirasParaInserir){
		
		if(repoLojaComGeladeiras.add(lojaComGeladeirasParaInserir)){
			return true;
		}
		return false;
	}
	
	public LojaComGeladeiras selecionar(LojaComGeladeiras lojaComGeladeirasParaSelecionar){
		
		for(LojaComGeladeiras lojaComGeladeiras : repoLojaComGeladeiras){
			if(lojaComGeladeiras.equals(lojaComGeladeirasParaSelecionar.getLoja().getNome())){
				return lojaComGeladeiras;
			}
		}
		return null;
	}
	
	public List<LojaComGeladeiras> selecionarTudo(){
		return repoLojaComGeladeiras;
	}
	
	public void remover(LojaComGeladeiras lojaComGeladeirasParaRemover){
		repoLojaComGeladeiras.remove(lojaComGeladeirasParaRemover);
	}
}
