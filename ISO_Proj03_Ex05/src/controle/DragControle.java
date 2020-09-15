package controle;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class DragControle {
	
	static JLabel carro1;
	static JLabel carro2;
	static JTextField perdedor;
	static JTextField vencedor;
	static int [] win = new int [2];
	
	public DragControle(JLabel carro1, JLabel carro2) {
		
		DragControle.carro1 = carro1;
		DragControle.carro2 = carro2;
		
	}
	
	public DragControle(JTextField perdedor, JTextField vencedor) {
				
		DragControle.perdedor = perdedor;
		DragControle.vencedor = vencedor;
		
	}
	
	
	public static void move_imagem (int ID,int carro) {
		if(ID == 1) {	
			carro1.setLocation(carro, 105);
		}
		if(ID==2) {
			carro2.setLocation(carro, 230);
		}
	}
	
	public static void preencher() {
		win[0] = 0;
		win[1] = 0;
				
	}
	
	public static void vencedor (int ID) {
		if (win[0] == 0) {
			win[0] = ID;
		}
		else {
			win[1] = ID;
		}
	}
	
	public static void anuncio () {
		if(win[0] == 1) {
			vencedor.setText("carro 1 venceu!!");
			perdedor.setText("carro 2 perdeu!!");
		}
		else {
			vencedor.setText("carro 2 venceu!!");
			perdedor.setText("carro 1 perdeu!!");
		}
	}

}
