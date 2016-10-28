package Fabricas;

import java.util.List;

import Agregadores.LojaComGeladeiras;
import Entidades.Geladeira;
import Entidades.Loja;

public class FabricaLojaComGeladeiras {

	private FabricaLojaComGeladeiras(){
	}
	
	public static FabricaLojaComGeladeiras nova(){
		return new FabricaLojaComGeladeiras();
	}
	
	public LojaComGeladeiras retornaFabricaLojaComGeladeiras(Loja loja, List<Geladeira> geladeiras){
		return LojaComGeladeiras.nova(loja, geladeiras);
	}
	
}
