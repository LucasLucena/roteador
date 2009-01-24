package roteadores.service;

import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

public class UDPClient extends Thread {
	
	private String ipServer;
	private String portaServer;
	private String idServer;
	private Roteador roteador;
	
	public UDPClient (String ipServer, String portaServer, String idServer, 
		Roteador rotedor) {
		this.ipServer = ipServer;
		this.portaServer = portaServer;
		this.idServer = idServer;
		this.roteador = rotedor;
	}
	
	public void run() {
		try {
			InetAddress IPAddress = InetAddress.getByName(this.ipServer);
			
			try {
				DatagramSocket clientSocket = new DatagramSocket();
				clientSocket.setSoTimeout(400);
				
				byte[] sendData = new byte[1024];
				byte[] receiveData = new byte[1024];
				
				
			} catch (SocketException e) {
				e.printStackTrace();
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

	public String getIpServer() {
		return ipServer;
	}

	public void setIpServer(String ipServer) {
		this.ipServer = ipServer;
	}

	public String getPortaServer() {
		return portaServer;
	}

	public void setPortaServer(String portaServer) {
		this.portaServer = portaServer;
	}

	public String getIdServer() {
		return idServer;
	}

	public void setIdServer(String idServer) {
		this.idServer = idServer;
	}

	public Roteador getRoteador() {
		return roteador;
	}

	public void setRoteador(Roteador roteador) {
		this.roteador = roteador;
	}

}
