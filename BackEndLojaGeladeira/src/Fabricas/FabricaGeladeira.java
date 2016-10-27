package Fabricas;

import java.util.List;

import Agregadores.Caracteristicas;
import Entidades.*;

public class FabricaGeladeira {

	private FabricaGeladeira() {
	}

	public FabricaGeladeira nova() {
		return new FabricaGeladeira();
	}

	public Geladeira retornaGeladeira(String nome, String marca, String fabricante, Caracteristicas lista,
			List<String> fotos) {
		return Geladeira.nova(nome, marca, fabricante, lista, fotos);
	}

}
