package it.polito.tdp.PremierLeague.model;

public class Adiacenza {
	
	private Match m1;
	private Match m2;
	private double peso;
	
	public Adiacenza(Match m1, Match m2, double peso) {
		super();
		this.m1 = m1;
		this.m2 = m2;
		this.peso = peso;
	}

	public Match getM1() {
		return m1;
	}

	public void setM1(Match m1) {
		this.m1 = m1;
	}

	public Match getM2() {
		return m2;
	}

	public void setM2(Match m2) {
		this.m2 = m2;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}
	
	
	
	

}
