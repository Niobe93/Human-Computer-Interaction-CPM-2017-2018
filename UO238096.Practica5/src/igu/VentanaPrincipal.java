package igu;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Component;
import java.awt.Toolkit;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.Font;

import javax.swing.SwingConstants;

import java.awt.GridLayout;

import javax.swing.border.LineBorder;

import logica.Carrera;

import logica.Corredor;
import logica.Dado;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class VentanaPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnDado;
	private JTextField textTiradasDado;
	private JTextField txtScore;
	private JTextField textPuntosLiebre;
	private JPanel panelLiebre;
	private JButton btn0L;
	private JButton btn1L;
	private JButton btn3L;
	private JButton btn4L;
	private JButton btn5L;
	private JButton btn2L;
	private JButton btn6L;
	private JButton btn7L;
	private JButton btn8L;
	private JButton btn9L;
	private JButton btn10L;
	private Carrera carrera;
	private JTextField textTrampa;
	private JTextField textSuperPoder;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Constructor de la ventana principal. 
	 */
	public VentanaPrincipal() {
		carrera = new Carrera();  //creamos el objeto carrera que se encarga de llamar a los demas constructores
		setResizable(false);
		setTitle("El juego de la liebre y la zanahoria.");
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				VentanaPrincipal.class.getResource("/img/liebre.JPG")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getBtnDado());
		contentPane.add(getTextTiradasDado());
		contentPane.add(getTxtScore());
		contentPane.add(getTextPuntosLiebre());
		contentPane.add(getPanelLiebre());
		contentPane.add(getTextTrampa());
		contentPane.add(getTextSuperPoder());		
		representarEstadoJuego();
	}

	private JButton getBtnDado() {
		if (btnDado == null) {
			btnDado = new JButton("");
			btnDado.setDisabledIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/dado.JPG")));
			btnDado.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					lanzarDado();
				}

			});
			btnDado.setBorder(null);
			btnDado.setIcon(new ImageIcon(VentanaPrincipal.class
					.getResource("/img/dado.JPG")));
			btnDado.setBounds(42, 30, 69, 92);
		}
		return btnDado;
	}

	private void lanzarDado() {
		boolean jugadaPosible = carrera.lanzarDado();
		textTiradasDado.setText(String.valueOf(Dado.getValor()));
		if (jugadaPosible) {
			habilitarPanel();
			btnDado.setEnabled(false);
		} else {
			JOptionPane.showMessageDialog(this,
					"La jugada no es posible, vuelve a tirar.");
			textTiradasDado.setText("");

		}
	}

	private void modificarPanel(JPanel panel, boolean habilitar) {

		for (Component componente : panel.getComponents()) {
			componente.setEnabled(habilitar);
		}
	}

	private void habilitarPanel() {
		modificarPanel(panelLiebre, true);
	}

	private void deshabilitarPanel() {
		modificarPanel(panelLiebre, false);
	}

	private JTextField getTextTiradasDado() {
		if (textTiradasDado == null) {
			textTiradasDado = new JTextField();
			textTiradasDado.setEditable(false);
			textTiradasDado.setBorder(null);
			textTiradasDado.setForeground(Color.GREEN);
			textTiradasDado.setFont(new Font("Tahoma", Font.BOLD, 53));
			textTiradasDado.setBackground(Color.BLACK);
			textTiradasDado.setBounds(133, 30, 58, 60);
			textTiradasDado.setColumns(10);
		}
		return textTiradasDado;
	}

	private JTextField getTxtScore() {
		if (txtScore == null) {
			txtScore = new JTextField();
			txtScore.setEditable(false);
			txtScore.setBorder(null);
			txtScore.setText("SCORE");
			txtScore.setForeground(Color.YELLOW);
			txtScore.setFont(new Font("Jokerman", Font.BOLD, 53));
			txtScore.setBackground(Color.BLACK);
			txtScore.setBounds(465, 28, 223, 66);
			txtScore.setColumns(10);
		}
		return txtScore;
	}

	private JTextField getTextPuntosLiebre() {
		if (textPuntosLiebre == null) {
			textPuntosLiebre = new JTextField();
			textPuntosLiebre.setHorizontalAlignment(SwingConstants.CENTER);
			textPuntosLiebre.setForeground(Color.MAGENTA);
			textPuntosLiebre.setFont(new Font("Tahoma", Font.BOLD, 41));
			textPuntosLiebre.setBackground(Color.BLACK);
			textPuntosLiebre.setEditable(false);
			textPuntosLiebre.setText("0");
			textPuntosLiebre.setBounds(718, 36, 128, 50);
			textPuntosLiebre.setColumns(10);
		}
		return textPuntosLiebre;
	}

	private JPanel getPanelLiebre() {
		if (panelLiebre == null) {
			panelLiebre = new JPanel();
			panelLiebre.setBorder(new LineBorder(Color.BLUE, 5));
			panelLiebre.setBackground(Color.BLUE);
			panelLiebre.setBounds(30, 164, 835, 80);
			panelLiebre.setLayout(new GridLayout(1, 11, 2, 0));
			panelLiebre.add(getBtn0L());
			panelLiebre.add(getBtn1L());
			panelLiebre.add(getBtn2L());
			panelLiebre.add(getBtn3L());
			panelLiebre.add(getBtn4L());
			panelLiebre.add(getBtn5L());
			panelLiebre.add(getBtn6L());
			panelLiebre.add(getBtn7L());
			panelLiebre.add(getBtn8L());
			panelLiebre.add(getBtn9L());
			panelLiebre.add(getBtn10L());
			deshabilitarPanel();
		}
		return panelLiebre;
	}
/** Metodos de las casillas asociadas a botones*/
	private JButton getBtn0L() {
		if (btn0L == null) {
			btn0L = new JButton("");
			btn0L.setDisabledIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/liebre.JPG")));
			btn0L.setBorder(null);
			btn0L.setBackground(Color.BLACK);
			
		}
		return btn0L;
	}

	private JButton getBtn1L() {
		if (btn1L == null) {
			btn1L = new JButton("");
			btn1L.setBackground(Color.BLACK);
			btn1L.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					jugar(1);
				}
			});
		}
		return btn1L;
	}

	private JButton getBtn2L() {
		if (btn2L == null) {
			btn2L = new JButton("");
			btn2L.setBackground(Color.BLACK);
			btn2L.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					jugar(2);
				}
			});
		}
		return btn2L;
	}

	private JButton getBtn3L() {
		if (btn3L == null) {
			btn3L = new JButton("");
			btn3L.setBackground(Color.BLACK);
			btn3L.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					jugar(3);
				}
			});
		}
		return btn3L;
	}

	private JButton getBtn4L() {
		if (btn4L == null) {
			btn4L = new JButton("");
			btn4L.setBackground(Color.BLACK);
			btn4L.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					jugar(4);
				}
			});
		}
		return btn4L;
	}

	private JButton getBtn5L() {
		if (btn5L == null) {
			btn5L = new JButton("");
			btn5L.setBackground(Color.BLACK);
			btn5L.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					jugar(5);
				}
			});
		}
		return btn5L;
	}

	private JButton getBtn6L() {
		if (btn6L == null) {
			btn6L = new JButton("");
			btn6L.setBackground(Color.BLACK);
			btn6L.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					jugar(6);
				}
			});
		}
		return btn6L;
	}

	private JButton getBtn7L() {
		if (btn7L == null) {
			btn7L = new JButton("");
			btn7L.setBackground(Color.BLACK);
			btn7L.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					jugar(7);
				}
			});
		}
		return btn7L;
	}

	private JButton getBtn8L() {
		if (btn8L == null) {
			btn8L = new JButton("");
			btn8L.setBackground(Color.BLACK);
			btn8L.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					jugar(8);
				}
			});
		}
		return btn8L;
	}

	private JButton getBtn9L() {
		if (btn9L == null) {
			btn9L = new JButton("");
			btn9L.setBackground(Color.BLACK);
			btn9L.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					jugar(9);
				}
			});
		}
		return btn9L;
	}

	private JButton getBtn10L() {
		if (btn10L == null) {
			btn10L = new JButton("");		
			btn10L.setBackground(Color.BLACK);
			btn10L.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					jugar(10);
				}
			});
			
		}
		return btn10L;
	}

	
	
	private void jugar(int posicion) {

		if (carrera.resolverJugada(posicion)) {
			representarEstadoJuego();
			deshabilitarPanel();
		}
		
	}
	
	private void resetDado() {
		btnDado.setEnabled(true);
		textTiradasDado.setText("");
	}
	
	/** Metodo que va representando el estado de juego.
	 * 
	 */
	private void representarEstadoJuego() {

		pintarPuntos();
		pintarCorredor();

		if (carrera.isPartidaFinalizada())
			pintarPartidaFinalizada();

		if (carrera.isCasillaSuperPoder())
			pintarActivacionSuperPoder();

		if (carrera.isTrampa()) {
			if (carrera.getLiebre().isStatusPoder() == false)
				pintarCaidaTrampa();
			else
				pintarLibrarseTrampa();	}
		else 
			resetDado();
	}
	
	/**Metodos que pintan las diferentes opciones de jugadas
	 * 
	 */

	private void pintarPartidaFinalizada() {
		getBtn10L().setIcon(new ImageIcon(
				getClass().getResource("/img/liebre - comiendo.jpg")));
		textPuntosLiebre.setText(String.valueOf(carrera.getLiebre().getPuntuacion()));
		JOptionPane.showMessageDialog(this, "Partida finalizada");
		
	}
	
	private void pintarCaidaTrampa() {
		
		getBtn10L().setIcon(null);
		textPuntosLiebre.setText(String.valueOf(0));
		JOptionPane.showMessageDialog(this, "¡TRAMPA! Partida finalizada ");		
	}
	
	private void pintarLibrarseTrampa() {
		JOptionPane.showMessageDialog(this, "¡Uso del SuperPoder en la trampa! +1000 pts");
		carrera.getLiebre().incrementaPuntuacion(1000);
		textPuntosLiebre.setText(String.valueOf(carrera.getLiebre().getPuntuacion()));
		resetDado();
	}
		
		
	private void pintarActivacionSuperPoder() {		
		textPuntosLiebre.setText(String.valueOf(carrera.getLiebre().getPuntuacion()));
		JOptionPane.showMessageDialog(this, "Super Poder Activado");
		resetDado();		
	}

	private void pintarCorredor() {
		pintarCalle(carrera.getLiebre(), panelLiebre.getComponents());

	}

	private void pintarPuntos() {
		textPuntosLiebre.setText(String.valueOf(carrera.getLiebre().getPuntuacion()));

	}

	/** Metodo que pinta la calle a medida que el juego avanza
	 * 
	 * @param corredor, el corredor de la calle asignada
	 * @param botones, los botones del panel del corredor
	 */
	private void pintarCalle(Corredor corredor, Component[] botones) {
		
		for (int i = 0; i < botones.length; i++) {
			JButton boton = (JButton) botones[i];
			if (i == corredor.getPosicion()) {	//si el boton coincide con la posicion				
				boton.setIcon(getImage(corredor));
				boton.setDisabledIcon(getImage(corredor));
				
			}else {
				boton.setIcon(null);
				boton.setDisabledIcon(null);
			}
		}

		((JButton) botones[botones.length - 1]).setIcon(new ImageIcon(getClass().getResource("/img/zanahoria.jpg")));
		((JButton) botones[botones.length - 1])
				.setDisabledIcon(new ImageIcon(getClass().getResource("/img/zanahoria.jpg")));

	}
	
	/** Metodo que nos devuelve la imagen que se debe de poner en el corredor en funcion
	 * de si hay trampa, si tiene superpoderes, etc..
	 * @param corredor
	 * @return imagen correspondiente
	 */
	private ImageIcon getImage(Corredor corredor) {
		
		if (carrera.getLiebre().isStatusPoder()==true || carrera.getCasillaSuperPoder()== corredor.getPosicion() ) {			
			return new ImageIcon(getClass().getResource("/img/liebre-superPoder.jpg"));}
		
		else if (carrera.getTrampa() == corredor.getPosicion()) {			
			return new ImageIcon(getClass().getResource("/img/liebre-trampa.jpg"));}
		
		
			return new ImageIcon(getClass().getResource("/img/liebre.jpg"));
		}
		
	/** Metodos auxiliares para comprobar que todo funciona
	 * 
	 * @return
	 */
	private JTextField getTextTrampa() {
		if (textTrampa == null) {
			textTrampa = new JTextField();
			textTrampa.setEditable(false);
			textTrampa.setBounds(244, 51, 86, 20);
			textTrampa.setColumns(10);
			textTrampa.setText(String.valueOf(carrera.getTrampa()));
		}
		return textTrampa;
	}
	
	
	private JTextField getTextSuperPoder() {
		if (textSuperPoder == null) {
			textSuperPoder = new JTextField();
			textSuperPoder.setEditable(false);
			textSuperPoder.setBounds(244, 90, 86, 20);
			textSuperPoder.setColumns(10);
			textSuperPoder.setText(String.valueOf(carrera.getCasillaSuperPoder()));
		}
		return textSuperPoder;
	}
}
