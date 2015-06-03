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
import javax.swing.table.TableModel;

import proy.MaquinaGestora;

public class InterfazPerfil {
	
	private JFrame frame;
	private JFrame frmInicio;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTable table;
	private String usuario;
	
	/**
	 * Create the application.
	 */
	public InterfazPerfil( JFrame frmInicio, String usuario) {
		initialize();
		this.frmInicio=frmInicio;
		this.usuario=usuario;
		System.out.println(usuario);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setTitle("Event4All - Perfil cliente");
		frame.setBounds(100, 100, 930, 470);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
				//Fin modificar icono ventana
				
				
				JButton cargaravatar = new JButton();
				cargaravatar.setIcon(new ImageIcon(this.getClass().getResource("/imgs/cargafotoperfilfin.png")));
				cargaravatar.setBounds(136, 139, 75, 57);
				cargaravatar.setBorder(null);
				cargaravatar.setOpaque(false);
				cargaravatar.setContentAreaFilled(false);
				cargaravatar.setBorderPainted(false);
				frame.getContentPane().add(cargaravatar);
				//
				cargaravatar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {

							
					}
				});
				
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(76, 244, 699, 167);
				frame.getContentPane().add(scrollPane);
				
				table = new JTable();
				scrollPane.setViewportView(table);
				
				JButton btnComprasRealizadas = new JButton("Compras realizadas");
				btnComprasRealizadas.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

				///////ComprasRealizadas);
				MaquinaGestora ClickCompras = new MaquinaGestora();
				TableModel tm = ClickCompras.getCompras(usuario);

				if(tm!=null){
				//Mostrar en la tabla los resultados de los eventos activos
				table.setModel(tm);

				}
				}
				});





				btnComprasRealizadas.setBounds(619, 207, 157, 29);
				frame.getContentPane().add(btnComprasRealizadas);
				
				
				JLabel label = new JLabel("0");
				label.setHorizontalAlignment(SwingConstants.CENTER);
				label.setBounds(702, 89, 46, 14);
				frame.getContentPane().add(label);
				
				JLabel lblNewLabel_1 = new JLabel("Compras realizadas:");
				lblNewLabel_1.setBounds(76, 225, 157, 14);
				frame.getContentPane().add(lblNewLabel_1);
				
				JLabel lblNewLabel = new JLabel("puntos");
				lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 10));
				lblNewLabel.setBounds(708, 104, 46, 14);
				frame.getContentPane().add(lblNewLabel);
				
				
				JLabel imgpuntos = new JLabel();
				imgpuntos.setIcon(new ImageIcon(this.getClass().getResource("/imgs/puntosimg2.png")));
				imgpuntos.setBounds(640, 11, 182, 167);
				frame.getContentPane().add(imgpuntos);
				
				JLabel lblNombre = new JLabel("Nombre:");
				lblNombre.setBounds(211, 73, 55, 14);
				frame.getContentPane().add(lblNombre);
				
				textField = new JTextField();
				textField.setEditable(false);
				textField.setBounds(270, 70, 146, 20);
				textField.setHorizontalAlignment(SwingConstants.CENTER);
				frame.getContentPane().add(textField);
				textField.setColumns(10);
		
		
		//imagen
				JLabel defaultava = new JLabel();
				defaultava.setIcon(new ImageIcon(this.getClass().getResource("/imgs/defaultavatar.png")));
				defaultava.setBounds(57, 46, 128, 128);
				frame.getContentPane().add(defaultava);
				
				textField_1 = new JTextField();
				textField_1.setEditable(false);
				textField_1.setHorizontalAlignment(SwingConstants.CENTER);
				textField_1.setBounds(270, 98, 188, 20);
				frame.getContentPane().add(textField_1);
				textField_1.setColumns(10);
				
				JLabel lblApellidos = new JLabel("Apellidos:");
				lblApellidos.setBounds(211, 101, 55, 14);
				frame.getContentPane().add(lblApellidos);
				
				textField_2 = new JTextField();
				textField_2.setEditable(false);
				textField_2.setHorizontalAlignment(SwingConstants.CENTER);
				textField_2.setBounds(270, 123, 222, 20);
				frame.getContentPane().add(textField_2);
				textField_2.setColumns(10);
				
				JLabel lblEmail = new JLabel("E-mail:");
				lblEmail.setBounds(211, 126, 46, 14);
				frame.getContentPane().add(lblEmail);
				//Fin Fondo pantalla
		
		//Fondo pantalla en un Jlabel o una imagen
				
				
			
				
	
				JButton btnCerrarSesin = new JButton("Cerrar Sesi\u00F3n");
				btnCerrarSesin.setBounds(785, 11, 129, 23);
				frame.getContentPane().add(btnCerrarSesin);
				btnCerrarSesin.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e)	{
						

						frame.dispose();
						frmInicio.setVisible(true);
					}
				
				});
				
				JButton btnBuscarEventos = new JButton("Buscar Eventos");
				btnBuscarEventos.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e)	{
						
							
							try {
								
								InterfazBuscarEvento window = new InterfazBuscarEvento(frame, usuario);
								window.getJFrame().setVisible(true);
								frame.setVisible(false);
								} catch (Exception e1) {
									e1.printStackTrace();
							
							}
						}
				});
				
				btnBuscarEventos.setBounds(785, 388, 129, 23);
				frame.getContentPane().add(btnBuscarEventos);

				
				
				JLabel lblFondo = new JLabel();
				lblFondo.setIcon(new ImageIcon(this.getClass().getResource("/imgs/wallpaper.jpg")));
				lblFondo.setBounds(0, 0, 924, 442);
				frame.getContentPane().add(lblFondo);
				//Fin Fondo pantalla
				
				//modificar icono ventana
				URL iconURL = getClass().getResource("/imgs/logotype.png");
				// iconURL is null when not found
				ImageIcon icon = new ImageIcon(iconURL);
				frame.setIconImage(icon.getImage());
				
				JButton btnBajaUser = new JButton("Borrar Cuenta");
				btnBajaUser.setBounds(10, 7, 129, 23);
				frame.getContentPane().add(btnBajaUser);
				btnBajaUser.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e)	{
						
						MaquinaGestora mg = new MaquinaGestora();
						mg.bajaCliente(usuario);
						frame.dispose();
						frmInicio.setVisible(true);
					}
				});
				
	}

	
	
	
	
	

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
	
	public JFrame getFrame (){
		return frame;
	}
}
