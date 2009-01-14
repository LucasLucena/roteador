package roteadores.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

import roteadores.exception.ArquivoException;
import roteadores.service.No;

public class RoteadorConfig {

	private static final String nomeArquivo = "roteador.config";
	private static RoteadorConfig instacia;
	private LerArquivo leArquivo;
	private Map<String, No> nos; 
	
	public static RoteadorConfig getInstance() {
		if (instacia == null) {
			instacia = new RoteadorConfig();
		}
		return instacia; 
	}
	
	private RoteadorConfig() {
		leArquivo = new LerArquivo(nomeArquivo);
		nos = criaNos();
	}
	
	private No criaNo(String line) {
		StringTokenizer stk = new StringTokenizer(line);
		String id = stk.nextToken();
		String porta = stk.nextToken();
		String ip = stk.nextToken();
		return new No(id, ip, porta);
	}
	
	private Map<String,No> criaNos() {
		nos = new HashMap<String, No>();
		while(leArquivo.ready()) {
			try {
				No noTemp = criaNo(leArquivo.getLine());
				nos.put(noTemp.getId(), noTemp);
			} catch (ArquivoException e) {
				//TODO TIRAR ISSO DEPOIS
				e.printStackTrace();
			}
		}
		return nos;
	}
	
	public Set<String> getIdNos() {
		return this.nos.keySet();
	}
	
	public List<No> getNos() {
		return (List<No>) this.nos.values();
	}
	
	public boolean roteadorExiste(String id) {
		return nos.containsKey(id);
	}
	
	public No getNo(String id) {
		return nos.get(id);
	}
	
	public String toString() {
		String str = "";
		
		return str;
	}
}
