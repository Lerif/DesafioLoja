package Fabricas;

import Agregadores.Caracteristicas;
import Entidades.*;

public class FabricaCaracteristicas {

	private FabricaCaracteristicas() {
	}

	public FabricaCaracteristicas nova() {
		return new FabricaCaracteristicas();
	}

	public Caracteristicas retornaCaracteristicas() {
		return Caracteristicas.NovaCaracteristicas();
	}

	public Caracteristica retornaCaracteristica(String tipo, Boolean existe) {
		return Caracteristica.novaCaracteristica(tipo, existe);
	}

}
