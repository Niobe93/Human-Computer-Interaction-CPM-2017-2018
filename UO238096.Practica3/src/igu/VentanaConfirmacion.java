package igu;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import logica.Pedido;

public class VentanaConfirmacion extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblOk;
	private JTextField textField;
	private JLabel lblSuCdigo;
	private JButton btnFinalizar;
	private Pedido pedido;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaConfirmacion frame = new VentanaConfirmacion();
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
	public VentanaConfirmacion() {
		setTitle("Venta de accesorios: Confirmaci\u00F3n pedido");
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaConfirmacion.class.getResource("/img/logo.jpg")));
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 431, 248);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblOk());
		contentPane.add(getTextField());
		contentPane.add(getLblSuCdigo());
		contentPane.add(getBtnFinalizar());
	}

	private JLabel getLblOk() {
		if (lblOk == null) {
			lblOk = new JLabel("Estamos procesando su pedido");
			lblOk.setFont(new Font("Tahoma", Font.BOLD, 16));
			lblOk.setIcon(new ImageIcon(VentanaConfirmacion.class.getResource("/img/ok.png")));
			lblOk.setBounds(23, 24, 364, 104);
		}
		return lblOk;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setFont(new Font("Tahoma", Font.BOLD, 11));
			textField.setText(generarCodigo());
			textField.setEditable(false);
			textField.setBounds(247, 126, 128, 20);
			textField.setColumns(10);
		}
		return textField;
	}
	private JLabel getLblSuCdigo() {
		if (lblSuCdigo == null) {
			lblSuCdigo = new JLabel("El c\u00F3digo de recogida es:");
			lblSuCdigo.setBounds(100, 111, 200, 50);
		}
		return lblSuCdigo;
	}
	private JButton getBtnFinalizar() {
		if (btnFinalizar == null) {
			btnFinalizar = new JButton("Finalizar");
			btnFinalizar.setMnemonic('F');
			btnFinalizar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					pedido.grabarPedido(getTextField());
				}
			});
			btnFinalizar.setBounds(286, 172, 89, 23);
		}
		return btnFinalizar;
	}
	
	private String generarCodigo(){
		
		String codigo ="";
		String base= "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		int longitudCodigo = 10;
		for ( int i=0; i<longitudCodigo;i++){
			int numero = (int)(Math.random()*(base.length()));
			codigo += base.charAt(numero);
		}
		return codigo;
		
		
	}
}
 