package roteadores.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

import roteadores.exception.ArquivoException;
import roteadores.exception.RoteadorException;
import roteadores.service.Enlace;
import roteadores.service.Roteador;
import roteadores.service.Vizinho;

public class EnlaceConfig {

	private static final String nomeArquivo = "enlaces.config";
	private static EnlaceConfig instancia;
	
	private Roteador roteador;
	private List<Enlace> enlaces;
	private LerArquivo leArquivo;
	private List<String> idVizinhos;
	private Map<String, List<Vizinho>> vizinhos;
	
	public static EnlaceConfig getInstace(Roteador roteador) {
		if (instancia == null)
			instancia = new EnlaceConfig(roteador);
		return instancia;
	}
	
	private EnlaceConfig(Roteador roteador) {
		this.roteador = roteador;
		leArquivo = new LerArquivo(nomeArquivo);
		listaDeEnlace();
		inicializaVizinhos();
	}
	
	private void inicializaVizinhos() {
		vizinhos = new HashMap<String, List<Vizinho>>();
		List<Vizinho> listaDeVizinhos = new ArrayList<Vizinho>();
		RoteadorConfig roteadorConfig = RoteadorConfig.getInstance();
		for (Enlace enlace : enlaces) {
			if (roteador.getId().compareTo( enlace.getIdNoOrigem()) == 0) {
				listaDeVizinhos.add(new Vizinho(enlace.getCusto(),
					false,roteadorConfig.getNo(roteador.getId())));
			}
		}
		vizinhos.put(roteador.getId(), listaDeVizinhos);
	}
	
	public List<Vizinho> getVizinhos(String idRoteador) {
		return vizinhos.get(idRoteador);
	}
	
	private void buscaVizinhos() {
		idVizinhos = new ArrayList<String>();
		for (Enlace enlace : enlaces) {
			if (enlace.getIdNoOrigem() == roteador.getId())
				idVizinhos.add(enlace.getIdNoDestino());
		}
	}

	private Enlace criaEnlace(String line) {
		StringTokenizer stk = new StringTokenizer(line);
		String idOrigem = stk.nextToken();
		String idDestino =  stk.nextToken();
		int custo = Integer.parseInt(stk.nextToken());
		if (buscaNo(idOrigem) && buscaNo(idDestino))
			return new Enlace(idOrigem, idDestino, custo);
		else throw new RoteadorException("No Nao Existe!!!");
	}
	
	private List<Enlace> listaDeEnlace()  {
		enlaces = new ArrayList<Enlace>();
		while(leArquivo.ready()) {
			try {
				enlaces.add(criaEnlace(leArquivo.getLine()));
			} catch (ArquivoException e) {
				e.printStackTrace();
			}
		}
		return enlaces;
	}
	
	public List<String> getVizinhos() {
		return this.idVizinhos;
	}
	
	public List<Enlace> getEnlaces() {
		return enlaces;
	}
	
	private boolean buscaNo(String id) {
		Set<String> idNos = RoteadorConfig.getInstance().getIdNos();
		for (String idNo : idNos) {
			if (idNo.compareTo(id) == 0)
				return true;
		}
		return false;
	}
}
