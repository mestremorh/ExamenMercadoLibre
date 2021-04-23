package com.mestremorh.meli.logic;

public class ValidatorDNA {
	

	
	public static boolean isMutant(String[] dna) {
		
		int total = 0;
		
		total = total + validarFila(dna);
		total = total + validarColumnas(dna);
		total = total + validarOblicuas(dna);
		
		if(total > 1) {
			
			return true;
		}else {
			return false;
		}
		
	}
	
	



	//Metodo que valida y cuentas las secuencias por fila
	public static int validarFila(String[] dna) {

		int contador_secuencias = 0;
		
		for(String cad: dna) {
			
			if(encuentraSecuencia(cad)) {
				contador_secuencias++;
			}
		
		}
		
		
		return contador_secuencias;
	}
	
	//Metodo que valida las secuencias por columnas
	public static int validarColumnas(String[] dna) {
		int tamanioFila = dna.length;
		int contador_secuencias = 0;
		for(int i = 0; i<tamanioFila; i++) {
			String cadenaTemporal = "";
			for(String cad: dna) {
				cadenaTemporal = cadenaTemporal+cad.charAt(i);
			}
			
			if(encuentraSecuencia(cadenaTemporal)) {
				contador_secuencias++;
			}
			
		}
		
		return contador_secuencias;
	}
	
	public static int validarOblicuas(String[] dna) {
		int contador_secuencias = 0;
		int n = dna.length-1;
		String cadenaTemporal1 = "";
		String cadenaTemporal2 = "";
		int contador1 = 0, contador2 = n;
		for(String cad: dna) {
			cadenaTemporal1 = cadenaTemporal1+cad.charAt(contador1);
			cadenaTemporal2 = cadenaTemporal2+cad.charAt(contador2);
			contador1++;
			contador2--;
			

		}
		if(encuentraSecuencia(cadenaTemporal1)) {
			contador_secuencias++;
		}
		
		if(encuentraSecuencia(cadenaTemporal2)) {
			contador_secuencias++;
		}
		
		return contador_secuencias;
	}
	
	
	public static boolean encuentraSecuencia(String cad) {
		int contadorDeLetras = 1;
		char letra_actual = '0';
		for(int i = 0; i < cad.length(); i++) {
			//Validar si son iguales
			if(letra_actual == cad.charAt(i)) {
				contadorDeLetras++;
				
			}else {
				contadorDeLetras = 1;				
			}
			
			letra_actual = cad.charAt(i);
			if(contadorDeLetras == 4) {
				return true;
				
			}
		}
		return false;
	}
	
	
	public static boolean validaADN(String[] dna) {
		int numeroFilas = 0;
		int numeroColumnas = 0;
		
		numeroFilas = dna.length;
		
		for(String cad: dna) {
			
			if(cad.length() != numeroFilas) {
				return false;
			}
			
			
		}
		
		
		return true;
	}
	
	
}
