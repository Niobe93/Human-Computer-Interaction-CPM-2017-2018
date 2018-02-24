package igu;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Toolkit;
import java.awt.GridLayout;
import java.awt.Color;
import javax.help.*;
import java.net.*;
import java.io.*;

import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JSlider;
import javax.swing.JTextField;

import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.Font;

import javax.swing.JLabel;

import java.awt.FlowLayout;

import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.border.LineBorder;

import player.MusicPlayer;
import player.MyFile;

import java.awt.Insets;
import java.awt.Dimension;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Properties;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;

import com.jtattoo.plaf.hifi.HiFiLookAndFeel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;

public class VentanaPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MusicPlayer mP;
	private JFileChooser selector;
	private Font fuenteDigital;
	private DefaultListModel<MyFile>  modeloListLibrary;
	private DefaultListModel<MyFile> modeloListPlay;
	private JPanel contentPane;
	private JPanel panel;
	private JPanel panel_Norte;
	private JButton buttonTitulo;
	private JSlider slider;
	private JPanel panel_Volumen;
	private JTextField textVolumenSelect;
	private JLabel lblVol;
	private JPanel panel_Centro;
	private JPanel panel_Lib;
	private JPanel panel_PlayList;
	private JLabel lblLibrary;
	private JPanel panel_Botones_Libreria;
	private JButton btnAddToPlaylist;
	private JButton btnDelete;
	private JScrollPane scrollPane;
	private JList<MyFile>list_Library;
	private JLabel lblPlaylist;
	private JScrollPane scrollPane_PlayList;
	private JList<MyFile> list_PlayList;
	private JPanel panel_BotonesPlayList;
	private JButton button_rebobinar;
	private JButton button_play;
	private JButton button_stop;
	private JButton button_avanzar;
	private JButton button_Del;
	private JMenuBar menuBar;
	private JMenu mnFile;
	private JMenuItem mntmOpen;
	private JSeparator separator;
	private JMenuItem mntmExit;
	private JButton btnClearAll;
	private JMenu mnAyuda;
	private JMenuItem mntmAyuda;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Properties p = new Properties();
					p.put("logoString", "");
					HiFiLookAndFeel.setCurrentTheme(p);
					UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
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
		cargarFuente();
		mP=new MusicPlayer();
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPrincipal.class.getResource("/img/logoTitulo.png")));
		setSize(622,500);
		setLocationRelativeTo(null);
		setTitle("EII Music Player");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		setJMenuBar(getMenuBar_1());
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getPanel(), BorderLayout.CENTER);
		cargaAyuda();
	}

	public JFileChooser getSelector() {
		if(selector == null){
			selector = new JFileChooser();
			selector.setMultiSelectionEnabled(true);
			selector.setFileFilter(new FileNameExtensionFilter("Archivos mp3", "mp3"));			
			String escritorio = System.getProperty("user.home") + "/desktop/things/musica";
			selector.setCurrentDirectory(new File(escritorio));
		}
		return selector;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBackground(Color.BLACK);
			panel.setLayout(new BorderLayout(0, 0));
			panel.add(getPanel_Norte(), BorderLayout.NORTH);
			panel.add(getPanel_Centro(), BorderLayout.CENTER);
		}
		return panel;
	}
	private JPanel getPanel_Norte() {
		if (panel_Norte == null) {
			panel_Norte = new JPanel();
			panel_Norte.setBackground(Color.BLACK);
			panel_Norte.setLayout(new GridLayout(1, 0, 5, 0));
			panel_Norte.add(getButtonTitulo());
			panel_Norte.add(getSlider());
			panel_Norte.add(getPanel_Volumen());
		}
		return panel_Norte;
	}
	private JButton getButtonTitulo() {
		if (buttonTitulo == null) {
			buttonTitulo = new JButton("");
			buttonTitulo.setHorizontalAlignment(SwingConstants.LEFT);
			buttonTitulo.setContentAreaFilled(false);
			buttonTitulo.setFocusable(false);
			buttonTitulo.setBackground(Color.BLACK);
			buttonTitulo.setBorder(null);
			buttonTitulo.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/logo.png")));
		}
		return buttonTitulo;
	}
	private JSlider getSlider() {
		if (slider == null) {
			slider = new JSlider();
			slider.setFocusable(false);
			slider.addChangeListener(new ChangeListener() {			
				public void stateChanged(ChangeEvent arg0) {
					getTextVolumenSelect().setText(String.valueOf(getSlider().getValue()));
					cambiarVol(getSlider().getValue());
				}
			});
			slider.setPaintTicks(true);
			slider.setPaintLabels(true);
			slider.setFont(new Font("Dialog", Font.BOLD, 14));
			slider.setForeground(Color.WHITE);
			slider.setMajorTickSpacing(20);
			slider.setMinorTickSpacing(10);
			slider.setBackground(Color.BLACK);
		}
		return slider;
	}
	
	private void cambiarVol (double vol){
		mP.setVolume(vol, getSlider().getMaximum());
		
	}
	
	private void cargarFuente(){
		
		try{
			InputStream myStream = getClass().getResourceAsStream("/ttf/DS-DIGIB.ttf");
			fuenteDigital = Font.createFont(Font.TRUETYPE_FONT, myStream);
		} catch (Exception ex){
			System.err.println("No se puede cargar la fuente");
		}
	}
	private JPanel getPanel_Volumen() {
		if (panel_Volumen == null) {
			panel_Volumen = new JPanel();
			panel_Volumen.setBackground(Color.BLACK);
			panel_Volumen.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			panel_Volumen.add(getLblVol());
			panel_Volumen.add(getTextVolumenSelect());
		}
		return panel_Volumen;
	}
	private JTextField getTextVolumenSelect() {
		if (textVolumenSelect == null) {
			textVolumenSelect = new JTextField();
			textVolumenSelect.setFocusable(false);
			textVolumenSelect.setBorder(null);
			textVolumenSelect.setText("50");
			textVolumenSelect.setFont(fuenteDigital.deriveFont(Font.PLAIN, 50));
			textVolumenSelect.setHorizontalAlignment(SwingConstants.CENTER);
			textVolumenSelect.setBackground(Color.BLACK);
			textVolumenSelect.setForeground(Color.WHITE);
			textVolumenSelect.setEditable(false);
			textVolumenSelect.setColumns(3);
		}
		return textVolumenSelect;
	}
	private JLabel getLblVol() {
		if (lblVol == null) {
			lblVol = new JLabel("Vol:");
			lblVol.setFocusable(false);
			lblVol.setForeground(Color.GREEN);
			lblVol.setFont(fuenteDigital.deriveFont(Font.PLAIN, 40));
		}
		return lblVol;
	}
	private JPanel getPanel_Centro() {
		if (panel_Centro == null) {
			panel_Centro = new JPanel();
			panel_Centro.setBorder(null);
			panel_Centro.setBackground(Color.BLACK);
			panel_Centro.setLayout(new GridLayout(1, 0, 5, 0));
			panel_Centro.add(getPanel_Lib());
			panel_Centro.add(getPanel_PlayList());
		}
		return panel_Centro;
	}
	private JPanel getPanel_Lib() {
		if (panel_Lib == null) {
			panel_Lib = new JPanel();
			panel_Lib.setBackground(Color.BLACK);
			panel_Lib.setLayout(new BorderLayout(0, 0));
			panel_Lib.add(getLblLibrary(), BorderLayout.NORTH);
			panel_Lib.add(getScrollPane(), BorderLayout.CENTER);
			panel_Lib.add(getPanel_Botones_Libreria(), BorderLayout.SOUTH);
		}
		return panel_Lib;
	}
	private JPanel getPanel_PlayList() {
		if (panel_PlayList == null) {
			panel_PlayList = new JPanel();
			panel_PlayList.setBorder(null);
			panel_PlayList.setBackground(Color.BLACK);
			panel_PlayList.setLayout(new BorderLayout(0, 0));
			panel_PlayList.add(getLblPlaylist(), BorderLayout.NORTH);
			panel_PlayList.add(getScrollPane_PlayList(), BorderLayout.CENTER);
			panel_PlayList.add(getPanel_BotonesPlayList(), BorderLayout.SOUTH);
		}
		return panel_PlayList;
	}
	private JLabel getLblLibrary() {
		if (lblLibrary == null) {
			lblLibrary = new JLabel("Library:");
			lblLibrary.setBorder(null);
			lblLibrary.setForeground(Color.GREEN);
			lblLibrary.setFont(new Font("Arial", Font.BOLD, 17));
			lblLibrary.setText("\u266A Library: ");
		}
		return lblLibrary;
	}
	private JPanel getPanel_Botones_Libreria() {
		if (panel_Botones_Libreria == null) {
			panel_Botones_Libreria = new JPanel();
			panel_Botones_Libreria.setBorder(null);
			panel_Botones_Libreria.setBackground(Color.BLACK);
			panel_Botones_Libreria.setLayout(new GridLayout(1, 0, 5, 0));
			panel_Botones_Libreria.add(getBtnAddToPlaylist());
			panel_Botones_Libreria.add(getBtnDelete());
		}
		return panel_Botones_Libreria;
	}
	private JButton getBtnAddToPlaylist() {
		if (btnAddToPlaylist == null) {
			btnAddToPlaylist = new JButton("Add to PlayList");
			btnAddToPlaylist.setFocusable(false);
			btnAddToPlaylist.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					pasarAPlayList();
				}
			});
			btnAddToPlaylist.setPreferredSize(new Dimension(63, 23));
			btnAddToPlaylist.setMinimumSize(new Dimension(63, 23));
			btnAddToPlaylist.setMaximumSize(new Dimension(63, 23));
			btnAddToPlaylist.setMargin(new Insets(0, 0, 0, 0));
			btnAddToPlaylist.setFont(new Font("Dialog", Font.BOLD, 12));
			btnAddToPlaylist.setForeground(Color.WHITE);
			btnAddToPlaylist.setBorderPainted(false);
			btnAddToPlaylist.setBackground(Color.DARK_GRAY);
		}
		return btnAddToPlaylist;
	}
	
	private void pasarAPlayList(){
		for (int i=0; i<getList_Library().getSelectedValuesList().size(); i++)
			modeloListPlay.addElement(getList_Library().getSelectedValuesList().get(i));
		
		
	}
	private JButton getBtnDelete() {
		if (btnDelete == null) {
			btnDelete = new JButton("Delete");
			btnDelete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					deleteLibrarySeleccion();
				}
			});
			btnDelete.setFocusable(false);
			btnDelete.setMargin(new Insets(0, 0, 0, 0));
			btnDelete.setFont(new Font("Dialog", Font.BOLD, 12));
			btnDelete.setBorder(null);
			btnDelete.setForeground(Color.WHITE);
			btnDelete.setBackground(Color.DARK_GRAY);
		}
		return btnDelete;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setViewportBorder(new LineBorder(Color.GREEN, 3));
			scrollPane.setViewportView(getList_Library());
		}
		return scrollPane;
	}
	private JList <MyFile>getList_Library() {
		if (list_Library == null) {
			modeloListLibrary= new DefaultListModel<MyFile>();
			list_Library = new JList<MyFile>(modeloListLibrary);
			list_Library.setFocusable(false);
			list_Library.setBorder(null);
			list_Library.setForeground(Color.WHITE);
			list_Library.setBackground(Color.BLACK);
		}
		return list_Library;
	}
	private JLabel getLblPlaylist() {
		if (lblPlaylist == null) {
			lblPlaylist = new JLabel("\u266A PlayList: ");
			lblPlaylist.setForeground(Color.GREEN);
			lblPlaylist.setFont(new Font("Arial", Font.BOLD, 17));
		}
		return lblPlaylist;
	}
	private JScrollPane getScrollPane_PlayList() {
		if (scrollPane_PlayList == null) {
			scrollPane_PlayList = new JScrollPane();
			scrollPane_PlayList.setViewportBorder(new LineBorder(Color.GREEN, 3));
			scrollPane_PlayList.setViewportView(getList_PlayList());
		}
		return scrollPane_PlayList;
	}
	private JList<MyFile> getList_PlayList() {
		if (list_PlayList == null) {
			modeloListPlay= new DefaultListModel<MyFile>();
			list_PlayList = new JList<MyFile>(modeloListPlay);
			list_PlayList.setBorder(null);
			list_PlayList.setForeground(Color.WHITE);
			list_PlayList.setBackground(Color.BLACK);
		}
		return list_PlayList;
	}
	private JPanel getPanel_BotonesPlayList() {
		if (panel_BotonesPlayList == null) {
			panel_BotonesPlayList = new JPanel();
			panel_BotonesPlayList.setBorder(null);
			panel_BotonesPlayList.setBackground(Color.BLACK);
			panel_BotonesPlayList.setLayout(new GridLayout(1, 0, 5, 0));
			panel_BotonesPlayList.add(getBtnClearAll());
			panel_BotonesPlayList.add(getButton_rebobinar());
			panel_BotonesPlayList.add(getButton_play());
			panel_BotonesPlayList.add(getButton_stop());
			panel_BotonesPlayList.add(getButton_avanzar());
			panel_BotonesPlayList.add(getButton_Del());
		}
		return panel_BotonesPlayList;
	}
	private JButton getButton_rebobinar() {
		if (button_rebobinar == null) {
			button_rebobinar = new JButton("");
			button_rebobinar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					rewind();
				}
			});
			button_rebobinar.setFocusable(false);
			button_rebobinar.setPreferredSize(new Dimension(63, 23));
			button_rebobinar.setMinimumSize(new Dimension(63, 23));
			button_rebobinar.setMaximumSize(new Dimension(63, 23));
			button_rebobinar.setFont(new Font("Dialog", Font.BOLD, 12));
			button_rebobinar.setMargin(new Insets(0, 0, 0, 0));
			button_rebobinar.setBorder(null);
			button_rebobinar.setForeground(Color.WHITE);
			button_rebobinar.setBorderPainted(false);
			button_rebobinar.setBackground(Color.DARK_GRAY);
			button_rebobinar.setText("\u25C4" + "\u25C4 ");
		}
		return button_rebobinar;
	}
	private JButton getButton_play() {
		if (button_play == null) {
			button_play = new JButton("");
			button_play.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					playMusic();
				}		
			});
			button_play.setFocusable(false);
			button_play.setPreferredSize(new Dimension(63, 23));
			button_play.setMinimumSize(new Dimension(63, 23));
			button_play.setMaximumSize(new Dimension(63, 23));
			button_play.setFont(new Font("Dialog", Font.BOLD, 12));
			button_play.setMargin(new Insets(0, 0, 0, 0));
			button_play.setBorderPainted(false);
			button_play.setForeground(Color.WHITE);
			button_play.setBorder(null);
			button_play.setBackground(Color.DARK_GRAY);
			button_play.setText("\u25BA ");
		}
		return button_play;
	}
	
	private void playMusic() {
		if(getList_PlayList().getSelectedIndex()==-1){
			getList_PlayList().setSelectedIndex(0);}
		mP.play(getList_PlayList().getSelectedValue());
		mP.setVolume(mP.getVolumen(), mP.getVolMax());
		
		
	}
	
	private void forward(){
		int indiceSeleccionado = getList_PlayList().getSelectedIndex();
		int tamaño = modeloListPlay.getSize();
		if(indiceSeleccionado!= tamaño-1 ){
			getList_PlayList().setSelectedIndex(getList_PlayList().getSelectedIndex()+1);
			mP.play(getList_PlayList().getSelectedValue());
			mP.setVolume(mP.getVolumen(), mP.getVolMax());
		}
		else {
			getList_PlayList().setSelectedIndex(0);
			mP.play(getList_PlayList().getSelectedValue());
			mP.setVolume(mP.getVolumen(), mP.getVolMax());
		}
		
		
	}
	private void rewind(){
		int indiceSeleccionado = getList_PlayList().getSelectedIndex();
		
		if(indiceSeleccionado!= 0 ){
			getList_PlayList().setSelectedIndex(getList_PlayList().getSelectedIndex()-1);
			mP.play(getList_PlayList().getSelectedValue());
			mP.setVolume(mP.getVolumen(), mP.getVolMax());
		}
		else {
			getList_PlayList().setSelectedIndex(modeloListPlay.getSize()-1);
			mP.play(getList_PlayList().getSelectedValue());
			mP.setVolume(mP.getVolumen(), mP.getVolMax());
		}
		
		
	}
	
	private void deletePlaySeleccion(){
		List<MyFile> cancionesBorrar = getList_PlayList().getSelectedValuesList();
		for (int i=0; i<cancionesBorrar.size(); i++){
			if(cancionesBorrar.contains(mP.getCancionSonando())){
			  mP.stop();
		      modeloListPlay.removeElement(cancionesBorrar.get(i));}
			else{
				modeloListPlay.removeElement(cancionesBorrar.get(i));}
	}}
	
	private void deleteLibrarySeleccion(){
		List<MyFile> cancionesBorrar = getList_Library().getSelectedValuesList();
		for (int i=0; i<cancionesBorrar.size(); i++){
			if(cancionesBorrar.contains(mP.getCancionSonando())){
			  mP.stop();
		      modeloListLibrary.removeElement(cancionesBorrar.get(i));}
			else{
				modeloListLibrary.removeElement(cancionesBorrar.get(i));}
	}}
	
	private JButton getButton_stop() {
		if (button_stop == null) {
			button_stop = new JButton("");
			button_stop.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mP.stop();
				}
			});
			button_stop.setFocusable(false);
			button_stop.setForeground(Color.WHITE);
			button_stop.setPreferredSize(new Dimension(63, 23));
			button_stop.setMinimumSize(new Dimension(63, 23));
			button_stop.setMaximumSize(new Dimension(63, 23));
			button_stop.setFont(new Font("Dialog", Font.BOLD, 12));
			button_stop.setMargin(new Insets(0, 0, 0, 0));
			button_stop.setBorderPainted(false);
			button_stop.setBorder(null);
			button_stop.setText("\u25A0");
		}
		return button_stop;
	}
	private JButton getButton_avanzar() {
		if (button_avanzar == null) {
			button_avanzar = new JButton("");
			button_avanzar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					forward();
					playMusic();
				}
			});
			button_avanzar.setFocusable(false);
			button_avanzar.setForeground(Color.WHITE);
			button_avanzar.setPreferredSize(new Dimension(63, 23));
			button_avanzar.setMinimumSize(new Dimension(63, 23));
			button_avanzar.setMaximumSize(new Dimension(63, 23));
			button_avanzar.setFont(new Font("Dialog", Font.BOLD, 12));
			button_avanzar.setMargin(new Insets(0, 0, 0, 0));
			button_avanzar.setBorder(null);
			button_avanzar.setBorderPainted(false);
			button_avanzar.setText("\u25BA" + "\u25BA ");
		}
		return button_avanzar;
	}
	private JButton getButton_Del() {
		if (button_Del == null) {
			button_Del = new JButton("Del");
			button_Del.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					deletePlaySeleccion();
				}
			});
			button_Del.setFocusable(false);
			button_Del.setPreferredSize(new Dimension(63, 23));
			button_Del.setMinimumSize(new Dimension(63, 23));
			button_Del.setMaximumSize(new Dimension(63, 23));
			button_Del.setMargin(new Insets(0, 0, 0, 0));
			button_Del.setForeground(Color.WHITE);
			button_Del.setFont(new Font("Dialog", Font.BOLD, 12));
			button_Del.setBorderPainted(false);
			button_Del.setBorder(null);
		}
		return button_Del;
	}
	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMnFile());
			menuBar.add(getMnAyuda());
		}
		return menuBar;
	}
	private JMenu getMnFile() {
		if (mnFile == null) {
			mnFile = new JMenu("File");
			mnFile.add(getMntmOpen());
			mnFile.add(getSeparator());
			mnFile.add(getMntmExit());
		}
		return mnFile;
	}
	private JMenuItem getMntmOpen() {
		if (mntmOpen == null) {
			mntmOpen = new JMenuItem("Open");
			mntmOpen.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					abrirFicheros();
				}
			});
		}
		return mntmOpen;
	}
	
	private void abrirFicheros(){
		int respuesta = getSelector().showOpenDialog(this);
		if(respuesta == JFileChooser.APPROVE_OPTION){
			for(int i=0; i<selector.getSelectedFiles().length;i++){
				modeloListLibrary.addElement(new MyFile(selector.getSelectedFiles()[i]));
			}
		}
		
		
	}
	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
		}
		return separator;
	}
	private JMenuItem getMntmExit() {
		if (mntmExit == null) {
			mntmExit = new JMenuItem("Exit");
			mntmExit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					System.exit(0);
				}
			});
		}
		return mntmExit;
	}
	private JButton getBtnClearAll() {
		if (btnClearAll == null) {
			btnClearAll = new JButton("Clear ");
			btnClearAll.setFocusable(false);
			btnClearAll.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mP.stop();
					modeloListPlay.clear();
				}
			});
			btnClearAll.setMargin(new Insets(0, 0, 0, 0));
			btnClearAll.setForeground(Color.WHITE);
			btnClearAll.setFont(new Font("Dialog", Font.BOLD, 12));
		}
		return btnClearAll;
	}
	
	private void cargaAyuda(){

		URL hsURL;
		HelpSet hs;

		try {
			File fichero = new File("help/ayuda.hs");
			hsURL = fichero.toURI().toURL();
			hs = new HelpSet(null, hsURL);
		}

		catch (Exception e){
			System.out.println("Ayuda no encontrada");
			return;
		}

		HelpBroker hb = hs.createHelpBroker();
		

		hb.enableHelpKey(getRootPane(),"introduccion", hs);
		hb.enableHelpOnButton(getMntmAyuda(), "introduccion", hs);
		hb.enableHelp(getList_PlayList(), "reproducir", hs);
		hb.enableHelp(getList_PlayList(), "eliminar", hs);
	
	}
	private JMenu getMnAyuda() {
		if (mnAyuda == null) {
			mnAyuda = new JMenu("Help");
			mnAyuda.add(getMntmAyuda());
		}
		return mnAyuda;
	}
	private JMenuItem getMntmAyuda() {
		if (mntmAyuda == null) {
			mntmAyuda = new JMenuItem("Ayuda");
			mntmAyuda.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
		}
		return mntmAyuda;
	}
}
