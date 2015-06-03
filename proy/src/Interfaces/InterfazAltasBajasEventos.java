package Interfaces;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.awt.Event;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import java.awt.FlowLayout;

import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import proy.MaquinaGestora;

public class InterfazAltasBajasEventos {

	private JFrame frmAñadirEventos;
	private JTextField textNombre;
	private JTextField textDireccion;
	private JTextField textPoblacion;
	private JTextField textEstado;
	private JTextField textHora;
	private JTextField textFecha;
	private JTextField textTipo;
	private JButton botonAñadirEvento;
	private JButton botonCancelarEvento;
	private JTextField txtSala;
	private JTextField txtAsiento;
	private JTextField txtNumeroDeEntradas;
	private JTextField txtDatos;
	private JTextField txtPais;
	private JTextField txtAforo;
	private JTextField txtCodigopostal;
	private JTextField txtNombrelugar;
	private JTextField txtPrecio;
	private JLabel lblPas;
	private JLabel lblAforo;
	private JLabel lblNomlugarevento;
	private JLabel lblDireccin;
	private JLabel lblPoblacin;
	private JLabel lblCdigoPostal;
	private JLabel lblHora;
	private JLabel lblSala;
	private JLabel lblFecha;
	private JLabel lblAsiento;
	private JLabel lblNombreEvento;
	private JLabel lblTipo;
	private JLabel lblEstado;
	private JLabel lblNumeroentradas;
	private JLabel lblPrecio;
	private JLabel lblDatos;
	private JFrame frmLoginGestor;
	  
	

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazAltasBajasEventos window = new InterfazAltasBajasEventos();
					window.frmAñadirEventos.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	*/
   
	/**
	 * Create the application.
	 */
	public InterfazAltasBajasEventos(JFrame frmLoginGestor) {
		initialize();
		this.frmLoginGestor=frmLoginGestor;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frmAñadirEventos = new JFrame();
		frmAñadirEventos.setResizable(false);
		frmAñadirEventos.getContentPane().setBackground(Color.GRAY);
		frmAñadirEventos.setBounds(100, 100, 930, 470);
		frmAñadirEventos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAñadirEventos.getContentPane().setLayout(null);
		
		
		
		
		textNombre = new JTextField();
		textNombre.setBounds(228, 219, 151, 20);
		textNombre.setHorizontalAlignment(SwingConstants.CENTER);
		frmAñadirEventos.getContentPane().add(textNombre);
		textNombre.setColumns(10);
		
		textDireccion = new JTextField();
		textDireccion.setHorizontalAlignment(SwingConstants.CENTER);
		textDireccion.setBounds(228, 63, 151, 20);
		frmAñadirEventos.getContentPane().add(textDireccion);
		textDireccion.setColumns(10);
		
		textPoblacion = new JTextField();
		textPoblacion.setBounds(389, 63, 151, 20);
		textPoblacion.setHorizontalAlignment(SwingConstants.CENTER);
		frmAñadirEventos.getContentPane().add(textPoblacion);
		textPoblacion.setColumns(10);
		
		textEstado = new JTextField();
		textEstado.setBounds(550, 219, 156, 20);
		textEstado.setHorizontalAlignment(SwingConstants.CENTER);
		frmAñadirEventos.getContentPane().add(textEstado);
		textEstado.setColumns(10);
		
		textHora = new JTextField();
		textHora.setText("00:00");
		textHora.setBounds(67, 129, 151, 20);
		textHora.setHorizontalAlignment(SwingConstants.CENTER);
		frmAñadirEventos.getContentPane().add(textHora);
		textHora.setColumns(10);
		
		textFecha = new JTextField();
		textFecha.setBounds(228, 129, 151, 20);
		textFecha.setHorizontalAlignment(SwingConstants.CENTER);
		textFecha.setText("01/01/2000");
		frmAñadirEventos.getContentPane().add(textFecha);
		textFecha.setColumns(10);
		
		textTipo = new JTextField();
		textTipo.setBounds(389, 219, 151, 20);
		textTipo.setHorizontalAlignment(SwingConstants.CENTER);
		frmAñadirEventos.getContentPane().add(textTipo);
		textTipo.setColumns(10);
		
		txtSala = new JTextField();
		txtSala.setHorizontalAlignment(SwingConstants.CENTER);
		txtSala.setColumns(10);
		txtSala.setBounds(389, 129, 151, 20);
		frmAñadirEventos.getContentPane().add(txtSala);
		
		txtAsiento = new JTextField();
		txtAsiento.setHorizontalAlignment(SwingConstants.CENTER);
		txtAsiento.setColumns(10);
		txtAsiento.setBounds(550, 129, 156, 20);
		frmAñadirEventos.getContentPane().add(txtAsiento);
		
		txtNumeroDeEntradas = new JTextField();
		txtNumeroDeEntradas.setHorizontalAlignment(SwingConstants.CENTER);
		txtNumeroDeEntradas.setColumns(10);
		txtNumeroDeEntradas.setBounds(228, 290, 151, 20);
		frmAñadirEventos.getContentPane().add(txtNumeroDeEntradas);
		
		txtDatos = new JTextField();
		txtDatos.setHorizontalAlignment(SwingConstants.CENTER);
		txtDatos.setColumns(10);
		txtDatos.setBounds(550, 290, 156, 20);
		frmAñadirEventos.getContentPane().add(txtDatos);
		
		txtPais = new JTextField();
		txtPais.setHorizontalAlignment(SwingConstants.CENTER);
		txtPais.setColumns(10);
		txtPais.setBounds(716, 63, 151, 20);
		frmAñadirEventos.getContentPane().add(txtPais);
		
		txtAforo = new JTextField();
		txtAforo.setHorizontalAlignment(SwingConstants.CENTER);
		txtAforo.setColumns(10);
		txtAforo.setBounds(716, 129, 151, 20);
		frmAñadirEventos.getContentPane().add(txtAforo);
		
		txtCodigopostal = new JTextField();
		txtCodigopostal.setHorizontalAlignment(SwingConstants.CENTER);
		txtCodigopostal.setColumns(10);
		txtCodigopostal.setBounds(552, 63, 154, 20);
		frmAñadirEventos.getContentPane().add(txtCodigopostal);
		
		txtNombrelugar = new JTextField();
		txtNombrelugar.setHorizontalAlignment(SwingConstants.CENTER);
		txtNombrelugar.setColumns(10);
		txtNombrelugar.setBounds(67, 63, 151, 20);
		frmAñadirEventos.getContentPane().add(txtNombrelugar);
		
		txtPrecio = new JTextField();
		txtPrecio.setHorizontalAlignment(SwingConstants.CENTER);
		txtPrecio.setBounds(389, 290, 151, 20);
		frmAñadirEventos.getContentPane().add(txtPrecio);
		txtPrecio.setColumns(10);
		
		
		
		botonAñadirEvento = new JButton("A\u00F1adir Evento");
		botonAñadirEvento.setBounds(324, 358, 141, 35);
		frmAñadirEventos.getContentPane().add(botonAñadirEvento);
		botonAñadirEvento.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e)	{
			
			
			String strtextNombre = textNombre.getText();
			String strtextDireccion = textDireccion.getText();
			String strtextPoblacion = textPoblacion.getText();
			String strtextEstado = textEstado.getText();
			String strtextHora = textHora.getText();
			String strstrtextFecha = textFecha.getText();
			String strtextTipo = textTipo.getText();
			String  strtxtSala =txtSala.getText() ;
			String  strtxtAsiento=txtAsiento.getText();
			String  strtxtNumeroDeEntradas=txtNumeroDeEntradas.getText();
			Integer numEntradas=Integer.parseInt(strtxtNumeroDeEntradas);
			String  strtxtDatos=txtDatos.getText();
			String  strtxtPais=txtPais.getText();
			String  strtxtAforo=txtAforo.getText();
			Integer aforo_=Integer.parseInt(strtxtAforo);
			String strtxtCodigopostal= txtCodigopostal.getText();
			String strtxtNombrelugar=txtNombrelugar.getText();
			String strtxtPrecio=txtPrecio.getText();
			Integer prec=Integer.parseInt(strtxtPrecio);

		
			MaquinaGestora mg = new MaquinaGestora();
			SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm");
			Date fechaD = null;
			
			try {
				fechaD = formato.parse(strstrtextFecha+" "+strtextHora);
			} catch (ParseException e2) {
				e2.printStackTrace();
			}/*String nombre_, String Direccion_,
			String poblacion_, String estado_, String fechahora_, String tipo_,
			String sala_, String asiento_, Integer nument_, String datos_,
			String Pais_, Integer Aforo_, String codigoPostal_,
			String NombreLugarEvento_, Integer precio_*/
			String fechahora=fechaD.toString();
			mg.altaEvento(strtextNombre,strtextDireccion,strtextPoblacion,strtextEstado,
					fechahora,strtextTipo,strtxtSala,strtxtAsiento,
					numEntradas,strtxtDatos,strtxtPais,aforo_,strtxtCodigopostal,strtxtNombrelugar,prec);
			JOptionPane.showMessageDialog(null,"Has añadido un evento");
			
		}
		});
	
		
		
		botonCancelarEvento = new JButton("Cancelar Evento");
		botonCancelarEvento.setBounds(476, 358, 141, 35);
		frmAñadirEventos.getContentPane().add(botonCancelarEvento);
		
		lblPas = new JLabel("Pa\u00EDs");
		lblPas.setHorizontalAlignment(SwingConstants.CENTER);
		lblPas.setBounds(729, 29, 121, 35);
		frmAñadirEventos.getContentPane().add(lblPas);
		
		lblAforo = new JLabel("Aforo");
		lblAforo.setHorizontalAlignment(SwingConstants.CENTER);
		lblAforo.setBounds(726, 96, 121, 35);
		frmAñadirEventos.getContentPane().add(lblAforo);
		
		lblNomlugarevento = new JLabel("Nom_Lugar_Evento");
		lblNomlugarevento.setHorizontalAlignment(SwingConstants.CENTER);
		lblNomlugarevento.setBounds(85, 29, 121, 35);
		frmAñadirEventos.getContentPane().add(lblNomlugarevento);
		
		lblDireccin = new JLabel("Direcci\u00F3n");
		lblDireccin.setHorizontalAlignment(SwingConstants.CENTER);
		lblDireccin.setBounds(248, 29, 121, 35);
		frmAñadirEventos.getContentPane().add(lblDireccin);
		
		lblPoblacin = new JLabel("Poblaci\u00F3n");
		lblPoblacin.setHorizontalAlignment(SwingConstants.CENTER);
		lblPoblacin.setBounds(404, 29, 121, 35);
		frmAñadirEventos.getContentPane().add(lblPoblacin);
		
		lblCdigoPostal = new JLabel("C\u00F3digo Postal");
		lblCdigoPostal.setHorizontalAlignment(SwingConstants.CENTER);
		lblCdigoPostal.setBounds(566, 29, 121, 35);
		frmAñadirEventos.getContentPane().add(lblCdigoPostal);
		
		lblHora = new JLabel("Hora");
		lblHora.setHorizontalAlignment(SwingConstants.CENTER);
		lblHora.setBounds(67, 96, 151, 35);
		frmAñadirEventos.getContentPane().add(lblHora);
		
		lblSala = new JLabel("Sala");
		lblSala.setHorizontalAlignment(SwingConstants.CENTER);
		lblSala.setBounds(399, 96, 141, 35);
		frmAñadirEventos.getContentPane().add(lblSala);
		
		lblFecha = new JLabel("Fecha");
		lblFecha.setHorizontalAlignment(SwingConstants.CENTER);
		lblFecha.setBounds(238, 96, 141, 35);
		frmAñadirEventos.getContentPane().add(lblFecha);
		
		lblAsiento = new JLabel("Asientos");
		lblAsiento.setHorizontalAlignment(SwingConstants.CENTER);
		lblAsiento.setBounds(562, 96, 132, 35);
		frmAñadirEventos.getContentPane().add(lblAsiento);
		
		lblNombreEvento = new JLabel("Nombre Evento");
		lblNombreEvento.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreEvento.setBounds(228, 183, 151, 35);
		frmAñadirEventos.getContentPane().add(lblNombreEvento);
		
		lblTipo = new JLabel("Tipo");
		lblTipo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTipo.setBounds(404, 183, 121, 35);
		frmAñadirEventos.getContentPane().add(lblTipo);
		
		lblEstado = new JLabel("Estado");
		lblEstado.setHorizontalAlignment(SwingConstants.CENTER);
		lblEstado.setBounds(566, 183, 121, 35);
		frmAñadirEventos.getContentPane().add(lblEstado);
		
		lblNumeroentradas = new JLabel("Numero_Entradas");
		lblNumeroentradas.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumeroentradas.setBounds(238, 250, 141, 35);
		frmAñadirEventos.getContentPane().add(lblNumeroentradas);
		
		lblPrecio = new JLabel("Precio");
		lblPrecio.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrecio.setBounds(399, 250, 121, 35);
		frmAñadirEventos.getContentPane().add(lblPrecio);
		
		lblDatos = new JLabel("Datos");
		lblDatos.setHorizontalAlignment(SwingConstants.CENTER);
		lblDatos.setBounds(566, 250, 121, 35);
		frmAñadirEventos.getContentPane().add(lblDatos);
		
		JLabel lblFondo = new JLabel();
		lblFondo.setIcon(new ImageIcon(this.getClass().getResource("/imgs/wallpaper.jpg")));
		lblFondo.setBounds(0, 0, 930, 470);
		frmAñadirEventos.getContentPane().add(lblFondo);
		
		botonCancelarEvento.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e2)	{
			
			String strtextNombre = textNombre.getText();
			String strtxtNombrelugar=txtNombrelugar.getText();

			MaquinaGestora mg=new MaquinaGestora();
			mg.bajaEvento(strtextNombre);
			JOptionPane.showMessageDialog(null,"Has borrado un evento");
			
			}
			

			});
		
	}
	
	public JFrame getFrameAltasBajasEventos(){
		return frmAñadirEventos;
	}
}
