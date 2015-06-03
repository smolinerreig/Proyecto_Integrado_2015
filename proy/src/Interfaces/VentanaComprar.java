package Interfaces;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.SystemColor;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.net.URL;

import javax.swing.SwingConstants;

import proy.MaquinaGestora;

import java.awt.Font;

public class VentanaComprar {

	private JFrame VentanaComprarFrame;
	private JTextField textField;
	private JLabel lblApellidos;
	private JTextField textField_1;
	private JPasswordField passwordField;
	private JTextField textField_9;
	private JLabel lblNTarjeta;
	private JTextField textField_10;
	private JLabel lblTipo;
	private JPanel panel_1;
	private JLabel lbllistoParaComprar;
	private JPanel panel_2;
	private JLabel lblSiYaEsts;
	private JPanel panel_3;
	private JLabel lblLasEntradas;
	private JLabel lblParaCompletarLa;
	private JTextField textField_11;
	private JLabel lblNTarjeta_1;
	private JTextField textField_12;
	private JTextField textField_13;
	private JPanel panel_4;
	private JLabel lblinvitado;
	private JLabel lblSoyCliente;
	private JFrame frmEventallBuscar;
	private JButton btnAtrs;
	private String nombre;
	private Integer id_evento;
	private Integer numero_entradas;
	private double precio_final;

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaComprar window = new VentanaComprar();
					window.VentanaComprarFrame.setVisible(true);
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
	public VentanaComprar( JFrame frmEventallBuscar, String nombre, Integer id_evento, Integer num_entradas, double precio_final) {
		initialize();
		this.frmEventallBuscar=frmEventallBuscar;
		this.nombre=nombre;
		this.id_evento=id_evento;
		System.out.println(this.nombre);
		System.out.println(this.id_evento);
		this.numero_entradas=num_entradas;
		this.precio_final=precio_final;
		System.out.println(nombre+"//"+id_evento+"//"+numero_entradas+"//"+"//"+precio_final);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		VentanaComprarFrame = new JFrame();
		VentanaComprarFrame.setResizable(false);
		VentanaComprarFrame.setTitle("Event4all - Comprar entradas");
		VentanaComprarFrame.setBounds(100, 100, 930, 487);
		VentanaComprarFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		VentanaComprarFrame.getContentPane().setLayout(null);
		
		JButton btnComprar = new JButton("\u00A1Comprar!");
		btnComprar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e)	{
				
						String strtextNTarjeta = textField_10.getText();
						
						MaquinaGestora mg = new MaquinaGestora ();				
						
						mg.comprarEvento(strtextNTarjeta, nombre, id_evento, numero_entradas, precio_final);
					}
				
				});

		
		textField_11 = new JTextField();
		textField_11.setHorizontalAlignment(SwingConstants.CENTER);
		textField_11.setBounds(660, 294, 121, 20);
		VentanaComprarFrame.getContentPane().add(textField_11);
		textField_11.setColumns(10);
		
		JLabel iniciase = new JLabel();
		iniciase.setIcon(new ImageIcon(this.getClass().getResource("/imgs/fotoperfildefault.png")));
		iniciase.setBounds(502, 126, 120, 104);
		VentanaComprarFrame.getContentPane().add(iniciase);
		
		JLabel Campos = new JLabel();
		Campos.setIcon(new ImageIcon(this.getClass().getResource("/imgs/modificar.png")));
		Campos.setBounds(306, 100, 128, 104);
		VentanaComprarFrame.getContentPane().add(Campos);
		
		JLabel tarjetascred = new JLabel();
		tarjetascred.setIcon(new ImageIcon(this.getClass().getResource("/imgs/tarjetas.png")));
		tarjetascred.setBounds(32, 229, 120, 104);
		VentanaComprarFrame.getContentPane().add(tarjetascred);
		
		JLabel tarjetascred2 = new JLabel();
		tarjetascred2.setIcon(new ImageIcon(this.getClass().getResource("/imgs/tarjetas.png")));
		tarjetascred2.setBounds(492, 244, 120, 104);
		VentanaComprarFrame.getContentPane().add(tarjetascred2);
		
		textField_13 = new JTextField();
		textField_13.setBounds(183, 293, 126, 20);
		VentanaComprarFrame.getContentPane().add(textField_13);
		textField_13.setColumns(10);
		
		lblParaCompletarLa = new JLabel("para completar la compra:");
		lblParaCompletarLa.setBounds(66, 91, 235, 14);
		VentanaComprarFrame.getContentPane().add(lblParaCompletarLa);
		
		JLabel lblTipo_1 = new JLabel("Tipo: ");
		lblTipo_1.setBounds(117, 293, 46, 14);
		VentanaComprarFrame.getContentPane().add(lblTipo_1);
		
		JButton btncomprar = new JButton("\u00A1Comprar!");
		btncomprar.setBounds(629, 372, 110, 35);
		VentanaComprarFrame.getContentPane().add(btncomprar);
		btncomprar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e)	{
				if(nombre==null){
				nombre="-";
				}
				if(numero_entradas==null){
					numero_entradas=0;
					}
				if(id_evento==null){
					id_evento=0;
					}
						String strtextNTarjeta = textField_10.getText();
						
						MaquinaGestora mg = new MaquinaGestora ();				
						
						mg.comprarEvento(strtextNTarjeta, nombre, id_evento, numero_entradas, precio_final);
					}
				
				});
		
		lblinvitado = new JLabel("INVITADO");
		lblinvitado.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblinvitado.setBounds(156, 35, 191, 20);
		VentanaComprarFrame.getContentPane().add(lblinvitado);
		btnComprar.setBounds(143, 372, 103, 35);
		VentanaComprarFrame.getContentPane().add(btnComprar);
		
		lblSoyCliente = new JLabel("REGISTRADO");
		lblSoyCliente.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblSoyCliente.setBounds(631, 35, 232, 20);
		VentanaComprarFrame.getContentPane().add(lblSoyCliente);
		
		lblLasEntradas = new JLabel("para comprar las entradas:");
		lblLasEntradas.setBounds(516, 91, 382, 14);
		VentanaComprarFrame.getContentPane().add(lblLasEntradas);
		
		lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(593, 298, 46, 14);
		VentanaComprarFrame.getContentPane().add(lblTipo);
		
		textField_10 = new JTextField();
		textField_10.setHorizontalAlignment(SwingConstants.CENTER);
		textField_10.setBounds(660, 266, 121, 20);
		VentanaComprarFrame.getContentPane().add(textField_10);
		textField_10.setColumns(10);
		
		lblNTarjeta = new JLabel("N\u00BA Tarjeta: ");
		lblNTarjeta.setBounds(593, 269, 69, 14);
		VentanaComprarFrame.getContentPane().add(lblNTarjeta);
		
		textField_9 = new JTextField();
		textField_9.setHorizontalAlignment(SwingConstants.CENTER);
		textField_9.setBounds(660, 159, 121, 20);
		VentanaComprarFrame.getContentPane().add(textField_9);
		textField_9.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField.setBounds(660, 184, 121, 20);
		VentanaComprarFrame.getContentPane().add(passwordField);
		
		JLabel lblNombre_1 = new JLabel("Nombre:");
		lblNombre_1.setBounds(117, 158, 66, 14);
		VentanaComprarFrame.getContentPane().add(lblNombre_1);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(593, 187, 75, 14);
		VentanaComprarFrame.getContentPane().add(lblPassword);
		
		JLabel lblUsuario = new JLabel("Usuario: ");
		lblUsuario.setBounds(593, 162, 57, 14);
		VentanaComprarFrame.getContentPane().add(lblUsuario);
		
		textField_12 = new JTextField();
		textField_12.setBounds(183, 266, 126, 20);
		VentanaComprarFrame.getContentPane().add(textField_12);
		textField_12.setColumns(10);
		
		lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setBounds(117, 183, 66, 14);
		VentanaComprarFrame.getContentPane().add(lblApellidos);
		
		lblNTarjeta_1 = new JLabel("N\u00BA Tarjeta:");
		lblNTarjeta_1.setBounds(118, 266, 66, 14);
		VentanaComprarFrame.getContentPane().add(lblNTarjeta_1);
		
		panel_3 = new JPanel();
		panel_3.setBounds(441, 35, 10, 372);
		VentanaComprarFrame.getContentPane().add(panel_3);
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setBounds(182, 183, 126, 20);
		VentanaComprarFrame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBounds(182, 158, 126, 20);
		VentanaComprarFrame.getContentPane().add(textField);
		textField.setColumns(10);
				
				lbllistoParaComprar = new JLabel("Si no est\u00E1s registrado, introduce los datos en los campos ");
				lbllistoParaComprar.setBounds(66, 73, 335, 14);
				VentanaComprarFrame.getContentPane().add(lbllistoParaComprar);
				
				lblSiYaEsts = new JLabel("Si ya est\u00E1s registrado, confirme su cuenta y eliga el metodo de compra");
				lblSiYaEsts.setBounds(516, 73, 382, 20);
				VentanaComprarFrame.getContentPane().add(lblSiYaEsts);
				
				panel_2 = new JPanel();
				panel_2.setBounds(553, 252, 272, 81);
				VentanaComprarFrame.getContentPane().add(panel_2);
				
				JPanel panel = new JPanel();
				panel.setBackground(SystemColor.inactiveCaptionBorder);
				panel.setBounds(99, 140, 255, 78);
				VentanaComprarFrame.getContentPane().add(panel);
				
				panel_1 = new JPanel();
				panel_1.setBounds(553, 138, 272, 85);
				VentanaComprarFrame.getContentPane().add(panel_1);
				
				panel_4 = new JPanel();
				panel_4.setBounds(99, 251, 255, 82);
				VentanaComprarFrame.getContentPane().add(panel_4);
				//Fin Fondo pantalla
		JLabel lblNombre = new JLabel("Nombre: ");
		lblNombre.setBounds(44, 59, 46, 14);
		VentanaComprarFrame.getContentPane().add(lblNombre);
		
		btnAtrs = new JButton("ATR\u00C1S");
		btnAtrs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)	{
				

				VentanaComprarFrame.dispose();
				frmEventallBuscar.setVisible(true);
			}
		
		});
		
		btnAtrs.setBounds(400, 418, 89, 23);
		VentanaComprarFrame.getContentPane().add(btnAtrs);
		
		//Fondo pantalla en un Jlabel o una imagen
				JLabel lblFondo = new JLabel();
				lblFondo.setIcon(new ImageIcon(this.getClass().getResource("/imgs/wallpaper.jpg")));
				lblFondo.setBounds(0, 0, 924, 462);
				VentanaComprarFrame.getContentPane().add(lblFondo);
		
		//modificar icono ventana
				URL iconURL = getClass().getResource("/imgs/logotype.png");
				// iconURL is null when not found
				ImageIcon icon = new ImageIcon(iconURL);
				VentanaComprarFrame.setIconImage(icon.getImage());
				//Fin modificar icono ventana
		
	}
	
	public JFrame getFrameComprar(){
		return VentanaComprarFrame;
	}
}






