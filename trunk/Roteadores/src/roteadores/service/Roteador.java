package roteadores.service;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import roteadores.util.EnlaceConfig;
import roteadores.util.RoteadorConfig;

public class Roteador extends TimerTask{
	
	private String id;
	private String porta;
	private String ip;
	private TabelaRotas tabelaRoteamento;
	private List<Vizinho> vizinhos;
	private UDPServer udpServer;
	
	public Roteador(String id) {
		this.id = id;
		
		RoteadorConfig noConfig = RoteadorConfig.getInstance();
		if (!noConfig.roteadorExiste(id)) {
			System.err.print("Roteador nao existe!");
			System.exit(1);
		}
		
		this.ip = noConfig.getNo(id).getIp();
		this.porta = noConfig.getNo(id).getPorta();
		
		EnlaceConfig enlaceConfig = EnlaceConfig.getInstace(this);
		
		vizinhos = enlaceConfig.getVizinhos(id);
		tabelaRoteamento = new TabelaRotas(this);
		
		tabelaRoteamento.inicializar();
		inicializar();
	}
	
	private void inicializar() {
		Timer timer = new Timer();
		this.udpServer = new UDPServer(this);
		this.udpServer.start();
		avizaAosVizinhos();
		timer.schedule(this, 400, 8000);
	}
	
	private void avizaAosVizinhos() {
		System.out.println(getHora() + ": Roteador " + getId() + " ligado.");
		for (Vizinho vizinhoAtual : vizinhos) {
			if (vizinhoAtual.isLigado()) {
				System.out.println("< " + vizinhoAtual.getNo().getId() + " >");
				
			}
		}
	}

	private String getHora() {
		GregorianCalendar calendar = new GregorianCalendar();
		int h = calendar.get(Calendar.HOUR_OF_DAY);
		int m = calendar.get(Calendar.MINUTE);
		int s = calendar.get(Calendar.SECOND);
		return h + ":" + m + ":" + s;
	}

	public String getId() {
		return this.id;
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

	public void setId(String id) {
		this.id = id;
	}

	public List<Vizinho> getVizinhos() {
		return vizinhos;
	}

	public void setVizinhos(List<Vizinho> vizinhos) {
		this.vizinhos = vizinhos;
	}
	
	public Vizinho getVizinho(String id) {
		for (Vizinho vizinho : vizinhos) {
			if (vizinho.getNo().getId().compareTo(id) == 0)
				return vizinho;
		}
		return null;
	}
	
	public boolean ehVizinho(String id) {
		for (Vizinho vizinho : vizinhos) {
			if (vizinho.getNo().getId().compareTo(id) == 0)
				return true;
		}
		return false;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
