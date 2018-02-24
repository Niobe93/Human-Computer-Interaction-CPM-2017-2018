package igu;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logica.Articulo;
import logica.Catalogo;
import logica.Pedido;

import java.awt.Color;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class VentanaPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnComprar;
	private JTextField textField;
	private JLabel lblPcAccesorios;
	private JComboBox<Articulo> comboBox;
	private JTextField textField_1;
	private JLabel lblNewLabel;
	private JLabel lblArtculos;
	private JLabel lblUnidades;
	private JLabel lblPrecioPedido;
	private JButton btnSiguiente;
	private JButton btnCancelar;
	private Catalogo catalogo;
	private Pedido pedido;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		final Catalogo catalogo = new Catalogo();
		final Pedido pedido = new Pedido();
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal(catalogo, pedido);
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
	public VentanaPrincipal(Catalogo catalogo, Pedido pedido) {
		
		this.catalogo = catalogo;
		this .pedido=pedido;
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPrincipal.class.getResource("/img/logo.jpg")));
		setResizable(false);
		setTitle("Venta de Accesorios de Ordenador");
		setForeground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 572, 390);
		contentPane = new JPanel();		
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getBtnComprar());
		contentPane.add(getTextField());
		contentPane.add(getLblPcAccesorios());
		contentPane.add(getComboBox());
		contentPane.add(getTextField_1());
		contentPane.add(getLblNewLabel());
		contentPane.add(getLblArtculos());
		contentPane.add(getLblUnidades());
		contentPane.add(getLblPrecioPedido());
		contentPane.add(getBtnSiguiente());
		contentPane.add(getBtnCancelar());
		
		
	}
	private JButton getBtnComprar() {
		if (btnComprar == null) {
			btnComprar = new JButton("Comprar");
			btnComprar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					añadirACarrito();
				}
			});
			btnComprar.setToolTipText("A\u00F1ade al carrito las unidades seleccionadas.");
			btnComprar.setMnemonic('P');
			btnComprar.setBounds(454, 206, 90, 25);
		}
		return btnComprar;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent arg0) {
					textField.setText("1");
					textField.selectAll();
				}
				@Override
				public void focusLost(FocusEvent e) {
					comprobarUnidades();
				}
				
			});
			textField.setBounds(355, 207, 55, 23);
			textField.setColumns(10);
		}
		return textField;
	}
	private JLabel getLblPcAccesorios() {
		if (lblPcAccesorios == null) {
			lblPcAccesorios = new JLabel("PC ACCESORIOS");
			lblPcAccesorios.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 17));
			lblPcAccesorios.setForeground(new Color(128, 0, 0));
			lblPcAccesorios.setBounds(248, 53, 200, 50);
		}
		return lblPcAccesorios;
	}
	private JComboBox<Articulo> getComboBox() {		
		if (comboBox == null) {
			comboBox = new JComboBox<Articulo>();
			comboBox.setModel(new DefaultComboBoxModel<Articulo>(catalogo.getArticulos()));			
			comboBox.setBounds(23, 205, 241, 26);
		}
		return comboBox;
	}
	private JTextField getTextField_1() {
		if (textField_1 == null) {
			textField_1 = new JTextField();
			textField_1.setEditable(false);
			textField_1.setBounds(355, 265, 76, 23);
			textField_1.setColumns(10);
		}
		return textField_1;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/logo.jpg")));
			lblNewLabel.setBounds(38, 27, 200, 128);
		}
		return lblNewLabel;
	}
	private JLabel getLblArtculos() {
		if (lblArtculos == null) {
			lblArtculos = new JLabel("Art\u00EDculos:");
			lblArtculos.setLabelFor(getComboBox());
			lblArtculos.setDisplayedMnemonic('A');
			lblArtculos.setBounds(32, 168, 118, 44);
		}
		return lblArtculos;
	}
	private JLabel getLblUnidades() {
		if (lblUnidades == null) {
			lblUnidades = new JLabel("Unidades:");
			lblUnidades.setLabelFor(getTextField());
			lblUnidades.setDisplayedMnemonic('U');
			lblUnidades.setBounds(355, 168, 76, 44);
		}
		return lblUnidades;
	}
	private JLabel getLblPrecioPedido() {
		if (lblPrecioPedido == null) {
			lblPrecioPedido = new JLabel("Precio Pedido:");
			lblPrecioPedido.setBounds(355, 232, 107, 44);
		}
		return lblPrecioPedido;
	}
	private JButton getBtnSiguiente() {
		if (btnSiguiente == null) {
			btnSiguiente = new JButton("Siguiente");
			btnSiguiente.setMnemonic('S');
			btnSiguiente.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarVentanaRegistro();
				}				
			});
			btnSiguiente.setBounds(355, 328, 89, 23);
		}
		return btnSiguiente;
	}
	private JButton getBtnCancelar() {
		if (btnCancelar == null) {
			btnCancelar = new JButton("Cancelar");
			btnCancelar.setMnemonic('C');
			btnCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
			btnCancelar.setBounds(454, 328, 89, 23);
		}
		return btnCancelar;
	}
	
	private void mostrarVentanaRegistro() {
		VentanaRegistro vRegistro = new VentanaRegistro();
		vRegistro.setLocationRelativeTo(this);
		vRegistro.setModal(true);
		vRegistro.setVisible(true);
		
	}
	
	private void comprobarUnidades() {
		boolean error = false;
		int unidades=0;
		try{
			unidades = Integer.parseInt(textField.getText());
		}
		catch (NumberFormatException e1){
			error = true;
		}
		if (error || (unidades <=0))
			textField.setText("");
		
	}
	
	private void añadirACarrito(){
		if(!textField.getText().isEmpty()){
			Articulo articuloSeleccionado = (Articulo)comboBox.getSelectedItem();
			int unidadesSolicitadas = Integer.parseInt(textField.getText());
			pedido.add(articuloSeleccionado,unidadesSolicitadas);
			float precioPedido = pedido.calcularTotalSinIva();
			textField_1.setText(String.valueOf(precioPedido)+ " \u20AC");
			if(!btnSiguiente.isEnabled())
				btnSiguiente.setEnabled(true);
		}
		else 
			textField.grabFocus();
		
		
		
	}
	
	
	
	
}
