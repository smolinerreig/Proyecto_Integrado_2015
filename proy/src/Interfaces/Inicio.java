package Interfaces;
import proy.Persona;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.EventQueue;
import java.awt.Window.Type;
import java.net.URL;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JPanel;

import java.awt.SystemColor;

import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class Inicio {

	private JFrame interfazInicio;
	public static JTextField username;
	private JPasswordField passwordField;

	/**
	 * Create the application.
	 */
	public Inicio() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		interfazInicio = new JFrame();
		interfazInicio.setBounds(100, 100, 930, 470);
		interfazInicio.setResizable(false);
		interfazInicio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		interfazInicio.getContentPane().setLayout(null);
		interfazInicio.setTitle("Event4all - Inicio");

		JButton btnInvitado = new JButton("Invitado");
		btnInvitado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		JLabel iniciars = new JLabel();
		iniciars.setIcon(new ImageIcon(this.getClass().getResource(
				"/imgs/iniciar.png")));
		iniciars.setBounds(692, 173, 60, 54);
		interfazInicio.getContentPane().add(iniciars);

		JLabel write = new JLabel();
		write.setIcon(new ImageIcon(this.getClass().getResource(
				"/imgs/write.png")));
		write.setBounds(575, 321, 60, 54);
		interfazInicio.getContentPane().add(write);

		JLabel invitao = new JLabel();
		invitao.setIcon(new ImageIcon(this.getClass().getResource(
				"/imgs/iniciar sesion.png")));
		invitao.setBounds(206, 340, 60, 54);
		interfazInicio.getContentPane().add(invitao);

		// BOTON INICIAR SESION
		JButton btnIniciarSesin = new JButton("Iniciar sesi\u00F3n");
		btnIniciarSesin.setBounds(740, 181, 116, 35);
		interfazInicio.getContentPane().add(btnIniciarSesin);
		btnIniciarSesin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				
				
				
				String strUsuario = username.getText();
				String strPassword = passwordField.getText();
				
				if(InicioSesion(strUsuario,strPassword)==true){  
					
						InterfazPerfil window = new InterfazPerfil(interfazInicio, strUsuario);
						window.getFrame().setVisible(true);
						interfazInicio.setVisible(false);
						
				}
								
					}
				
			
			
		});


		/*
		 * ENCRIPTACION DE CONTRASEÑA private String hash(String clear) throws
		 * Exception { MessageDigest md = MessageDigest.getInstance("MD5");
		 * byte[] b = md.digest(clear.getBytes()); int size = b.length;
		 * StringBuffer h = new StringBuffer(size); for (int i = 0; i < size;
		 * i++) { int u = b [ i ] & 255 ;
		 * 
		 * if (u<16){ h.append("0"+Integer.toHexString(u)); }else {
		 * h.append(Integer.toHexString(u)); } } return h.toString(); }
		 */

		passwordField = new JPasswordField();
		passwordField.setBounds(750, 138, 140, 18);
		interfazInicio.getContentPane().add(passwordField);

		username = new JTextField();
		username.setBounds(750, 109, 140, 18);
		interfazInicio.getContentPane().add(username);
		username.setColumns(10);

		JLabel lblUsuario = new JLabel("Usuario: ");
		lblUsuario.setBounds(669, 113, 71, 14);
		interfazInicio.getContentPane().add(lblUsuario);

		JLabel lblNewLabel = new JLabel("Contrase\u00F1a:");
		lblNewLabel.setBounds(669, 142, 89, 14);
		interfazInicio.getContentPane().add(lblNewLabel);

		btnInvitado.setBounds(259, 350, 103, 37);
		interfazInicio.getContentPane().add(btnInvitado);
		btnInvitado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {

					InterfazInvitado window = new InterfazInvitado(
							interfazInicio);
					window.getFrameInvitado().setVisible(true);
					interfazInicio.setVisible(false);
				} catch (Exception e1) {
					e1.printStackTrace();

				}
			}
		});

		// BOTON REGISTRARSE
		JButton btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {

					InterfazRegistro window = new InterfazRegistro(
							interfazInicio);
					window.setVisible(true);
					interfazInicio.setVisible(false);
				} catch (Exception e1) {
					e1.printStackTrace();

				}

			}

		});
		btnRegistrarse.setBounds(630, 331, 116, 37);
		interfazInicio.getContentPane().add(btnRegistrarse);

		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaptionBorder);
		panel.setBounds(634, 85, 280, 156);
		interfazInicio.getContentPane().add(panel);

		JLabel iniciase = new JLabel();
		iniciase.setIcon(new ImageIcon(this.getClass().getResource(
				"/imgs/imagenprincipal2.png")));
		iniciase.setBounds(-13, 23, 650, 364);
		interfazInicio.getContentPane().add(iniciase);

		// Fondo pantalla en un Jlabel o una imagen
		JLabel lblFondo = new JLabel();
		lblFondo.setIcon(new ImageIcon(this.getClass().getResource(
				"/imgs/wallpaper.jpg")));
		lblFondo.setBounds(0, 0, 924, 442);
		interfazInicio.getContentPane().add(lblFondo);
		// Fin Fondo pantalla

		// modificar icono ventana
		URL iconURL = getClass().getResource("/imgs/logotype.png");
		// iconURL is null when not found
		ImageIcon icon = new ImageIcon(iconURL);
		interfazInicio.setIconImage(icon.getImage());

	}

	public JFrame getFrameInicio() {
		return interfazInicio;
	}

public boolean InicioSesion(String n_usuario,String contraseña){
		
		String n_usuario_=null;
		String contraseña_=null;
		boolean conclusion=false;
		
		
		String driver = "org.postgresql.Driver";
		String connectString = "jdbc:postgresql://localhost:5432/ventaentradas";
		String user = "postgres";
		String password = "tonphp";
		
         try{
            Class.forName(driver);
            Connection connect=(Connection) DriverManager.getConnection(connectString,user,password);
            Statement consulta=(Statement) connect.createStatement();
            ResultSet resultado= consulta.executeQuery("SELECT n_usuario, contraseña FROM usuario  WHERE  n_usuario = '"+n_usuario+"'  AND contraseña = '"+contraseña+"';");
            
            
            while(resultado.next()){
            	n_usuario_=resultado.getString("n_usuario");
            	contraseña_=resultado.getString("contraseña");
            }     
           

         } catch(Exception e){
        	 System.out.println(e.toString());
         }
		
		if (n_usuario.equals(n_usuario_)  && contraseña.equals(contraseña_)){
			conclusion=true;
		}
		
		return conclusion;
	}
	
	private String hash(String clear) throws Exception { 
		
		MessageDigest md = MessageDigest.getInstance("MD5"); 
		
		byte[] b = md.digest(clear.getBytes()); 
		int size = b.length; 
		StringBuffer h = new StringBuffer(size); 
		for (int i = 0; i < size; i++) { 
		int u = b [ i ] & 255 ;
		
		if (u<16){
			h.append("0"+Integer.toHexString(u)); 
		}else { 
		h.append(Integer.toHexString(u)); 
		} 
		} 
		return h.toString(); 
		}

	
	public static void invoke(){
		
		
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						Inicio window = new Inicio();
						window.interfazInicio.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		
	}

}
