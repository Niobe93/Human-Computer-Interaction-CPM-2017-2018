package igu;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Ventana extends JFrame{
	
	private JButton btAceptar;
	private JButton btCancelar;
	private JPanel panelPrincipal;
	private JLabel etiqueta;
	private JTextField cuadroTexto;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Ventana() {
		this.setBounds(100, 100, 450, 300);
		this.setTitle("Mi primera ventana");
		
		panelPrincipal = new JPanel();
		panelPrincipal.setBackground(Color.WHITE);
		panelPrincipal.setLayout(null);
		this.setContentPane(panelPrincipal);		
		
		btAceptar = new JButton();
		btAceptar.setBounds(170, 220, 100, 30);
		btAceptar.setForeground(Color.BLUE);
		btAceptar.setText("Aceptar");
		
		btCancelar = new JButton(); 
		btCancelar.setBounds(290, 220,100,30 );
		btCancelar.setText("Cancelar");
		btCancelar.setForeground(Color.BLUE);
		
		etiqueta = new JLabel();
		etiqueta.setBounds(30, 80, 150, 20);
		etiqueta.setText("Introduzca su nombre:");
		etiqueta.setForeground(Color.BLACK);
		
		cuadroTexto = new JTextField();
		cuadroTexto.setBounds(180, 80, 200, 25);		
		cuadroTexto.setForeground(Color.WHITE);
		
		
		panelPrincipal.add(btAceptar);
		panelPrincipal.add(btCancelar);
		panelPrincipal.add(etiqueta);
		panelPrincipal.add(cuadroTexto);
		
		this.setLocationRelativeTo(null);
	}

	public static void main(String[] args) {
		Ventana ventana = new Ventana();
		ventana.setVisible(true);
		
	}

}
