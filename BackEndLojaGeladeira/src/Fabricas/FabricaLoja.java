package Fabricas;

import Entidades.*;

public class FabricaLoja {

	private FabricaLoja() {
	}

	public static FabricaLoja nova() {
		return new FabricaLoja();
	}

	public Loja retornaLoja(String nome, String foto) {
		return Loja.novaLoja(nome, foto);
	}
}
