package it.polito.tdp.PremierLeague.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import it.polito.tdp.PremierLeague.db.PremierLeagueDAO;

public class Model {
	
	private PremierLeagueDAO dao;
	private Graph<Match, DefaultWeightedEdge> grafo;
	private Map<Integer,Match> idMap;
	private List<Match> percorsoMigliore;
	private int pesoMax;
	
	public Model() {
		dao=new PremierLeagueDAO();
		idMap= new HashMap<Integer,Match>();
	}
	
	
	public void creaGrafo(int mese, int min) {
		
		grafo = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);
		
		//riempio la mappa
		this.dao.riempiMapMatches(idMap);

		//Aggiungo i vertici---> Tutti i match che si sono giocati nel mese scelto dall'utente
		Graphs.addAllVertices(this.grafo, this.dao.getVertici(mese, idMap));
		
		
		
		//Aggiungere gli archi
		
		List<Adiacenza> result = this.dao.getAdiacenze(mese, min, idMap);
		
		if(result==null) {
			System.out.println("Errore: adiacenza null");
			return;
		}
		
		 for(Adiacenza a : this.dao.getAdiacenze(mese, min, idMap)) {
			 Graphs.addEdgeWithVertices(this.grafo, a.getM1(), a.getM2(), a.getPeso());
		 }
		
		
	}
	
	public int getNumeroVertici() {
		return this.grafo.vertexSet().size();
	}
	
	public int getNumeroArchi() {
		return this.grafo.edgeSet().size();
	}
	
	public List<CoppiaMatch> getMigliore(int mese, int min) {
		
		double giocMax = Double.MIN_VALUE;
		List<CoppiaMatch> result = new ArrayList<>();
		
		for(DefaultWeightedEdge e : this.grafo.edgeSet()) {
			if(this.grafo.getEdgeWeight(e)>giocMax) {
				 giocMax = this.grafo.getEdgeWeight(e);
			}
		}
		
		for(DefaultWeightedEdge dw: this.grafo.edgeSet()) {
			if(this.grafo.getEdgeWeight(dw)==giocMax) {
				result.add(new CoppiaMatch(this.grafo.getEdgeSource(dw), this.grafo.getEdgeTarget(dw)));
			}
		}
		
		return result;
		
	}
	
	public Graph<Match, DefaultWeightedEdge> getGrafo(){
		
		if(this.grafo== null) {
			return null;
		}
		else
		   return this.grafo;
	}
	
	public List<Match> percorsoMigliore(Match m1, Match m2) {
		
		this.percorsoMigliore= new ArrayList<>();
		List<Match> parziale = new ArrayList<>();
		
		this.pesoMax= Integer.MIN_VALUE;
		
		//aggiungo la sorgente alla lista parziale
		
		parziale.add(m1);
		
		int pesoParziale=0;
		cerca(m2,parziale, pesoParziale);
		
		return percorsoMigliore;
}
	
	private void cerca(Match m2, List<Match> parziale, int pesoParziale) {
	
		//condizione terminale
		
		//se siamo arrivati a destinazione (ovvero al vertice m2)
		if(parziale.get(parziale.size()-1).equals(m2)) {
			
			//va verificato anche che tale soluzione sia ottima (ovvero abbia peso massimo)
			 if(pesoParziale>this.pesoMax) {
				 this.percorsoMigliore = new LinkedList<>(parziale);
			 }
			
		}
		
		//altrimenti vanno considerati tutti i vicini
		for(Match vicino: Graphs.neighborListOf(this.grafo, parziale.get(parziale.size()-1))) {
			//verificare se "vicino" è un match tra le due squadre del vertice precedente
			if(!(parziale.get(parziale.size()-1).getTeamHomeID()==vicino.getTeamHomeID() && parziale.get(parziale.size()-1).getTeamAwayID()== vicino.getTeamAwayID())|| (parziale.get(parziale.size()-1).getTeamHomeID()==vicino.getTeamAwayID() && parziale.get(parziale.size()-1).getTeamAwayID()== vicino.getTeamHomeID())){
				parziale.add(vicino);
				DefaultWeightedEdge e = this.grafo.getEdge(parziale.get(parziale.size()-1), vicino);
				pesoParziale+= this.grafo.getEdgeWeight(e);
				
				//ricorsione
				cerca(m2,parziale,pesoParziale);
				
				//backtracking
				pesoParziale-= this.grafo.getEdgeWeight(e);
				parziale.remove(parziale.size()-1);
				
				
			}
		}
		
	}


	public List<Integer> getMesi(){
		List<Integer> mesi = new ArrayList<>();
		
		for(int i=1; i<13; i++) {
			mesi.add(i);
		}
		
		return mesi;
	}
	
}
