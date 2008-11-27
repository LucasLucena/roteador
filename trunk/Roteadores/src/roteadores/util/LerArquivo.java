package roteadores.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import roteadores.exception.ArquivoException;


public class LerArquivo {
	
	private String nomeArquivo;
	private BufferedReader file;
	
	public LerArquivo(String nome) throws FileNotFoundException {
		this.nomeArquivo = nome;	
		file = new BufferedReader(new FileReader(new File(nomeArquivo)));
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
