package roteadores.service;

import java.util.ArrayList;

public class Roteador {

	private int id;
	
	private String porta;
	
	private String ip;
	
	public Roteador(int id, String porta, String ip) {
		this.id = id;
		this.porta = porta;
		this.ip = ip;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPorta() {
		return porta;
	}

	public void setPorta(String porta) {
		this.porta = porta;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}
	
	public boolean equals(Object o) {
		if (! (o instanceof Roteador))
			return false;
		else {
			Roteador r = (Roteador)o;
			return this.id == r.getId();
		}
	}
	
}
