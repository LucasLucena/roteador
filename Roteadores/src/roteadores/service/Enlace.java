package roteadores.service;

public class Enlace {
	
	private int idNoOrigem;
	private int idNoDestino;
	private int custo;
	
	
	
	public Enlace(int idOrigem, int idDestino, int custo) {
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


	public int getIdNoOrigem() {
		return idNoOrigem;
	}


	public void setIdNoOrigem(int idNoOrigem) {
		this.idNoOrigem = idNoOrigem;
	}


	public int getIdNoDestino() {
		return idNoDestino;
	}


	public void setIdNoDestino(int idNoDestino) {
		this.idNoDestino = idNoDestino;
	}
	
	
	public String toString() {
		String str = "ID origem = " + this.idNoOrigem + ", " + 
			"ID destino = " + idNoDestino + ", " + "Custo = " + custo + "\n";
		return str;
		
	}

}
