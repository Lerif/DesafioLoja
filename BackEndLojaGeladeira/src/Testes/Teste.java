package Testes;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import Entidades.Caracteristica;
import Entidades.Geladeira;
import Fachada.Fachada;
import Repositorios.RepoGeladeira;

public class Teste {

	@Test
	public void test_fachada_criarNovaGeladeira() {
		Fachada fachada = new Fachada();
		
		List<Caracteristica> caracteristicas = 
		
		fachada.criarNovaGeladeira("", "", "", );
	}
	

}
