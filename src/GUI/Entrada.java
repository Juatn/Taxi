package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Entrada extends JFrame{

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Entrada window = new Entrada();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Entrada() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 662, 388);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton ButtonSubida = new JButton("Subida Viajero");
		ButtonSubida.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				frame.setVisible(false);
				SubidaViajero p=new SubidaViajero();
				p.frame.setVisible(true);
				p.controlcontador=true;

				
			 
			}
		});
		ButtonSubida.setBounds(42, 67, 216, 168);
		frame.getContentPane().add(ButtonSubida);
		
		JButton ButtonCaja = new JButton("Caja del dia");
		ButtonCaja.setBounds(344, 67, 216, 168);
		frame.getContentPane().add(ButtonCaja);
	}

}
