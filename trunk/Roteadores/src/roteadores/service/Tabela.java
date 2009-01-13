package roteadores.service;

import java.util.List;

public class Tabela {

	private List<VetorDistancia> vetoresDistacia;
	private int idDonoTabela;
	
	public Tabela(List<VetorDistancia> vetoresDistancia, int idDonoTabela) {
		this.vetoresDistacia = vetoresDistancia;
		this.idDonoTabela = idDonoTabela;
	}
}
