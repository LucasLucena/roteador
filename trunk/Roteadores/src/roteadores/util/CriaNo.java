package roteadores.util;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import roteadores.exception.ArquivoException;
import roteadores.service.No;

public class CriaNo {

	private static final String nomeArquivo = "roteador.config";
	private static CriaNo instacia;
	private LerArquivo leArquivo;
	private List<No> nos; 
	
	public static CriaNo getInstance() {
		if (instacia == null) {
			instacia = new CriaNo();
		}
		return instacia; 
	}
	
	private CriaNo() {
		leArquivo = new LerArquivo(nomeArquivo);
		nos = criaNos();
	}
	
	private No criaNo(String line) {
		StringTokenizer stk = new StringTokenizer(line);
		int id = Integer.parseInt(stk.nextToken());
		String porta = stk.nextToken();
		String ip = stk.nextToken();
		return new No(id, ip, porta);
	}
	
	private List<No> criaNos() {
		nos = new ArrayList<No>();
		while(leArquivo.ready()) {
			try {
				nos.add(criaNo(leArquivo.getLine()));
			} catch (ArquivoException e) {
				//TODO TIRAR ISSO DEPOIS
				e.printStackTrace();
			}
		}
		return nos;
	}
	
	public List<No> getNos() {
		return this.nos;
	}
	
	public String toString() {
		String str = "";
		for (No no : nos) {
			str += no + "\n";
		}
		return str;
	}
	
	public static void main(String[] args) throws FileNotFoundException, ArquivoException {
		CriaNo criaNo = CriaNo.getInstance();
		System.out.println(criaNo.getNos());
	}
}
