package roteadores.service;

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
		
		for (Enlace enlace : enlaces) {
			if (enlace.getIdNoOrigem() == idDonoVetor) {
				custoAosVizinhos.put(enlace.getIdNoDestino(), enlace.getCusto());
			}
		}
	}
	
	public List<Integer> getVizinhos() {
		return (List<Integer>) custoAosVizinhos.keySet();
	}
	
	public int calculaCusto(int idDestino) {
		
		if (custoAosVizinhos.containsKey(idDestino))
			return custoAosVizinhos.get(idDestino);
		else return infinity;
			
	}
	
	
}
