package Testes;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import Agregadores.LojaComGeladeiras;
import Entidades.Caracteristica;
import Entidades.Geladeira;
import Entidades.Loja;
import Fachada.Fachada;
import Repositorios.RepoGeladeira;

public class Teste {
	
	// Constantes Geladeira
	static final String NOME_GELADEIRA = "x95";
	static final String MARCA_GELADEIRA = "Brastempo";
	static final String FABRICANTE_GELADEIRA = "Brittanyng";
	static final String CARACTERISTICA1_GELADEIRA = "Frost-free";
	static final String CARACTERISTICA2_GELADEIRA = "azul";
	static final String CARACTERISTICA3_GELADEIRA = "multi-portas";
	static final String CARACTERISTICA4_GELADEIRA = "faz gelos";
	static final String FOTO1_GELADEIRA = "foto1";
	static final String FOTO2_GELADEIRA = "foto2";
	static final String FOTO3_GELADEIRA = "foto3";
	
	// Constantes Loja
	static final String NOME_LOJA = "anericanas";
	static final String ICONE_LOJA = "icone_loja";

	
	List<Caracteristica> caracteristicas = new ArrayList<Caracteristica>();
	List<String> fotos = new ArrayList<String>();
	Geladeira geladeira;

	Fachada fachada = new Fachada();
	
	@Test
	public void test_fachada_criarNovaGeladeira() {
		
		List<Caracteristica> caracteristicas = new ArrayList<Caracteristica>();
		List<String> fotos = new ArrayList<String>();
		
		Caracteristica caracteristica = Caracteristica.novaCaracteristica(CARACTERISTICA1_GELADEIRA, true);
		caracteristicas.add(caracteristica);
		caracteristica = Caracteristica.novaCaracteristica(CARACTERISTICA2_GELADEIRA, true);
		caracteristicas.add(caracteristica);
		caracteristica = Caracteristica.novaCaracteristica(CARACTERISTICA3_GELADEIRA, true);
		caracteristicas.add(caracteristica);
		caracteristica = Caracteristica.novaCaracteristica(CARACTERISTICA4_GELADEIRA, true);
		caracteristicas.add(caracteristica);
		
		fotos.add(FOTO1_GELADEIRA);
		fotos.add(FOTO2_GELADEIRA);
		fotos.add(FOTO3_GELADEIRA);
		
		Geladeira geladeira = fachada.criarNovaGeladeira(NOME_GELADEIRA, MARCA_GELADEIRA,
				FABRICANTE_GELADEIRA, caracteristicas, fotos);
		
		List<Caracteristica> car = geladeira.getCaracteristicas();
		List<String> fot = geladeira.getFotos();
		
		assert(geladeira.getNome().equals(NOME_GELADEIRA));
		assert(geladeira.getMarca().equals(MARCA_GELADEIRA));
		assert(geladeira.getFabricante().equals(FABRICANTE_GELADEIRA));
		assert(car.get(0).equals(CARACTERISTICA1_GELADEIRA));
		assert(car.get(1).equals(CARACTERISTICA2_GELADEIRA));
		assert(car.get(2).equals(CARACTERISTICA3_GELADEIRA));
		assert(car.get(3).equals(CARACTERISTICA4_GELADEIRA));
		assert(fot.get(0).equals(FOTO1_GELADEIRA));
		assert(fot.get(1).equals(FOTO2_GELADEIRA));
		assert(fot.get(2).equals(FOTO3_GELADEIRA));
		
	}
	
	@Test
	public void test_fachada_criarNovaGeladeira_volume() {
		

		
		Caracteristica caracteristica = Caracteristica.novaCaracteristica(CARACTERISTICA1_GELADEIRA, true);
		caracteristicas.add(caracteristica);
		caracteristica = Caracteristica.novaCaracteristica(CARACTERISTICA2_GELADEIRA, true);
		caracteristicas.add(caracteristica);
		
		fotos.add(FOTO1_GELADEIRA);

		Geladeira geladeira = null;
		
		for (int i=0; i< 10 ; i++){
			geladeira = fachada.criarNovaGeladeira("nome"+i, MARCA_GELADEIRA,
					FABRICANTE_GELADEIRA, caracteristicas, fotos);
		}
		
		List<Caracteristica> car = geladeira.getCaracteristicas();
		List<String> fot = geladeira.getFotos();
		
		for (int i=0; i< 10 ; i++){
			assert(geladeira.getNome().equals("nome"+i));
			assert(geladeira.getMarca().equals(MARCA_GELADEIRA));
			assert(geladeira.getFabricante().equals(FABRICANTE_GELADEIRA));
			assert(car.get(0).equals(CARACTERISTICA1_GELADEIRA));
			assert(car.get(1).equals(CARACTERISTICA2_GELADEIRA));
			assert(fot.get(0).equals(FOTO1_GELADEIRA));
		}
	}
	
	@Test
	public void test_fachada_buscarTodasGeladeiras() {
		Geladeira geladeira = null;
		
		for (int i=0; i< 10 ; i++){
			geladeira = fachada.criarNovaGeladeira("nome"+i, MARCA_GELADEIRA,
					FABRICANTE_GELADEIRA, caracteristicas, fotos);
		}
		
		List<Geladeira> geladeiras = fachada.buscarTodasGeladeiras();
		
		int indice = 0;
		
		for (Geladeira gel : geladeiras){
			assert(gel.getNome().equals("nome"+indice));
			indice++;
		}
	}

	@Test
	public void test_fachada_buscarGeladeira() {
		
		Geladeira geladeira = null;
		
		for (int i=0; i< 10 ; i++){
			geladeira = fachada.criarNovaGeladeira("nome"+i, MARCA_GELADEIRA,
					FABRICANTE_GELADEIRA, caracteristicas, fotos);
		}
		
		assert(fachada.buscarGeladeira("nome3").equals("nome3"));
	}
	
	@Test
	public void test_fachada_excluirGeladeira() {
		
		Geladeira geladeira = null;
		
		for (int i=0; i< 10 ; i++){
			geladeira = fachada.criarNovaGeladeira("nome"+i, MARCA_GELADEIRA,
					FABRICANTE_GELADEIRA, caracteristicas, fotos);
		}
		
		geladeira = fachada.criarNovaGeladeira("nome2", MARCA_GELADEIRA,
				FABRICANTE_GELADEIRA, caracteristicas, fotos);
		
		fachada.excluirGeladeira(geladeira);
		
		List<Geladeira> geladeiras = fachada.buscarGeladeira("nome2");
		assert(geladeiras.isEmpty());
	}
	
	@Test
	public void test_fachada_criarNovaLojaComGeladeiras() {
		Loja loja = Loja.novaLoja(NOME_LOJA, ICONE_LOJA);
		List<Geladeira> geladeiras = new ArrayList<Geladeira>();

		geladeira = fachada.criarNovaGeladeira(NOME_GELADEIRA+0, MARCA_GELADEIRA, FABRICANTE_GELADEIRA,
				caracteristicas, fotos);
		geladeiras.add(geladeira);
		
		geladeira = fachada.criarNovaGeladeira(NOME_GELADEIRA+1, MARCA_GELADEIRA, FABRICANTE_GELADEIRA,
				caracteristicas, fotos);
		geladeiras.add(geladeira);
		
		
		LojaComGeladeiras lojaComGeladeiras = fachada.criarNovaLojaComGeladeiras(loja, geladeiras);
		
		Loja lojaRetornada = lojaComGeladeiras.getLoja();
		assert(lojaRetornada.getNome().equals(NOME_LOJA));
		assert(lojaRetornada.getFoto().equals(ICONE_LOJA));
		
		List<Geladeira> geladeirasRetornada = lojaComGeladeiras.getListaGeladeiras();
		
		int indice = 0;
		for (Geladeira gel : geladeirasRetornada){
			assert(gel.getNome().equals(NOME_GELADEIRA+indice));
			assert(gel.getNome().equals(MARCA_GELADEIRA));
			assert(gel.getNome().equals(FABRICANTE_GELADEIRA));
		}
	}

}
