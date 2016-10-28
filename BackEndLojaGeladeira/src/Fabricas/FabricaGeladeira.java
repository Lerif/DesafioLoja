package Fabricas;

import java.util.List;

import Entidades.*;

public class FabricaGeladeira {

	private FabricaGeladeira() {
	}

	public static FabricaGeladeira nova() {
		return new FabricaGeladeira();
	}

	public  Geladeira retornaGeladeira(String nome, String marca, String fabricante, 
			List<Caracteristica> caracteristicas, List<String> fotos) {
		return Geladeira.nova(nome, marca, fabricante, caracteristicas, fotos);
	}

}
