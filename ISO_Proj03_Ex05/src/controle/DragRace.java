package controle;

import java.util.Random;

import javax.swing.JLabel;

public class DragRace extends Thread {

	
	JLabel carro;
	int ID;
	
	public DragRace (JLabel carro, int ID) {

		this.carro = carro;
		this.ID = ID;
		
	}
	
	public void run() {
		
		corrida();		
	}

	private void corrida() {
		
		DragControle.preencher();
		Random rand = new Random();
		int chegada = 525;
		int carro = 0;
		while (carro < chegada) {
			carro = carro + rand.nextInt(18);
			if(carro >= chegada ) {
				DragControle.vencedor(ID);
			}
			try {
				DragControle.move_imagem(ID, carro);
				Thread.sleep(100);
			}
			catch (Exception e) {
				System.err.println(e.getMessage());
				}
			}
		DragControle.anuncio();
		}
		
}
