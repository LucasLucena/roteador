package roteadores.util;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import roteadores.exception.ArquivoException;
import roteadores.exception.RoteadorException;
import roteadores.service.Enlace;
import roteadores.service.No;

public class CriaEnlace {

	private static final String nomeArquivo = "enlaces.config";
	private static CriaEnlace instancia;
	
	private List<Enlace> enlaces;
	private LerArquivo leArquivo;
	
	private static CriaEnlace getInstace() {
		if (instancia == null)
			instancia = new CriaEnlace();
		return instancia;
	}
	
	public CriaEnlace() {
		leArquivo = new LerArquivo(nomeArquivo);
		enlaces = tabelaDeEnlaces();
	}
	
	private Enlace criaEnlace(String line) {
		StringTokenizer stk = new StringTokenizer(line);
		int idOrigem = Integer.parseInt(stk.nextToken());
		int idDestino =  Integer.parseInt(stk.nextToken());
		int custo = Integer.parseInt(stk.nextToken());
		if (buscaNo(idOrigem) && buscaNo(idDestino))
			return new Enlace(idOrigem, idDestino, custo);
		else throw new RoteadorException("Roteador Nao Existe!!!");
	}
	
	private List<Enlace> tabelaDeEnlaces()  {
		enlaces = new ArrayList<Enlace>();
		while(leArquivo.ready()) {
			try {
				enlaces.add(criaEnlace(leArquivo.getLine()));
			} catch (ArquivoException e) {
				// TODO TRATAR DEPOIS
				e.printStackTrace();
			}
		}
		return enlaces;
	}
	
	public List<Enlace> getEnlaces() {
		return enlaces;
	}
	
	private boolean buscaNo(int id) {
		List<No> nos = CriaNo.getInstance().getNos();
		for (No no : nos) {
			if (no.compareTo(id) == 0)
				return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		CriaEnlace cEnlace = CriaEnlace.getInstace();
		System.out.println(cEnlace.getEnlaces());
	}
}
