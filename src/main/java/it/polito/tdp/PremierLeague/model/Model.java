package it.polito.tdp.PremierLeague.model;

import java.util.ArrayList;
import java.util.HashMap;
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
	
	
	public List<Integer> getMesi(){
		List<Integer> mesi = new ArrayList<>();
		
		for(int i=1; i<13; i++) {
			mesi.add(i);
		}
		
		return mesi;
	}
	
}
