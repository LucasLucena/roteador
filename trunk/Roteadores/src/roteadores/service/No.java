package roteadores.service;

public class No implements Comparable<No>{

	private int id;
	
	private String porta;
	
	private String ip;
	
	public No(int id, String porta, String ip) {
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
		if (! (o instanceof No))
			return false;
		else {
			No r = (No)o;
			return this.id == r.getId();
		}
	}
	
	public int compareTo(No no) {
		return this.id - no.id;
	}
	
	public int compareTo(int id) {
		return this.id - id;
	}
	
	public String toString() {
		return id + " " + porta + " " + ip;
	}
	
}
