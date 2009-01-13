import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import roteadores.service.Roteador;


public class SistemaRoteador {

	
	public static void main(String[] args) throws IOException {
		System.out.println("Informe o ID do roteador: ");
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		Roteador roteador = new Roteador(in.readLine());
	}

}
