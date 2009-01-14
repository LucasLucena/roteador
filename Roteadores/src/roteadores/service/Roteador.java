package roteadores.service;

import java.util.List;

import roteadores.util.EnlaceConfig;
import roteadores.util.RoteadorConfig;

public class Roteador {
	
	private String id;
	private String porta;
	private String ip;
	private Tabela tabelaRoteamento;
	private List<Vizinho> vizinhos;
	
	public Roteador(String id) {
		this.id = id;
		
		RoteadorConfig noConfig = RoteadorConfig.getInstance();
		if (!noConfig.roteadorExiste(id)) {
			System.err.print("Roteador nao existe!");
			System.exit(1);
		}
		
		this.ip = noConfig.getNo(id).getIp();
		this.porta = noConfig.getNo(id).getPorta();
		
		EnlaceConfig enlaceConfig = EnlaceConfig.getInstace(this);
		
		vizinhos = enlaceConfig.getVizinhos(id);
	}
	
	public String getId() {
		return this.id;
	}

	public String getPorta() {
		return porta;
	}

	public void setPorta(String porta) {
		this.porta = porta;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<Vizinho> getVizinhos() {
		return vizinhos;
	}

	public void setVizinhos(List<Vizinho> vizinhos) {
		this.vizinhos = vizinhos;
	}
	
	public Vizinho getVizinho(String id) {
		for (Vizinho vizinho : vizinhos) {
			if (vizinho.getNo().getId().compareTo(id) == 0)
				return vizinho;
		}
		return null;
	}
	
	public boolean ehVizinho(String id) {
		for (Vizinho vizinho : vizinhos) {
			if (vizinho.getNo().getId().compareTo(id) == 0)
				return true;
		}
		return false;
	}

}
