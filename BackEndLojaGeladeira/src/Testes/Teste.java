package Testes;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import Entidades.Geladeira;
import Repositorios.RepoGeladeira;

public class Teste {

	@Test
	public void test_metodoFachada() {
		fail("Not yet implemented");
	}
	
	@Test
	public void test_inserirGeladeira(){
		RepoGeladeira rg = new RepoGeladeira();
		List <String>list = new ArrayList<>();
		Geladeira geladeira = Geladeira.nova("", "", "", list);
		assertTrue(rg.inserir(geladeira));
	}

}
