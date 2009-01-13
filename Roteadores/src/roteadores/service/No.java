package roteadores.service;

public class No implements Comparable<No>{

	private String id;
	
	private String porta;
	
	private String ip;
	
	public No(String id, String porta, String ip) {
		this.id = id;
		this.porta = porta;
		this.ip = ip;
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
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
		return compareTo(no.getId());
	}
	
	public int compareTo(String id) {
		return this.compareTo(id);
	}
	
	public String toString() {
		return id + " " + porta + " " + ip;
	}
	
}
