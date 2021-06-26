package it.polito.tdp.PremierLeague.model;

public class CoppiaMatch {
	
	private Match m1;
	private Match m2;
	
	public CoppiaMatch(Match m1, Match m2) {
		super();
		this.m1 = m1;
		this.m2 = m2;
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
	
	
	

}
