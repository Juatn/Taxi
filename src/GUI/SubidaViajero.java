package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;

public class SubidaViajero extends JFrame{

	protected JFrame frame;
	protected JTextPane textContador;
	protected boolean controlcontador=false;
	private Thread contador;
	protected int segundos=0;
	protected double precio=0;
	protected double preciofinal=0;
	protected double tarifa=0;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SubidaViajero window = new SubidaViajero();
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
	public SubidaViajero() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 642, 390);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		JLabel lbContador = new JLabel("0");
		lbContador.setHorizontalAlignment(SwingConstants.CENTER);
		lbContador.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lbContador.setVisible(false);
		
		JCheckBox checkaero = new JCheckBox("Aeropuerto");
		checkaero.setBounds(454, 243, 139, 29);
		frame.getContentPane().add(checkaero);
		
		JCheckBox boxnoche = new JCheckBox("Noche");
		boxnoche.setBounds(454, 176, 139, 29);
		frame.getContentPane().add(boxnoche);
		
		JRadioButton radiofestivos = new JRadioButton("Sabados/Festivos");
		radiofestivos.setBounds(454, 107, 155, 29);
		frame.getContentPane().add(radiofestivos);
		
		JRadioButton radiolunesviernes = new JRadioButton("Lunes a viernes");
		radiolunesviernes.setBounds(454, 51, 155, 29);
		frame.getContentPane().add(radiolunesviernes);
		lbContador.setBounds(103, 87, 205, 66);
		frame.getContentPane().add(lbContador);
		
		
		JLabel lbprecio = new JLabel();
		lbprecio.setText("3.65");
		lbprecio.setVisible(false);
		lbprecio.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbprecio.setBounds(333, 87, 106, 66);
		frame.getContentPane().add(lbprecio);
		/// CALCULO TARIFAS
		
				if(radiofestivos.isSelected()==true){
					lbprecio.setText("4.55");
					tarifa=0.26f;
				}
				if(radiolunesviernes.isSelected()){
					lbprecio.setText("3.65");
					tarifa=0.18f;
				}
				if(boxnoche.isSelected()){
					precio=precio+2;
				}
				if(checkaero.isSelected()){
					precio=precio+5.5;
				}
		
		
		JButton btnGo = new JButton("GO");
		btnGo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				controlcontador = true;
				lbContador.setVisible(true);
				lbprecio.setVisible(true);
				
				contador = new Thread(new Runnable(){
					@Override
					public void run() {
						segundos = Integer.parseInt(lbContador.getText());
						double preciox=Double.parseDouble(lbprecio.getText());
						double preciototal=preciox+precio;
						
						
						
						while(controlcontador){
							try{
							Thread.sleep(1000);
							}catch(Exception e){}
							segundos++;
							if(segundos>=5){
							preciototal=preciototal+0.18;
							segundos=0;
							}
							lbContador.setText("" + segundos);
							lbprecio.setText(preciototal+" Euros");
							
						}
						
									
				}
				});
				contador.start();
			}
		});
		btnGo.setBounds(216, 29, 115, 29);
		frame.getContentPane().add(btnGo);
		
		JButton btnFintrayecto = new JButton("Fin del trayecto");
		btnFintrayecto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				controlcontador=false;
			}
		});
		btnFintrayecto.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnFintrayecto.setBounds(161, 169, 255, 125);
		frame.getContentPane().add(btnFintrayecto);
		
		
	}
}
