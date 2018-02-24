package igu;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Toolkit;

import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Font;
import java.awt.Color;
import java.awt.TextArea;

import javax.swing.JTextArea;

import java.awt.FlowLayout;
import java.util.List;

import javax.swing.JList;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.ImageIcon;

import logica.Inmobiliaria;
import logica.Mansion;

import org.jvnet.substance.SubstanceLookAndFeel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class VentanaPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Inmobiliaria inmobiliaria;
	private JPanel contentPane;
	private JTabbedPane pnPestañas;
	private JPanel panelVentas;
	private JPanel panelAlquiler;
	private JLabel lblNewLabel;
	private JPanel panelFiltro;
	private JLabel lblZonas;
	private JCheckBox chckNorte;
	private JCheckBox chckCentro;
	private JCheckBox chckSur;
	private JScrollPane scrollPaneTabla;
	private JTable tablaMansiones;
	private ModeloNoEditable modeloTabla;
	private JScrollPane scrollPaneDescripcion;
	private JTextArea textAreaDescripcion;
	private JPanel panelVisitas;
	private JScrollPane scrollPane;
	private JButton btnAñadir;
	private JButton btnEliminar;
	private JList<String> listaVisitas;
	private DefaultListModel<String> modeloLista;
	private JPanel pnPagoInicial;
	private JButton btnCalcular;
	private JSpinner spTasa;
	private JTextField textPrecio;
	private JButton btnAceptar;
	private JButton btnCancelar;
	private JLabel lblporcentaje;
	private JButton btnLlave;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrame.setDefaultLookAndFeelDecorated(true);
					JDialog.setDefaultLookAndFeelDecorated(true);
					SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.MistSilverSkin");
					VentanaPrincipal frame = new VentanaPrincipal();
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
	public VentanaPrincipal() {
		inmobiliaria = new Inmobiliaria();
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPrincipal.class.getResource("/img/llave.JPG")));
		setTitle("Agencia inmobiliaria");
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 664, 538);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getPnPestañas());
		contentPane.add(getLblNewLabel());
		contentPane.add(getScrollPaneDescripcion());
		contentPane.add(getPanelVisitas());
		contentPane.add(getPnPagoInicial());
		contentPane.add(getBtnAceptar());
		contentPane.add(getBtnCancelar());
		contentPane.add(getBtnLlave());
		habilitarBotones();
	}

	private JTabbedPane getPnPestañas() {
		if (pnPestañas == null) {
			pnPestañas = new JTabbedPane(JTabbedPane.TOP);
			pnPestañas.setBounds(10, 100, 409, 258);
			pnPestañas.addTab("Venta de mansiones", null, getPanelVentas(), null);
			pnPestañas.setMnemonicAt(0, 86);
			pnPestañas.addTab("Alquiler de mansiones", null, getPanelAlquiler(), null);
			pnPestañas.setMnemonicAt(1, 65);
		}
		return pnPestañas;
	}

	private JPanel getPanelVentas() {
		if (panelVentas == null) {
			panelVentas = new JPanel();
			panelVentas.setLayout(new BorderLayout(0, 0));
			panelVentas.add(getPanelFiltro(), BorderLayout.NORTH);
			panelVentas.add(getScrollPaneTabla(), BorderLayout.CENTER);
		}
		return panelVentas;
	}

	private JPanel getPanelAlquiler() {
		if (panelAlquiler == null) {
			panelAlquiler = new JPanel();
		}
		return panelAlquiler;
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("AGENCIA INMOBILIARIA EII");
			lblNewLabel.setForeground(Color.ORANGE);
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
			lblNewLabel.setBounds(10, 11, 431, 78);
		}
		return lblNewLabel;
	}

	private JPanel getPanelFiltro() {
		if (panelFiltro == null) {
			panelFiltro = new JPanel();
			panelFiltro.add(getLblZonas());
			panelFiltro.add(getChckNorte());
			panelFiltro.add(getChckCentro());
			panelFiltro.add(getChckSur());
		}
		return panelFiltro;
	}

	private JLabel getLblZonas() {
		if (lblZonas == null) {
			lblZonas = new JLabel("Indique la/s zona/s:");
		}
		return lblZonas;
	}

	private JCheckBox getChckNorte() {
		if (chckNorte == null) {
			chckNorte = new JCheckBox("Norte");
			chckNorte.setSelected(true);
			chckNorte.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent arg0) {
					mostrarMansionesZona();
				}
			});
		}
		return chckNorte;
	}

	private JCheckBox getChckCentro() {
		if (chckCentro == null) {
			chckCentro = new JCheckBox("Centro");
			chckCentro.setSelected(true);
			chckCentro.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent arg0) {
					mostrarMansionesZona();
				}
			});
		}
		return chckCentro;
	}

	private JCheckBox getChckSur() {
		if (chckSur == null) {
			chckSur = new JCheckBox("Sur");
			chckSur.setSelected(true);
			chckSur.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent arg0) {
					mostrarMansionesZona();
				}
			});
		}
		return chckSur;
	}

	private JScrollPane getScrollPaneTabla() {
		if (scrollPaneTabla == null) {
			scrollPaneTabla = new JScrollPane();
			scrollPaneTabla.setViewportView(getTablaMansiones());
		}
		return scrollPaneTabla;
	}

	private JTable getTablaMansiones() {
		if (tablaMansiones == null) {
			String[] columnas = { "Codigo", "Zona", "Localidad", "Precio" };
			modeloTabla = new ModeloNoEditable(columnas, 0);
			tablaMansiones = new JTable(modeloTabla);
			tablaMansiones.addMouseListener(new MouseAdapter() {

				public void mouseClicked(MouseEvent e) {
					textAreaDescripcion.setText(inmobiliaria.getDescripcionMansion(
							(String) tablaMansiones.getValueAt(tablaMansiones.getSelectedRow(), 0)));
					if (e.getClickCount() == 2) {
						añadirALista();
						habilitarBotones();
					}

				}
			});
			tablaMansiones.getTableHeader().setReorderingAllowed(false);
			añadirFilas(true, true, true);
		}
		return tablaMansiones;
	}

	private void añadirALista() {
		String codigoSeleccionado = (String) tablaMansiones.getValueAt(tablaMansiones.getSelectedRow(), 0);
		if (!(modeloLista.contains(codigoSeleccionado)))
			modeloLista.addElement(codigoSeleccionado);

	}

	private JScrollPane getScrollPaneDescripcion() {
		if (scrollPaneDescripcion == null) {
			scrollPaneDescripcion = new JScrollPane();
			scrollPaneDescripcion.setBounds(10, 369, 406, 105);
			scrollPaneDescripcion.setViewportView(getTextAreaDescripcion());
		}
		return scrollPaneDescripcion;
	}

	private JTextArea getTextAreaDescripcion() {
		if (textAreaDescripcion == null) {
			textAreaDescripcion = new JTextArea();
			textAreaDescripcion.setWrapStyleWord(true);
			textAreaDescripcion.setLineWrap(true);
		}
		return textAreaDescripcion;
	}

	private JPanel getPanelVisitas() {
		if (panelVisitas == null) {
			panelVisitas = new JPanel();
			panelVisitas.setBorder(
					new TitledBorder(null, "Mansiones a visitar", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panelVisitas.setBounds(429, 117, 204, 252);
			panelVisitas.setLayout(null);
			panelVisitas.add(getScrollPane());
			panelVisitas.add(getBtnAñadir());
			panelVisitas.add(getBtnEliminar());
		}
		return panelVisitas;
	}

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 21, 184, 190);
			scrollPane.setViewportView(getList());
		}
		return scrollPane;
	}

	private JButton getBtnAñadir() {
		if (btnAñadir == null) {
			btnAñadir = new JButton("A\u00F1adir");
			btnAñadir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					añadirALista();
					habilitarBotones();
				}
			});
			btnAñadir.setBounds(10, 217, 89, 24);
		}
		return btnAñadir;
	}

	private JButton getBtnEliminar() {
		if (btnEliminar == null) {
			btnEliminar = new JButton("Eliminar");
			btnEliminar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					eliminarDeLista();
					habilitarBotones();
				}
			});
			btnEliminar.setBounds(105, 218, 89, 23);
		}
		return btnEliminar;
	}

	private void habilitarBotones() {
		if (modeloLista.isEmpty()) {
			getBtnEliminar().setEnabled(false);
			getBtnAceptar().setEnabled(false);
			getBtnCalcular().setEnabled(false);

		}

		else {
			getBtnEliminar().setEnabled(true);
			getBtnAceptar().setEnabled(true);
			getBtnCalcular().setEnabled(true);

		}

	}

	private void eliminarDeLista() {

		List<String> listaBorrar = getList().getSelectedValuesList();
		for (int i = 0; i < listaBorrar.size(); i++) {

			modeloLista.removeElement(listaBorrar.get(i));
		}

	}

	private JList<String> getList() {
		if (listaVisitas == null) {
			modeloLista = new DefaultListModel<String>();
			listaVisitas = new JList<String>(modeloLista);

		}
		return listaVisitas;
	}

	private JPanel getPnPagoInicial() {
		if (pnPagoInicial == null) {
			pnPagoInicial = new JPanel();
			pnPagoInicial.setBorder(
					new TitledBorder(null, "Pago inicial", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			pnPagoInicial.setBounds(426, 369, 207, 90);
			pnPagoInicial.setLayout(null);
			pnPagoInicial.add(getBtnCalcular());
			pnPagoInicial.add(getSpTasa());
			pnPagoInicial.add(getTextPrecio());
			pnPagoInicial.add(getLblporcentaje());
		}
		return pnPagoInicial;
	}

	private JButton getBtnCalcular() {
		if (btnCalcular == null) {
			btnCalcular = new JButton("Calcular");
			btnCalcular.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int fila = tablaMansiones.getSelectedRow();
					if (fila != -1) {
						int porcentaje = (Integer) spTasa.getValue();
						float precio = (Float) tablaMansiones.getValueAt(fila, 3);
						float entrada = inmobiliaria.calcularEntrada(porcentaje, precio);
						getTextPrecio().setText(String.valueOf(entrada) + " €");

					}
				}
			});
			btnCalcular.setBounds(103, 23, 94, 23);
		}
		return btnCalcular;
	}

	private JSpinner getSpTasa() {
		if (spTasa == null) {
			spTasa = new JSpinner();
			spTasa.setModel(new SpinnerNumberModel(15, 5, 20, 1));
			spTasa.setBounds(10, 21, 57, 25);
		}
		return spTasa;
	}

	private JTextField getTextPrecio() {
		if (textPrecio == null) {
			textPrecio = new JTextField();
			textPrecio.setEditable(false);
			textPrecio.setBounds(10, 57, 187, 20);
			textPrecio.setColumns(10);
		}
		return textPrecio;
	}

	private JButton getBtnAceptar() {
		if (btnAceptar == null) {
			btnAceptar = new JButton("Aceptar");
			btnAceptar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					grabarVisitas();
					inicializar();
				}
			});
			btnAceptar.setBounds(429, 470, 98, 23);
		}
		return btnAceptar;
	}

	private JButton getBtnCancelar() {
		if (btnCancelar == null) {
			btnCancelar = new JButton("Cancelar");
			btnCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					inicializar();
				}
			});
			btnCancelar.setBounds(544, 470, 89, 23);
		}
		return btnCancelar;
	}

	private JLabel getLblporcentaje() {
		if (lblporcentaje == null) {
			lblporcentaje = new JLabel("%");
			lblporcentaje.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblporcentaje.setBounds(72, 21, 21, 23);
		}
		return lblporcentaje;
	}

	private JButton getBtnLlave() {
		if (btnLlave == null) {
			btnLlave = new JButton("");
			btnLlave.setFocusable(false);
			btnLlave.setBorder(null);
			btnLlave.setBackground(new Color(240, 240, 240));
			btnLlave.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/llave.JPG")));
			btnLlave.setBounds(496, 23, 89, 78);
		}
		return btnLlave;
	}

	private void añadirFilas(boolean norte, boolean centro, boolean sur) {
		Object[] nuevaFila = new Object[4];
		List<Mansion> relacionMansiones = inmobiliaria.getRelacionMansiones();
		for (Mansion m : relacionMansiones) {
			String zonaM = m.getZona();
			if (norte && zonaM.equals("Norte") || centro && zonaM.equals("Centro") || sur && zonaM.equals("Sur")) {
				nuevaFila[0] = m.getCodigo();
				nuevaFila[1] = m.getZona();
				nuevaFila[2] = m.getLocalidad();
				nuevaFila[3] = m.getPrecio();
				modeloTabla.addRow(nuevaFila);
			}
		}

	}

	private void mostrarMansionesZona() {
		modeloTabla.getDataVector().clear();
		añadirFilas(getChckNorte().isSelected(), getChckCentro().isSelected(), getChckSur().isSelected());
		modeloTabla.fireTableDataChanged();
	}

	private void inicializar() {
		pnPestañas.setSelectedIndex(0);
		chckCentro.setSelected(true);
		chckSur.setSelected(true);
		chckNorte.setSelected(true);
		tablaMansiones.clearSelection();
		textAreaDescripcion.setText("");
		modeloLista.clear();
		spTasa.setValue(15);
		textPrecio.setText("");
		habilitarBotones();

	}

	private void grabarVisitas() {
		String linea = "";
		Object[] codigos = modeloLista.toArray();
		for (int i = 0; i < codigos.length; i++) {
			linea = linea + codigos[i] + "";
		}

		if (inmobiliaria.grabarFichero(linea) == 0)
			JOptionPane.showMessageDialog(this, "Su petición de visita ha sido almacenada con éxito");
	}
}
