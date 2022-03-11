package br.cm;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.cm.modelo.Campo;

class TesteCampo {

	private Campo campo;
	
	@BeforeEach
	void iniciarCampo() {
		campo = new Campo(3,3);
	}
	
	@Test
	void testeVizinhoRealDistancia1() {
		Campo vizinho = new Campo(3,4);
		
		boolean result = campo.adicionarVizinho(vizinho);
		assertTrue(result);
	}
	
	@Test
	void testeVizinhoRealDistancia2() {
		Campo vizinho = new Campo(4,4);
		
		boolean result = campo.adicionarVizinho(vizinho);	
		assertTrue(result);
	}
	
	@Test
	void testeVizinhoFalso() {
		Campo vizinho = new Campo(5,4);
		
		boolean result = campo.adicionarVizinho(vizinho);
		assertFalse(result);
	}
	
	@Test
	void testePadraoMarcacao() {
		assertFalse(campo.isMarcado());
	}
	
	@Test
	void testeAlternarMarcacao() {
		assertTrue(!campo.isMarcado());
	}
	
	@Test
	void testeAbrirNãoMinadoNãoMarcado() {
		assertTrue(campo.abrir());
	}
	
	@Test
	void testeAbrirMinadoMarcado() {
		campo.alternarMarcacao();
		campo.minar();
		assertFalse(campo.abrir());
	}
}
