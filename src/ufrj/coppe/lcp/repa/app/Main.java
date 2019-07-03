package ufrj.coppe.lcp.repa.app;

import ufrj.coppe.lcp.repa.api.*;

public class Main {

	public static void main(String[] args) {
		
		try {
		   
			RepaSocket repaSocket = new RepaSocket("plugins/librepa.so");
			
			repaSocket.repaOpen();
			
			repaSocket.registerInterest("Velocidade");
			//repaSocket.registerInterest("Posi��o");
			//repaSocket.registerInterest("Identifica��o");
			//repaSocket.registerInterest("Proximo ponto");
			
			repaSocket.repaSend(new RepaMessage("velocidade","mensagem da velocidade".getBytes(), new PrefixAddress()));
			//repaSocket.repaSend(new RepaMessage("posi��o","mensagem da posi��o".getBytes(), new PrefixAddress()));
			//repaSocket.repaSend(new RepaMessage("identifica��o","mensagem da identifica��o".getBytes(), new PrefixAddress()));
			//repaSocket.repaSend(new RepaMessage("proximo ponto","mensagem de proximo ponto".getBytes(), new PrefixAddress()));
			
			RepaMessage message = repaSocket.repaRecv();
			
			if(message != null) 
				System.out.println(message);
			
			repaSocket.repaClose();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
