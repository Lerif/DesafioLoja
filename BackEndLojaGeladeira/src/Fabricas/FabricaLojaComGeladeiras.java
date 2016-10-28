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
	
	public LojaComGeladeiras retornaLojaComGeladeiras(Loja loja, List<Geladeira> geladeiras){
		return LojaComGeladeiras.nova(loja, geladeiras);
	}
	
}
