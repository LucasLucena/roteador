package roteadores.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VetorDistancia {

	private static final int infinity = 999;
	
	private List<Enlace> enlaces;
	private int idDonoVetor;
	private Map<Integer, Integer> custoAosVizinhos;
	
	public VetorDistancia(List<Enlace> enlaces, int dono) {
		this.enlaces = enlaces;
		this.idDonoVetor = dono;
		custoAosVizinhos = new HashMap<Integer, Integer>();
		searchVizinhos();
	}
	
	public List<Enlace> getEnlaces() {
		return enlaces;
	}
	
	public void setEnlaces(List<Enlace> enlaces) {
		this.enlaces = enlaces;
	}
	
	public int getIdDonoVetor() {
		return idDonoVetor;
	}
	
	public void setIdDonoVetor(int idDonoVetor) {
		this.idDonoVetor = idDonoVetor;
	}
	
	public void searchVizinhos() {
	
	}
	
	public List<Integer> getVizinhos() {
		return (List<Integer>) custoAosVizinhos.keySet();
	}
	
	public int calculaCusto(int idDestino) {
		
		if (custoAosVizinhos.containsKey(idDestino))
			return custoAosVizinhos.get(idDestino);
		else return infinity;		
	}
	
	public String toString() {
		String str = "Dono do vetor: " + idDonoVetor + "\n";
		List<Integer> vizinhos = getVizinhos();
		for (Integer vizinho : vizinhos) {
			str += vizinho + " "; 
		}
		return str;
	}
	
	
}
