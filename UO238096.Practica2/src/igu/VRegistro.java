package igu;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;


import java.awt.Color;

import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;

public class VRegistro extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel pnlPrincipal; // panel principal

	private JButton btnCancelar; // boton cancelar
	private JButton btnSiguiente; // boton siguiente

	private JRadioButton rdbtnHombre; // boton hombre
	private JRadioButton rdbtnMujer; // boton mujer
	private final ButtonGroup grSexo = new ButtonGroup();

	private JLabel lblNombre; // nombre
	private JLabel lblApellidos; // apellidos
	private JLabel lblUsuarioemail; // usuario
	private JLabel lblPassword; // password
	private JLabel lblReintroduzcaPassword; // repetir password

	private JPanel JPanel; // sexo
	private JPanel JPanel_1; // fecha de nacimiento
	private JPanel JPanel_2; // datos del registro

	private JTextField textField; // nombre texto
	private JTextField textField_1; // apellidos texto
	private JTextField textField_2; // usuario texto

	private JPasswordField passwordField; // password texto
	private JPasswordField passwordField_1; // password repetir texto

	private JComboBox<String> comboBox; // fecha año
	private JComboBox<String> comboBox_1; // fecha mes
	private JComboBox<String> comboBox_2; // fecha dia

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VRegistro frame = new VRegistro();
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
	public VRegistro() {
		setTitle("Formulario de registro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 575, 328);

		pnlPrincipal = new JPanel();
		pnlPrincipal.setBackground(SystemColor.text);
		pnlPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pnlPrincipal);

		pnlPrincipal.setLayout(null);

		pnlPrincipal.add(getLblNombre());
		pnlPrincipal.add(getLblApellidos());

		pnlPrincipal.add(getJPanel());
		pnlPrincipal.add(getJPanel_1());
		pnlPrincipal.add(getJPanel_2());

		pnlPrincipal.add(getTextField());
		pnlPrincipal.add(getTextField_1());

		pnlPrincipal.add(getBtnCancelar());
		pnlPrincipal.add(getBtnSiguiente());

	}

	private JLabel getLblNombre() {
		if (lblNombre == null) {
			lblNombre = new JLabel("Nombre:");
			lblNombre.setBounds(22, 33, 77, 14);
		}
		return lblNombre;
	}

	private JLabel getLblApellidos() {
		if (lblApellidos == null) {
			lblApellidos = new JLabel("Apellidos:");
			lblApellidos.setBounds(258, 33, 77, 14);
		}
		return lblApellidos;
	}

	private JPanel getJPanel() {
		if (JPanel == null) {
			JPanel = new JPanel();
			JPanel.setBorder(new TitledBorder(null, "Sexo",
					TitledBorder.LEADING, TitledBorder.TOP, null, null));
			JPanel.setBackground(Color.WHITE);
			JPanel.setBounds(22, 71, 207, 65);
			JPanel.add(getRdbtnHombre());
			JPanel.add(getRdbtnMujer());
		}
		return JPanel;
	}

	private JPanel getJPanel_1() {
		if (JPanel_1 == null) {
			JPanel_1 = new JPanel();
			JPanel_1.setBorder(new TitledBorder(null,
					"Fecha de nacimiento", TitledBorder.LEADING,
					TitledBorder.TOP, null, null));
			JPanel_1.setBackground(Color.WHITE);
			JPanel_1.setBounds(258, 71, 291, 65);
			JPanel_1.setLayout(null);
			JPanel_1.add(getComboBox_1());
			JPanel_1.add(getComboBox_2());
			JPanel_1.add(getComboBox());
		}
		return JPanel_1;
	}

	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setBounds(80, 30, 149, 20);
			textField.setColumns(10);
		}
		return textField;
	}

	private JTextField getTextField_1() {
		if (textField_1 == null) {
			textField_1 = new JTextField();
			textField_1.setBounds(324, 30, 225, 20);
			textField_1.setColumns(10);
		}
		return textField_1;
	}

	private JPanel getJPanel_2() {
		if (JPanel_2 == null) {
			JPanel_2 = new JPanel();
			JPanel_2.setBorder(new TitledBorder(null, "Datos de registro",
					TitledBorder.LEADING, TitledBorder.TOP, null, null));
			JPanel_2.setBackground(Color.WHITE);
			JPanel_2.setBounds(22, 140, 314, 123);
			JPanel_2.setLayout(null);
			JPanel_2.add(getLblUsuarioemail());
			JPanel_2.add(getLblPassword());
			JPanel_2.add(getLblReintroduzcaPassword());
			JPanel_2.add(getTextField_2());
			JPanel_2.add(getPasswordField());
			JPanel_2.add(getPasswordField_1());
		}
		return JPanel_2;
	}

	private JLabel getLblUsuarioemail() {
		if (lblUsuarioemail == null) {
			lblUsuarioemail = new JLabel("Usuario (email):");
			lblUsuarioemail.setBounds(10, 30, 119, 14);
		}
		return lblUsuarioemail;
	}

	private JLabel getLblPassword() {
		if (lblPassword == null) {
			lblPassword = new JLabel("Password:");
			lblPassword.setBounds(10, 61, 119, 14);
		}
		return lblPassword;
	}

	private JLabel getLblReintroduzcaPassword() {
		if (lblReintroduzcaPassword == null) {
			lblReintroduzcaPassword = new JLabel("Reintroduzca password: ");
			lblReintroduzcaPassword.setBounds(10, 95, 149, 14);
		}
		return lblReintroduzcaPassword;
	}

	private JTextField getTextField_2() {
		if (textField_2 == null) {
			textField_2 = new JTextField();
			textField_2.setBounds(157, 27, 135, 20);
			textField_2.setColumns(10);
		}
		return textField_2;
	}

	private JPasswordField getPasswordField() {
		if (passwordField == null) {
			passwordField = new JPasswordField();
			passwordField.setBounds(157, 58, 135, 20);
		}
		return passwordField;
	}

	private JPasswordField getPasswordField_1() {
		if (passwordField_1 == null) {
			passwordField_1 = new JPasswordField();
			passwordField_1.setBounds(157, 92, 135, 20);
		}
		return passwordField_1;
	}

	private JComboBox<String> getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox<String>();
			comboBox.setBounds(204, 21, 77, 20);
			String[] years = new String[97];
			for (int i = 0; i < 97; i++) {
				years[i] = "" + (i + 1920);
				comboBox.addItem(years[i]);
			}
		}
		return comboBox;
	}

	private JComboBox<String> getComboBox_1() {
		if (comboBox_1 == null) {
			comboBox_1 = new JComboBox<String>();
			comboBox_1.setModel(new DefaultComboBoxModel<String>(new String[] {
					"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
					"Julio", "Agosto", "Septiembre", "Octubre", "Noviembre",
					"Diciembre" }));
			comboBox_1.setBounds(97, 21, 97, 20);
		}
		return comboBox_1;
	}

	private JComboBox<String> getComboBox_2() {
		if (comboBox_2 == null) {
			comboBox_2 = new JComboBox<String>();
			String[] days = new String[32];

			for (int i = 1; i < 32; i++) {
				days[i] = "" + (i);
				comboBox_2.addItem(days[i]);
			}

			comboBox_2.setBounds(22, 21, 54, 20);
		}
		return comboBox_2;
	}

	private JRadioButton getRdbtnHombre() {
		if (rdbtnHombre == null) {
			rdbtnHombre = new JRadioButton("Hombre");
			grSexo.add(rdbtnHombre);
			rdbtnHombre.setSelected(true);
			rdbtnHombre.setBackground(Color.WHITE);
			rdbtnHombre.setBounds(18, 23, 82, 23);
		}
		return rdbtnHombre;
	}

	private JRadioButton getRdbtnMujer() {
		if (rdbtnMujer == null) {
			rdbtnMujer = new JRadioButton("Mujer");
			rdbtnMujer.setSelected(true);
			grSexo.add(rdbtnMujer);
			rdbtnMujer.setBackground(Color.WHITE);
			rdbtnMujer.setBounds(125, 23, 63, 23);
		}
		return rdbtnMujer;
	}

	private JButton getBtnCancelar() {
		if (btnCancelar == null) {
			btnCancelar = new JButton("Cancelar");
			btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 12));
			btnCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					System.exit(0);
				}
			});
			btnCancelar.setBounds(452, 240, 97, 23);
		}
		return btnCancelar;
	}

	private JButton getBtnSiguiente() {
		if (btnSiguiente == null) {
			btnSiguiente = new JButton("Siguiente");
			btnSiguiente.setFont(new Font("Tahoma", Font.PLAIN, 12));
			btnSiguiente.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (checkStringValues() == false)
						JOptionPane.showMessageDialog(null,
								"Por favor, rellene todos los campos");
					else if (checkPasswordValues() == false)
						JOptionPane.showMessageDialog(null,
								"Las passwords no coinciden");
					else
						System.exit(0);
				}
			});
			btnSiguiente.setBounds(346, 240, 96, 23);
		}
		return btnSiguiente;
	}

	private boolean checkStringValues() {
		if ((textField.getText().trim().isEmpty())|| (textField_1.getText().trim().isEmpty())|| (textField_2.getText().trim().isEmpty())
				|| (String.valueOf(passwordField.getPassword()).trim().isEmpty())|| (String.valueOf(passwordField_1.getPassword()).trim().isEmpty()))
			return false;
		return true;

	}

	private boolean checkPasswordValues() {
		String pw1 = String.valueOf(passwordField.getPassword());
		String pw2 = String.valueOf(passwordField_1.getPassword());
		if (pw1.contains(pw2))
			return true;
		return false;

	}

}
