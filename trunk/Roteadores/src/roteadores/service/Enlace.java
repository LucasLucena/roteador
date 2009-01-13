package roteadores.service;

public class Enlace {
	
	private String idNoOrigem;
	private String idNoDestino;
	private int custo;
	
	
	
	public Enlace(String idOrigem, String idDestino, int custo) {
		this.idNoOrigem = idOrigem;
		this.idNoDestino = idDestino;
		this.custo = custo;
	}

	
	public int getCusto() {
		return custo;
	}

	public void setCusto(int custo) {
		this.custo = custo;
	}


	public String getIdNoOrigem() {
		return idNoOrigem;
	}


	public void setIdNoOrigem(String idNoOrigem) {
		this.idNoOrigem = idNoOrigem;
	}

	public String getIdNoDestino() {
		return idNoDestino;
	}


	public void setIdNoDestino(String idNoDestino) {
		this.idNoDestino = idNoDestino;
	}
	
	public boolean equals(Object o) {
		if (!(o instanceof Enlace)){
			return false;
		}
		Enlace other = (Enlace) o;
		return this.toString().equals(other.toString());
	}
	
	public String toString() {
		return this.idNoDestino + " -> " + this.idNoOrigem + " Custo: " + this.custo;
	}

}
