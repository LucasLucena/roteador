package roteadores.service;

import java.util.List;

import roteadores.util.EnlaceConfig;
import roteadores.util.RoteadorConfig;

public class Roteador {
	
	private String id;
	private String porta;
	private String ip;
	private Tabela tabelaRoteamento;
	private List<No> vizinhos;
	
	public Roteador(String id) {
		this.id = id;
		//TODO VERIFICA SE O ID EXISTE.
		
		RoteadorConfig noConfig = RoteadorConfig.getInstance();
		if (!noConfig.roteadorExiste(id)) {
			System.err.print("Roteador nao existe!");
			System.exit(1);
		}
		
		EnlaceConfig enlaceConfig = EnlaceConfig.getInstace(this);
		
		List<String> idVizinhos = enlaceConfig.getVizinhos();
	}
	
	public String getId() {
		return this.id;
	}

}
