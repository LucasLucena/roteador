package roteadores.service;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPServer extends Thread {

	private static final String separador = "|";
	public String porta;
	public Roteador roteador;
	
	public UDPServer (Roteador roteador){
		this.roteador = roteador;
		this.porta = roteador.getPorta();
	}

	public void run() {
		while(true) {
			try {
				DatagramSocket serverSocket = new DatagramSocket(Integer.parseInt(porta));
				byte[] receiveData = new byte[1024];
				byte[] sendData = new byte[1024];
				while(true) {
					DatagramPacket receivePacket = new DatagramPacket(
						receiveData,receiveData.length);
					try {
						serverSocket.receive(receivePacket);
						String dadosRecebidos = new String(receivePacket.getData(),
							receivePacket.getOffset(),receivePacket.getLength());
						//TODO CHAMA O METODO PARA TRATAMENTO DA TABELA
						InetAddress IPAddress = receivePacket.getAddress();
						int port = receivePacket.getPort();
						DatagramPacket sendPacket = new DatagramPacket(
							sendData,sendData.length,IPAddress,port);
						serverSocket.send(sendPacket);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (SocketException e) {
				e.printStackTrace();
			}
		}
	}
	
	public String getPorta() {
		return porta;
	}

	public void setPorta(String porta) {
		this.porta = porta;
	}

	public Roteador getRoteador() {
		return roteador;
	}

	public void setRoteador(Roteador roteador) {
		this.roteador = roteador;
	}
}
