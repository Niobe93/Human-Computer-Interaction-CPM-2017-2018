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

import logica.Calle;
import logica.Carrera;
import logica.Corredor;
import logica.Dado;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;

import javax.swing.JSeparator;


public class VentanaPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private AccionBoton ab;
	private JPanel contentPane;
	private JButton btnDado;
	private JTextField textTiradasDado;
	private JTextField txtScore;
	private JTextField textPuntosLiebre;
	private JPanel panelLiebre;
	private Carrera carrera;
	private JPanel panelTortuga;
	private JTextField textPuntosTortuga;
	private JButton btnIconLiebre;
	private JButton btnIconTortuga;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenu mnAyuda;
	private JMenuItem mntmNuevo;
	private JMenuItem mntmSalir;
	private JSeparator separator;
	private JSeparator separator_1;
	private JMenuItem mntmContenido;
	private JMenuItem mntmAcercaDe;
	private JMenuItem mntmNewMenuItem;
	
	

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
		ab = new AccionBoton();
		setResizable(false);
		setTitle("El juego de la liebre y la tortuga.");
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPrincipal.class.getResource("/img/carrot.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 420);
		setLocationRelativeTo(null);
		setJMenuBar(getMenuBar_1());
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
					lanzarDado();}
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
			//asociarEventosBotones(getPanelLiebre());
			creaBotonesPanel(panelLiebre);
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
			creaBotonesPanel(panelTortuga);
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
	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMnNewMenu());
			menuBar.add(getMnAyuda());
		}
		return menuBar;
	}
	private JMenu getMnNewMenu() {
		if (mnNewMenu == null) {
			mnNewMenu = new JMenu("Juego");
			mnNewMenu.setMnemonic('J');
			mnNewMenu.add(getMntmNuevo());
			mnNewMenu.add(getMntmNewMenuItem());
			mnNewMenu.add(getSeparator());
			mnNewMenu.add(getMntmSalir());
		}
		return mnNewMenu;
	}
	private JMenu getMnAyuda() {
		if (mnAyuda == null) {
			mnAyuda = new JMenu("Ayuda");
			mnAyuda.setMnemonic('A');
			mnAyuda.add(getMntmContenido());
			mnAyuda.add(getSeparator_1());
			mnAyuda.add(getMntmAcercaDe());
		}
		return mnAyuda;
	}
	private JMenuItem getMntmNuevo() {
		if (mntmNuevo == null) {
			mntmNuevo = new JMenuItem("Nuevo");
			mntmNuevo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					carrera.inicializarJuego();
					representarEstadoJuego();
				}
			});
			mntmNuevo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
			mntmNuevo.setMnemonic('N');
		}
		return mntmNuevo;
	}
	private JMenuItem getMntmSalir() {
		if (mntmSalir == null) {
			mntmSalir = new JMenuItem("Salir");
			mntmSalir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
			mntmSalir.setMnemonic('S');
		}
		return mntmSalir;
	}
	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
		}
		return separator;
	}
	private JSeparator getSeparator_1() {
		if (separator_1 == null) {
			separator_1 = new JSeparator();
		}
		return separator_1;
	}
	private JMenuItem getMntmContenido() {
		if (mntmContenido == null) {
			mntmContenido = new JMenuItem("Contenido");
			mntmContenido.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					JOptionPane.showMessageDialog(null, "Ayuda no disponible");
				}
			});
			mntmContenido.setMnemonic('C');
			mntmContenido.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
		}
		return mntmContenido;
	}
	private JMenuItem getMntmAcercaDe() {
		if (mntmAcercaDe == null) {
			mntmAcercaDe = new JMenuItem("Acerca de");
			mntmAcercaDe.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(null, "Juego de la Liebre y la Tortuga \n EII Oviedo");
				}
			});
			mntmAcercaDe.setMnemonic('A');
		}
		return mntmAcercaDe;
	}
	
	public class AccionBoton implements ActionListener{
		
		public void actionPerformed(ActionEvent e){
			JButton btPulsado = ((JButton) e.getSource());
			jugar(Integer.parseInt(btPulsado.getActionCommand()));
		}		
	}
	
	private void creaBotonesPanel(JPanel panel){
		for (int i = 0 ; i< Calle.DIM; i++){
			panel.add(nuevoBoton(i));
		}
		
	}
	
	private JButton nuevoBoton (int posicion){
		JButton boton = new JButton("");
		boton.setBackground(Color.BLACK);
		boton.setActionCommand(String.valueOf(posicion));
		boton.addActionListener(ab);
		if(posicion == 0 )
			boton.removeActionListener(ab);
		return boton;
	}
	
	/**private void setImagenAdaptada(JButton boton, String rutaImagen){
		Image imgOriginal = new ImageIcon(getClass().getResource(rutaImagen)).getImage();
		Image imgEscalada = imgOriginal.getScaledInstance((int)(boton.getWidth()),
		 (int)(boton.getHeight()), Image.SCALE_FAST);
		boton.setIcon(new ImageIcon(imgEscalada));
		}*/
	private JMenuItem getMntmNewMenuItem() {
		if (mntmNewMenuItem == null) {
			mntmNewMenuItem = new JMenuItem("Numero Casillas");
			mntmNewMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showInputDialog(null,"Introduzca número de casillas entre 10-14");
				}
			});
		}
		return mntmNewMenuItem;
	}
}
