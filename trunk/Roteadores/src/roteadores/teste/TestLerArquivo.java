package roteadores.teste;

import java.io.FileNotFoundException;

import roteadores.exception.ArquivoException;
import roteadores.util.LerArquivo;
import junit.framework.TestCase;

public class TestLerArquivo extends TestCase {

	public void testGetLine() {
		try {
			LerArquivo enlace = new LerArquivo("enlaces.config");
			try {
				assertEquals("1 2 10", enlace.getLine());
				assertEquals("1 3 15", enlace.getLine());
				assertEquals("2 4 2", enlace.getLine());
				assertEquals("2 5 5", enlace.getLine());
				assertEquals("3 4 2", enlace.getLine());
				assertEquals("4 6 10", enlace.getLine());
				assertEquals("5 6 5", enlace.getLine());
			} catch (ArquivoException e) {
				System.err.println("Fim do arquivo...");
			}
			
		} catch (FileNotFoundException e) {
			System.err.println("Arquivo nao encontrado...");
		}
	}
}
