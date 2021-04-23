package com.mestremorh.meli;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.mestremorh.meli.logic.ValidatorDNA;

class ValidatorTest {

	@Test
	void testIsMutant() {
		String[] dna = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
				
				assertEquals(true, ValidatorDNA.isMutant(dna));
	}

	@Test
	void testValidarFila() {
		String[] dna = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
		
		assertEquals(1, ValidatorDNA.validarFila(dna));
		
		
	}

	@Test
	void testValidarColumnas() {
		
		String[] dna = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
		assertEquals(1, ValidatorDNA.validarColumnas(dna));
	}

	@Test
	void testValidarOblicuas() {
		String[] dna = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
		assertEquals(1, ValidatorDNA.validarOblicuas(dna));

	}

	@Test
	void testEncuentraSecuencia() {
		assertEquals(true, ValidatorDNA.encuentraSecuencia("CCCCTA"));
		
		assertEquals(false, ValidatorDNA.encuentraSecuencia("ATGCGA"));
		
		assertEquals(true, ValidatorDNA.encuentraSecuencia("CCCCTA"));

		assertEquals(true, ValidatorDNA.encuentraSecuencia("CCCCTA"));



	}

}
