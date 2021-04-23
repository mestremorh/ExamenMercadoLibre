package com.mestremorh.meli.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "human")
public class Human {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6310391335826300973L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	
	@Column(name = "DNA")
	private  String[] DNA;
	
	@Column(name = "flagMutant")
	private int isMutant;
	
	public Human(String[] dna, int mutant) {
		this.DNA = dna;
		this.isMutant = mutant;
	}
	
	public Human() {
	}

	public  String[] getDNA() {
		return this.DNA;
	}

	public void setDNA(String[] dNA) {
		DNA = dNA;
	}

	public int isMutant() {
		return isMutant;
	}

	public void setMutant(int isMutant) {
		this.isMutant = isMutant;
	}
	
	

}
