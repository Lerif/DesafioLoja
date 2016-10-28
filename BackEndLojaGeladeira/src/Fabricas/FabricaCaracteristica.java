package Fabricas;

import Entidades.Caracteristica;

public class FabricaCaracteristica {

	private FabricaCaracteristica(){
	}
	
	public static FabricaCaracteristica nova(){
		return new FabricaCaracteristica();
	}
	
	public Caracteristica retornaCaracteristica(String tipo, boolean existe){
		return Caracteristica.novaCaracteristica(tipo, existe);
	}
}
