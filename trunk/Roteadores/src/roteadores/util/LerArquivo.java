package roteadores.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

import roteadores.exception.ArquivoException;


public class LerArquivo {
	
	private final String nomeArquivo;
	private BufferedReader file;
	
	public LerArquivo(String nome) {
		this.nomeArquivo = nome;	
		try {
			file = new BufferedReader(new FileReader(new File(nomeArquivo)));
		} catch (FileNotFoundException e) {
			System.err.println("Arquivo nao encontrado.");
			System.exit(1);
		}
	}
	
	public String getLine() throws ArquivoException {
		try {
			if (file.ready()) 
				return file.readLine();
			else
				return null;
		} catch (IOException e) {
			throw new ArquivoException("erro na leitura do arquivo");
		}
	}
	
	public boolean ready() {
		try {
			return file.ready();
		} catch (IOException e) {
			System.err.println("Erro na leitura do arquivo");
			System.exit(1);
		}
		return false;
	}
	
	/**
	public static void main(String[] args) throws FileNotFoundException, ArquivoException {
		LerArquivo enlace = new LerArquivo("enlaces.config");
		//StringBuilder line = enlace.getLine();
		while(line != null) {
			System.out.println(line);
			line = enlace.getLine();
		}
	}*/
}
