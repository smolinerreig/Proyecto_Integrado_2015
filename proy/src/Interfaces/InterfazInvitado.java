package Interfaces;

import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;



import java.awt.Font;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class InterfazInvitado extends JFrame {


	private JFrame frmInvitado;
	private JFrame frmInicio;
	private JTextField txtInvitado;

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazPerfil window = new InterfazPerfil();
					window.frame.setVisible(true);
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
	public InterfazInvitado(JFrame frmInicio) {
		initialize();
		this.frmInicio=frmInicio;
		
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmInvitado = new JFrame();
		frmInvitado.setResizable(false);
		frmInvitado.setTitle("Event4All - Perfil cliente");
		frmInvitado.setBounds(100, 100, 930, 470);
		frmInvitado.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmInvitado.getContentPane().setLayout(null);
				
				JLabel lblNombre = new JLabel("Nombre:");
				lblNombre.setBounds(214, 124, 55, 14);
				frmInvitado.getContentPane().add(lblNombre);
				
				txtInvitado = new JTextField();
				txtInvitado.setText("Invitado");
				txtInvitado.setEditable(false);
				txtInvitado.setBounds(267, 121, 146, 20);
				txtInvitado.setHorizontalAlignment(SwingConstants.CENTER);
				frmInvitado.getContentPane().add(txtInvitado);
				txtInvitado.setColumns(10);
		
		
		//imagen
				JLabel defaultava = new JLabel();
				defaultava.setIcon(new ImageIcon(this.getClass().getResource("/imgs/defaultavatar.png")));
				defaultava.setBounds(57, 46, 128, 128);
				frmInvitado.getContentPane().add(defaultava);
				//Fin Fondo pantalla
		
		//Fondo pantalla en un Jlabel o una imagen
				
				
			
				
	
				JButton btnCerrarSesin = new JButton("Cerrar Sesi\u00F3n");
				btnCerrarSesin.setBounds(785, 388, 129, 23);
				frmInvitado.getContentPane().add(btnCerrarSesin);
				btnCerrarSesin.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e)	{
						

						frmInvitado.dispose();
						frmInicio.setVisible(true);
					}
				
				});
				
				
				JLabel lblFondoPantalla = new JLabel();
				lblFondoPantalla.setIcon(new ImageIcon(this.getClass().getResource("/imgs/wallpaper.jpg")));
				lblFondoPantalla.setBounds(0, 0, 946, 442);
				frmInvitado.getContentPane().add(lblFondoPantalla);
				//Fin Fondo pantalla
				
				//modificar icono ventana
				URL iconURL = getClass().getResource("/imgs/logotype.png");
				// iconURL is null when not found
				ImageIcon icon = new ImageIcon(iconURL);
				frmInvitado.setIconImage(icon.getImage());
				
				
				JButton btnBuscarEventos = new JButton("Buscar Eventos");
				btnBuscarEventos.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e)	{				
							try {
								String usuario="anonimoX";
								InterfazBuscarEvento window = new InterfazBuscarEvento(frmInvitado, usuario);
								window.getJFrame().setVisible(true);
								frmInvitado.setVisible(false);
								} catch (Exception e1) {
									e1.printStackTrace();
							
							}
						}
				});
				btnBuscarEventos.setBounds(67, 242, 146, 23);				
				frmInvitado.getContentPane().add(btnBuscarEventos);
	}
	
		//PONER LA TABLA DE EVENTOS Y COMPRAR TANTO AQUÍ COMO EN CLIENTE 
	

	

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
	
	public JFrame getFrameInvitado(){
		return frmInvitado;
	}
	
	
}
