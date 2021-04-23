package com.mestremorh.meli.controllers;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mestremorh.meli.logic.ValidatorDNA;
import com.mestremorh.meli.model.Human;
import com.mestremorh.meli.repositories.HumanRepository;




@RestController
@RequestMapping(path = "/")
public class RestValidator {
	
	 @Autowired(required = true)
		private HumanRepository Ihuman;

	@PostMapping(path = "/mutant/", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<String> restMutant(@RequestBody Human h) {
		String[] dna = h.getDNA();
		
		if(ValidatorDNA.validaADN(dna)) {
		
			if(ValidatorDNA.isMutant(dna)) {
				h.setDNA(dna);
				h.setMutant(1);
				try {
					Ihuman.save(h);
				}catch(Exception e) {
					System.out.println(e.getMessage());
					System.out.println(e.getStackTrace().toString());
					return new ResponseEntity<String>(new String("Error al Insertar"), HttpStatus.CONFLICT);
					
				}
				return new ResponseEntity<String>(new String("Es Mutante"), HttpStatus.OK);
				
				
			}else {
				h.setMutant(0);
				Ihuman.save(h);
				return new ResponseEntity<String>(new String("Es Humano"), HttpStatus.FORBIDDEN);
				
			}
		}else {
			return new ResponseEntity<String>(new String("La Matriz no es NxN"), HttpStatus.SEE_OTHER);
		}
	}
	
	@GetMapping(path = "/stats/", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<HashMap<String, Long>> restStats() {
		
		HashMap<String, Long> map = new HashMap<String, Long>();
		
		
		long cantidadDNA = Ihuman.countByMutant(1);
		long cantidadDNA_Mutant = Ihuman.countByMutant(0);
		
		map.put("count_mutant_dna", cantidadDNA_Mutant);
		map.put("count_human_dna", cantidadDNA);
		map.put("ratio", cantidadDNA_Mutant/cantidadDNA);
		
		
	
	
		
			return ResponseEntity.ok(map);
	}
	


		
	}
	
	

