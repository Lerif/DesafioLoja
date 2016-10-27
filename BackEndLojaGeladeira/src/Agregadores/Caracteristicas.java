package Agregadores;

import java.util.List;

import Entidades.*;

public class Caracteristicas {
	private List<Caracteristica> listaCaracteristica;

	private Caracteristicas() {
	}

	public static Caracteristicas NovaCaracteristicas() {
		return new Caracteristicas();
	}

	public Boolean Inserir(Caracteristica c) {
		for (Caracteristica car : listaCaracteristica) {
			if (car.getTipo().equals(c.getTipo()))
				return false;
		}
		listaCaracteristica.add(c);
		return true;
	}

	public Boolean Remover(String tipo) {
		for (Caracteristica car : listaCaracteristica) {
			if (car.getTipo().equals(tipo))
				listaCaracteristica.remove(car);
			return true;
		}
		return false;
	}

	public Boolean Atualizar(String tipo, Boolean novo) {
		for (Caracteristica car : listaCaracteristica) {
			if (car.getTipo().equals(tipo)) {
				car.setExiste(novo);
				return true;
			}
		}
		return false;
	}

}
