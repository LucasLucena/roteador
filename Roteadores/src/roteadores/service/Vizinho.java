package roteadores.service;

public class Vizinho {
	
	private int custo;
	private boolean ligado;
	private No no;
	
	public Vizinho(int custo, boolean ligado, No no) {
		this.custo = custo;
		this.ligado = ligado;
		this.no = no;
	}

	public int getCusto() {
		return custo;
	}

	public void setCusto(int custo) {
		this.custo = custo;
	}

	public boolean isLigado() {
		return ligado;
	}

	public void setLigado(boolean ligado) {
		this.ligado = ligado;
	}

	public No getNo() {
		return no;
	}

	public void setNo(No no) {
		this.no = no;
	}
	
	public String toString() {
		String str = no + " custo " + "status ";
		if (ligado) str += " ligado.";
		else str += "desligado";
		return str;
	}

}
