package Fabricas;

import Entidades.*;

public class FabricaGeladeira {

	private FabricaGeladeira() {
	}

	public static FabricaGeladeira nova() {
		return new FabricaGeladeira();
	}

	public  Geladeira retornaGeladeira(String nome, String marca, String fabricante) {
		return Geladeira.nova(nome, marca, fabricante);
	}

}
