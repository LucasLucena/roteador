package roteadores.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import roteadores.util.EnlaceConfig;
import roteadores.util.RoteadorConfig;

public class TabelaRotas {

	final int INFINITY = 999;
	
	private Roteador roteador;
	private Map<String, Integer> vetorDistancia;
	private RoteadorConfig roteadorConfig;
	
	public TabelaRotas(Roteador roteador) {
		this.roteador = roteador;
		vetorDistancia = new HashMap<String, Integer>();
		roteadorConfig = RoteadorConfig.getInstance();
	}
	
	public void inicializar() {
		
		Set<String> roteadores = roteadorConfig.getIdNos();
		for (String idNo : roteadores) {
			if (roteador.getId().compareTo(idNo) == 0)
				vetorDistancia.put(roteador.getId(), 0);
			else if (roteador.ehVizinho(idNo))
				vetorDistancia.put(roteador.getId(), roteador.getVizinho(idNo).getCusto());
			else
				vetorDistancia.put(roteador.getId(), INFINITY);
			
		}
	}

	public Roteador getRoteador() {
		return roteador;
	}

	public void setRoteador(Roteador roteador) {
		this.roteador = roteador;
	}

	public Map<String, Integer> getVetorDistancia() {
		return vetorDistancia;
	}

	public void setVetorDistancia(Map<String, Integer> vetorDistancia) {
		this.vetorDistancia = vetorDistancia;
	}
	
	
}
