package Servicos;

import java.util.List;
import Entidades.Caracteristica;
import Fabricas.FabricaCaracteristica;
import Repositorios.RepoCaracteristica;

public class ServicoCaracteristica {

	public RepoCaracteristica repoCaracteristica = RepoCaracteristica.nova();
	
	private ServicoCaracteristica(){
	}
	
	public static ServicoCaracteristica nova(){
		return new ServicoCaracteristica();
	}
	
	public Caracteristica criarCaracteristica(String tipo, boolean existe){
		FabricaCaracteristica fabricaCaracteristica = FabricaCaracteristica.nova();
		Caracteristica caracteristica = fabricaCaracteristica.retornaCaracteristica(tipo, existe);
		repoCaracteristica.inserir(caracteristica);
		return caracteristica;
	}
	
	public List<Caracteristica> buscarTodasCaracteristica(){
		return repoCaracteristica.selecionarTudo();
	}
	
	public Caracteristica buscarCaracteristica(String nomeDaCaracteristica){
		return repoCaracteristica.selecionar(nomeDaCaracteristica);
	}
	
	public boolean excluirCaracteristica(Caracteristica caracteristica){
		return repoCaracteristica.remover(caracteristica);
	}
	
}
