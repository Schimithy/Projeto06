package interação;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controle.DragControle;
import controle.DragRace;

public class DragMain extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DragMain frame = new DragMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	JLabel lblcarro1 = new JLabel("carro1");
	JLabel lblcarro2 = new JLabel("carro2");
	JLabel lblchegada = new JLabel("chegada");
	JTextField txtVencedor;
	JTextField txtPerdedor;
	
	public DragMain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 760, 476);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		ImageIcon img1 = new ImageIcon(this.getClass().getResource("/carro_1.png"));
		ImageIcon img2 = new ImageIcon(this.getClass().getResource("/carro_2.png"));
		ImageIcon img3 = new ImageIcon(this.getClass().getResource("/chegada.png"));
			
		JButton btnstart = new JButton("Start");
		btnstart.setToolTipText("Clique aqui para iniciar a corrida!!");
		btnstart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnstart.setBounds(77, 380, 89, 23);
		contentPane.add(btnstart);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 217, 676, 2);
		contentPane.add(separator);
		
		lblcarro2.setBounds(30, 230, 193, 85);
		contentPane.add(lblcarro2);
		
		lblcarro1.setBounds(30, 105, 193, 85);
		contentPane.add(lblcarro1);
		
		lblchegada.setBounds(688, 11, 46, 415);
		contentPane.add(lblchegada);
		
			lblcarro1.setIcon(img1);
			lblcarro2.setIcon(img2);
			lblchegada.setIcon(img3);
			validate();
		
		txtVencedor = new JTextField();
		txtVencedor.setHorizontalAlignment(SwingConstants.CENTER);
		txtVencedor.setToolTipText("Vencedor!!");
		txtVencedor.setText("Vencedor");
		txtVencedor.setBounds(245, 372, 180, 20);
		contentPane.add(txtVencedor);
		txtVencedor.setColumns(10);
		
		txtPerdedor = new JTextField();
		txtPerdedor.setHorizontalAlignment(SwingConstants.CENTER);
		txtPerdedor.setToolTipText("Perdedor!!");
		txtPerdedor.setText("Perdedor");
		txtPerdedor.setColumns(10);
		txtPerdedor.setBounds(245, 406, 180, 20);
		contentPane.add(txtPerdedor);
		validate();
		
		ActionListener insert = new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				txtVencedor.setText("Vencedor");
				txtPerdedor.setText("Perdedor");
				inicio();
			}
		};
		
		btnstart.addActionListener(insert);
	}
	
	public void inicio() {
		

		DragRace carro1 = new DragRace(lblcarro1, 1);
		carro1.start();
		DragRace carro2 = new DragRace(lblcarro2, 2);
		carro2.start();
		new DragControle(lblcarro1, lblcarro2);
		new DragControle(txtPerdedor, txtVencedor);
		
	}
}
