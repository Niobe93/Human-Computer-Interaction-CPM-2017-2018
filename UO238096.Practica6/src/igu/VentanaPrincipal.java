package igu;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
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
	private JPanel panelTortuga;
	private JButton btn0T;
	private JButton btn1T;
	private JButton btn2T;
	private JButton btn3T;
	private JButton btn4T;
	private JButton btn5T;
	private JButton btn6T;
	private JButton btn7T;
	private JButton btn8T;
	private JButton btn9T;
	private JButton btn10T;
	private JTextField textPuntosTortuga;
	private JButton btnIconLiebre;
	private JButton btnIconTortuga;
	
	

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
		setTitle("El juego de la liebre y la tortuga.");
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPrincipal.class.getResource("/img/carrot.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 420);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getBtnDado());
		contentPane.add(getTextTiradasDado());
		contentPane.add(getTxtScore());
		contentPane.add(getTextPuntosLiebre());
		contentPane.add(getPanelLiebre());
		contentPane.add(getPanelTortuga());
		contentPane.add(getTextPuntosTortuga());
		contentPane.add(getBtnIconLiebre());
		contentPane.add(getBtnIconTortuga());		
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
			txtScore.setBounds(413, 30, 223, 66);
			txtScore.setColumns(10);
		}
		return txtScore;
	}

	private JTextField getTextPuntosLiebre() {
		if (textPuntosLiebre == null) {
			textPuntosLiebre = new JTextField();
			textPuntosLiebre.setHorizontalAlignment(SwingConstants.CENTER);
			textPuntosLiebre.setForeground(Color.PINK);
			textPuntosLiebre.setFont(new Font("Tahoma", Font.BOLD, 17));
			textPuntosLiebre.setBackground(Color.BLACK);
			textPuntosLiebre.setEditable(false);
			textPuntosLiebre.setText("0");
			textPuntosLiebre.setBounds(718, 33, 128, 23);
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
	
	private void modificarPanel(JPanel panel, boolean habilitar) {

		for (Component componente : panel.getComponents()) {
			componente.setEnabled(habilitar);
		}
	}

	private void habilitarPanel() {
		if(carrera.getLiebre().isTurno()){
			modificarPanel(panelLiebre, true);
		}
		if(carrera.getTortuga().isTurno())
			modificarPanel(panelTortuga, true);
	}

	private void deshabilitarPanel() {
		if(!carrera.getLiebre().isTurno()){
			modificarPanel(panelLiebre, false);
		}
		if(!carrera.getTortuga().isTurno())
			modificarPanel(panelTortuga, false);
	}
	
	private void deshabilitarPaneles() {
		modificarPanel(panelTortuga, false);
		modificarPanel(panelLiebre, false);
		
	}
	
	private JPanel getPanelTortuga() {
		if (panelTortuga == null) {
			panelTortuga = new JPanel();
			panelTortuga.setBorder(new LineBorder(Color.BLUE, 5));
			panelTortuga.setBackground(Color.BLUE);
			panelTortuga.setBounds(30, 270, 835, 80);
			panelTortuga.setLayout(new GridLayout(1, 11, 2, 0));
			panelTortuga.add(getBtn0T());
			panelTortuga.add(getBtn1T());
			panelTortuga.add(getBtn2T());
			panelTortuga.add(getBtn3T());
			panelTortuga.add(getBtn4T());
			panelTortuga.add(getBtn5T());
			panelTortuga.add(getBtn6T());
			panelTortuga.add(getBtn7T());
			panelTortuga.add(getBtn8T());
			panelTortuga.add(getBtn9T());
			panelTortuga.add(getBtn10T());
			deshabilitarPanel();
			
		}
		return panelTortuga;
	}

	
	private void jugar(int posicion) {

		if (carrera.resolverJugada(posicion)) {
			representarEstadoJuego();
			deshabilitarPaneles();
			
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
		pintarCalle(carrera.getLiebre(),panelLiebre.getComponents());
		pintarCalle(carrera.getTortuga(),panelTortuga.getComponents());
		
		if (carrera.isPartidaFinalizada()) {			
			JOptionPane.showMessageDialog(this, "Partida finalizada, ha ganado la " + carrera.getCorredorNOActivo().getNombre());
			deshabilitarPaneles();}

		resetDado();
		
		
	}
	

	private void pintarPuntos() {
		textPuntosLiebre.setText(String.valueOf(carrera.getLiebre().getPuntuacion()));
		textPuntosTortuga.setText(String.valueOf(carrera.getTortuga().getPuntuacion()));

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
		
		//COLCOCAR TRAMPAS, ARBOL , Y SUPERPODER
		if (corredor.getPosicion()!=corredor.getCalleAsignada().getTrampa() && corredor.getCalleAsignada().isTrampaActiva()) {	
			
		  ((JButton) botones[corredor.getCalleAsignada().getTrampa()]).	setIcon(new ImageIcon(getClass().getResource("/img/trampa.png")));		
		  ((JButton) botones[corredor.getCalleAsignada().getTrampa()]).setDisabledIcon(new ImageIcon(getClass().getResource("/img/trampa.png")));	}
	    
		if (corredor.getPosicion()!=corredor.getCalleAsignada().getSuperPoder()) {
		
		((JButton) botones[corredor.getCalleAsignada().getSuperPoder()]).setIcon(new ImageIcon(getClass().getResource("/img/pocion.png")));		
	    ((JButton) botones[corredor.getCalleAsignada().getSuperPoder()]).setDisabledIcon(new ImageIcon(getClass().getResource("/img/pocion.png")));	}
		
		if(corredor==carrera.getLiebre()) {
		     if (carrera.getLiebre().getPosicion()!=carrera.getLiebre().getCalleAsignada().getArbol()) {
			
			((JButton) botones[carrera.getLiebre().getCalleAsignada().getArbol()]).	setIcon(new ImageIcon(getClass().getResource("/img/arbol.jpg")));		
		    ((JButton) botones[carrera.getLiebre().getCalleAsignada().getArbol()]).setDisabledIcon(new ImageIcon(getClass().getResource("/img/arbol.jpg")));}}
	}
	
	
	
	/** Metodo que nos devuelve la imagen que se debe de poner en el corredor en funcion
	 * de si hay trampa, si tiene superpoderes, etc..
	 * @param corredor
	 * @return imagen correspondiente
	 */
	private ImageIcon getImageLiebre() {

		if (carrera.getLiebre().isStatusPoder() == true	|| carrera.getLiebre().getCalleAsignada().getSuperPoder() == carrera.getLiebre().getPosicion()) {
			return new ImageIcon(getClass().getResource("/img/liebre-superPoder.jpg"));
		}

		else if (carrera.getLiebre().getCalleAsignada().getTrampa() == carrera.getLiebre().getPosicion()&& carrera.getLiebre().getCalleAsignada().isTrampaActiva()) {
			return new ImageIcon(getClass().getResource("/img/liebre-trampa.jpg"));
		}

		return new ImageIcon(getClass().getResource("/img/liebre.jpg"));
	}
	
	/** Metodo que nos devuelve la imagen que se debe de poner en el corredor en funcion
	 * de si hay trampa, si tiene superpoderes, etc..
	 * @param corredor
	 * @return imagen correspondiente
	 */

	private ImageIcon getImageTortuga() {
		
		if (carrera.getTortuga().isStatusPoder() == true|| carrera.getTortuga().getCalleAsignada().getSuperPoder() == carrera.getTortuga().getPosicion()) {
			return new ImageIcon(getClass().getResource("/img/tortuga-superPoder.jpg"));
		}

		else if (carrera.getTortuga().getCalleAsignada().getTrampa() == carrera.getTortuga().getPosicion()	&& carrera.getTortuga().getCalleAsignada().isTrampaActiva()) {
			return new ImageIcon(getClass().getResource("/img/tortuga - trampa.jpg"));
		}

		return new ImageIcon(getClass().getResource("/img/tortuga.jpg"));

	}

	private ImageIcon getImage(Corredor corredor) {

		if (corredor.equals(carrera.getTortuga()))
			return this.getImageTortuga();
		else
			return this.getImageLiebre();
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

	
	
	
	private JButton getBtn0T() {
		if (btn0T == null) {
			btn0T = new JButton("");
			btn0T.setDisabledIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/tortuga.JPG")));
			btn0T.setBorder(null);			
			btn0T.setBackground(Color.BLACK);
		}
		return btn0T;
	}
	private JButton getBtn1T() {
		if (btn1T == null) {
			btn1T = new JButton("");
			btn1T.setBackground(Color.BLACK);
			btn1T.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					jugar(1);
				}
			});
		}
		
		return btn1T;
	}
	private JButton getBtn2T() {
		if (btn2T == null) {
			btn2T = new JButton("");
			btn2T.setBackground(Color.BLACK);
			btn2T.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					jugar(2);
				}
			});
		}
		
		return btn2T;
	}
	private JButton getBtn3T() {
		if (btn3T == null) {
			btn3T = new JButton("");
			btn3T.setBackground(Color.BLACK);
			btn3T.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					jugar(3);
				}
			});
		
		}
		return btn3T;
	}
	private JButton getBtn4T() {
		if (btn4T == null) {
			btn4T = new JButton("");
			btn4T.setBackground(Color.BLACK);
			btn4T.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					jugar(4);
				}
			});
		
		}
		return btn4T;
	}
	private JButton getBtn5T() {
		if (btn5T == null) {
			btn5T = new JButton("");
			btn5T.setBackground(Color.BLACK);
			btn5T.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					jugar(5);
				}
			});
		}
		
		return btn5T;
	}
	private JButton getBtn6T() {
		if (btn6T == null) {
			btn6T = new JButton("");
			btn6T.setBackground(Color.BLACK);
			btn6T.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					jugar(6);
				}
			});
		
		}
		return btn6T;
	}
	private JButton getBtn7T() {
		if (btn7T == null) {
			btn7T = new JButton("");
			btn7T.setBackground(Color.BLACK);
			btn7T.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					jugar(7);
				}
			});
		
		}
		return btn7T;
	}
	private JButton getBtn8T() {
		if (btn8T == null) {
			btn8T = new JButton("");
			btn8T.setBackground(Color.BLACK);
			btn8T.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					jugar(8);
				}
			});
		}
		
		return btn8T;
	}
	private JButton getBtn9T() {
		if (btn9T == null) {
			btn9T = new JButton("");
			btn9T.setBackground(Color.BLACK);
			btn9T.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					jugar(9);
				}
			});
		}
		return btn9T;
	}
	private JButton getBtn10T() {
		if (btn10T == null) {
			btn10T = new JButton("");
			btn10T.setBackground(Color.BLACK);
			btn10T.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					jugar(10);
				}
			});
		}
		return btn10T;
	}
	private JTextField getTextPuntosTortuga() {
		if (textPuntosTortuga == null) {
			textPuntosTortuga = new JTextField();
			textPuntosTortuga.setHorizontalAlignment(SwingConstants.CENTER);
			textPuntosTortuga.setForeground(Color.PINK);
			textPuntosTortuga.setFont(new Font("Tahoma", Font.BOLD, 17));
			textPuntosTortuga.setText("0");
			textPuntosTortuga.setBackground(Color.BLACK);
			textPuntosTortuga.setBounds(718, 73, 128, 23);
			textPuntosTortuga.setColumns(10);
		}
		return textPuntosTortuga;
	}
	private JButton getBtnIconLiebre() {
		if (btnIconLiebre == null) {
			btnIconLiebre = new JButton("");
			btnIconLiebre.setBorder(null);
			btnIconLiebre.setBorderPainted(false);
			btnIconLiebre.setBackground(Color.BLACK);
			btnIconLiebre.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/liebre_peq.JPG")));
			btnIconLiebre.setBounds(673, 30, 35, 33);
		}
		return btnIconLiebre;
	}
	private JButton getBtnIconTortuga() {
		if (btnIconTortuga == null) {
			btnIconTortuga = new JButton("");
			btnIconTortuga.setBorder(null);
			btnIconTortuga.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/tortuga_peq.JPG")));
			btnIconTortuga.setBackground(Color.BLACK);
			btnIconTortuga.setBounds(675, 67, 33, 33);
		}
		return btnIconTortuga;
	}
}
