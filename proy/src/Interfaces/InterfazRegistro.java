package Interfaces;

import java.awt.EventQueue;
import java.awt.SystemColor;

import javax.swing.JFrame;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import javax.swing.JMenuBar;
import javax.swing.JButton;

import proy.MaquinaGestora;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class InterfazRegistro extends JFrame {

	private JFrame interfazregistro;
	private JFrame frmInicio;
	private JTextField txtEmailAddress;
	private JTextField txtName;
	private JTextField txtSurname;
	private JPasswordField txtPassword;
	private JLabel txtpnDireccionEmail;
	private JLabel txtpnNombre;
	private JLabel txtpnApellido;
	private JLabel txtpnContraseña;
	private JLabel txtpnFechaDeNacimiento;
	private JTextField textDNI;
	private JTextField textTelefono;
	private JTextField textDireccion;
	private JTextField textPoblacion;
	private JTextField textCodigoPostal;
	private JTextField textPais;
	private JTextField textNUsuario;
	private JTextField textNTarjeta;
	private JTextField textFCaducidad;
	private JTextField textCSeguridad;
	private JTextField textTTarjeta;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JLabel lblBienvenidoAEventall;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	public InterfazRegistro( JFrame frmInicio) {
		initialize();
		this.frmInicio=frmInicio;
		this.interfazregistro=this;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setResizable(false);
		setTitle("Event4all - Registrarse");
		setBounds(100, 100, 930, 470);
		getContentPane().setLayout(null);
		//Fin Fondo pantalla

		
		txtEmailAddress = new JTextField();
		txtEmailAddress.setToolTipText("");
		txtEmailAddress.setBounds(142, 159, 185, 20);
		txtEmailAddress.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(txtEmailAddress);
		txtEmailAddress.setColumns(10);
		
		txtName = new JTextField();
		txtName.setBounds(142, 97, 185, 20);
		txtName.setHorizontalAlignment(SwingConstants.CENTER);
		txtName.setColumns(10);
		getContentPane().add(txtName);
		
		txtSurname = new JTextField();
		txtSurname.setBounds(142, 128, 185, 20);
		txtSurname.setHorizontalAlignment(SwingConstants.CENTER);
		txtSurname.setColumns(10);
		getContentPane().add(txtSurname);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(643, 101, 147, 20);
		txtPassword.setHorizontalAlignment(SwingConstants.CENTER);
		txtPassword.setColumns(10);
		getContentPane().add(txtPassword);
		
		txtpnDireccionEmail = new JLabel();
		txtpnDireccionEmail.setBounds(74, 159, 106, 20);
		txtpnDireccionEmail.setText("E-mail:");
		getContentPane().add(txtpnDireccionEmail);
		
		
		txtpnNombre = new JLabel();
		txtpnNombre.setBounds(74, 97, 89, 20);
		txtpnNombre.setText("Nombre:");
		getContentPane().add(txtpnNombre);
		
		
		txtpnApellido = new JLabel();
		txtpnApellido.setBounds(74, 128, 89, 20);
		txtpnApellido.setText("Apellido:");
		getContentPane().add(txtpnApellido);
		
		
		txtpnContraseña = new JLabel();
		txtpnContraseña.setBounds(560, 101, 89, 20);
		txtpnContraseña.setText("Contrase\u00F1a:");
		getContentPane().add(txtpnContraseña);
		
		
		txtpnFechaDeNacimiento = new JLabel();
		txtpnFechaDeNacimiento.setBounds(74, 190, 106, 20);
		txtpnFechaDeNacimiento.setText("DNI:");
		getContentPane().add(txtpnFechaDeNacimiento);
		
		
		JButton btnNewButton = new JButton("Registrarse");
		btnNewButton.setBounds(524, 349, 129, 44);
		getContentPane().add(btnNewButton);
		
		JLabel lblTelefono = new JLabel();
		lblTelefono.setText("Telefono:");
		lblTelefono.setBounds(74, 221, 89, 20);
		getContentPane().add(lblTelefono);
		
		textDNI = new JTextField();
		textDNI.setHorizontalAlignment(SwingConstants.CENTER);
		textDNI.setColumns(10);
		textDNI.setBounds(142, 190, 185, 20);
		getContentPane().add(textDNI);
		
		textTelefono = new JTextField();
		textTelefono.setHorizontalAlignment(SwingConstants.CENTER);
		textTelefono.setColumns(10);
		textTelefono.setBounds(142, 221, 185, 20);
		getContentPane().add(textTelefono);
		
		textDireccion = new JTextField();
		textDireccion.setHorizontalAlignment(SwingConstants.CENTER);
		textDireccion.setBounds(142, 252, 185, 20);
		getContentPane().add(textDireccion);
		textDireccion.setColumns(10);
		
		JLabel lblDireccin = new JLabel();
		lblDireccin.setText("Direcci\u00F3n:");
		lblDireccin.setBounds(74, 252, 89, 20);
		getContentPane().add(lblDireccin);
		
		textPoblacion = new JTextField();
		textPoblacion.setHorizontalAlignment(SwingConstants.CENTER);
		textPoblacion.setColumns(10);
		textPoblacion.setBounds(142, 283, 185, 20);
		getContentPane().add(textPoblacion);
		
		textCodigoPostal = new JTextField();
		textCodigoPostal.setHorizontalAlignment(SwingConstants.CENTER);
		textCodigoPostal.setColumns(10);
		textCodigoPostal.setBounds(142, 314, 185, 20);
		getContentPane().add(textCodigoPostal);
		
		textPais = new JTextField();
		textPais.setHorizontalAlignment(SwingConstants.CENTER);
		textPais.setColumns(10);
		textPais.setBounds(142, 346, 185, 20);
		getContentPane().add(textPais);
		
		
		JLabel tarjetascred = new JLabel();
		tarjetascred.setIcon(new ImageIcon(this.getClass().getResource("/imgs/tarjetas.png")));
		tarjetascred.setBounds(472, 203, 120, 104);
		getContentPane().add(tarjetascred);
		
		JLabel Campos = new JLabel();
		Campos.setIcon(new ImageIcon(this.getClass().getResource("/imgs/modificar.png")));
		Campos.setBounds(318, 92, 120, 104);
		getContentPane().add(Campos);
		
		JLabel lblPoblacin = new JLabel();
		lblPoblacin.setText("Poblaci\u00F3n:");
		lblPoblacin.setBounds(74, 283, 89, 20);
		getContentPane().add(lblPoblacin);
		
		JLabel lblCdigoPostal = new JLabel();
		lblCdigoPostal.setText("C.Postal:");
		lblCdigoPostal.setBounds(74, 317, 89, 20);
		getContentPane().add(lblCdigoPostal);
		
		JLabel lblPas = new JLabel();
		lblPas.setText("Pa\u00EDs:");
		lblPas.setBounds(74, 349, 89, 20);
		getContentPane().add(lblPas);
		
		textNUsuario = new JTextField();
		textNUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		textNUsuario.setColumns(10);
		textNUsuario.setBounds(643, 70, 147, 20);
		getContentPane().add(textNUsuario);
		
		JLabel lblNombreDeUsuario = new JLabel();
		lblNombreDeUsuario.setText("Usuario:");
		lblNombreDeUsuario.setBounds(560, 70, 80, 20);
		getContentPane().add(lblNombreDeUsuario);
		//Fin modificar icono ventana
		
		JLabel iniciase = new JLabel();
		iniciase.setIcon(new ImageIcon(this.getClass().getResource("/imgs/fotoperfildefault.png")));
		iniciase.setBounds(472, 45, 120, 104);
		getContentPane().add(iniciase);
		
		textNTarjeta = new JTextField();
		textNTarjeta.setHorizontalAlignment(SwingConstants.CENTER);
		textNTarjeta.setColumns(10);
		textNTarjeta.setBounds(684, 191, 168, 20);
		getContentPane().add(textNTarjeta);
		
		textFCaducidad = new JTextField();
		textFCaducidad.setHorizontalAlignment(SwingConstants.CENTER);
		textFCaducidad.setColumns(10);
		textFCaducidad.setBounds(684, 222, 168, 20);
		getContentPane().add(textFCaducidad);
		
		textCSeguridad = new JTextField();
		textCSeguridad.setHorizontalAlignment(SwingConstants.CENTER);
		textCSeguridad.setColumns(10);
		textCSeguridad.setBounds(684, 253, 168, 20);
		getContentPane().add(textCSeguridad);
		
		panel = new JPanel();
		panel.setBounds(51, 80, 307, 313);
		panel.setBackground(SystemColor.inactiveCaptionBorder);
		getContentPane().add(panel);
		
		textTTarjeta = new JTextField();
		textTTarjeta.setHorizontalAlignment(SwingConstants.CENTER);
		textTTarjeta.setColumns(10);
		textTTarjeta.setBounds(684, 287, 168, 20);
		getContentPane().add(textTTarjeta);
		
		JLabel lblNmeroDeLa = new JLabel();
		lblNmeroDeLa.setText("N\u00BA Tarjeta:");
		lblNmeroDeLa.setBounds(560, 190, 147, 20);
		getContentPane().add(lblNmeroDeLa);
		
	
		JLabel lblFechaDeCaducidad = new JLabel();
		lblFechaDeCaducidad.setText("Fecha de caducidad:");
		lblFechaDeCaducidad.setBounds(560, 221, 147, 20);
		getContentPane().add(lblFechaDeCaducidad);
		
		JLabel lblCdigoDeSeguridad = new JLabel();
		lblCdigoDeSeguridad.setText("C\u00F3digo de seguridad:");
		lblCdigoDeSeguridad.setBounds(560, 252, 147, 20);
		getContentPane().add(lblCdigoDeSeguridad);
		
		JLabel lblTipoDeTarjeta = new JLabel();
		lblTipoDeTarjeta.setText("Tipo de tarjeta:");
		lblTipoDeTarjeta.setBounds(560, 283, 147, 20);
		getContentPane().add(lblTipoDeTarjeta);
		
		panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.inactiveCaptionBorder);
		panel_1.setBounds(525, 53, 299, 96);
		getContentPane().add(panel_1);
		
		panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.inactiveCaptionBorder);
		panel_2.setBounds(524, 171, 356, 156);
		getContentPane().add(panel_2);
		
		lblBienvenidoAEventall = new JLabel("Bienvenido a Event4all, la gran ventaja de registrarse ");
		lblBienvenidoAEventall.setBounds(51, 26, 343, 14);
		getContentPane().add(lblBienvenidoAEventall);
		
		lblNewLabel = new JLabel("es que obtendras puntos canjeables por entradas.");
		lblNewLabel.setBounds(51, 44, 343, 14);
		getContentPane().add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				interfazregistro.dispose();
				frmInicio.setVisible(true);
			}
		});
		lblNewLabel_1.setIcon(new ImageIcon(InterfazRegistro.class.getResource("/imgs/atras2.png")));
		lblNewLabel_1.setBounds(51, 392, 60, 50);
		getContentPane().add(lblNewLabel_1);
		
		//Fondo pantalla en un Jlabel o una imagen
		JLabel lblFondo = new JLabel();
		lblFondo.setIcon(new ImageIcon(this.getClass().getResource("/imgs/wallpaper.jpg")));
		lblFondo.setBounds(0, 0, 924, 450);
		getContentPane().add(lblFondo);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)	{
		
				String strtextAddress = txtEmailAddress.getText();
				String strtextName = txtName.getText();
				String strtextSurname = txtSurname.getText();
				String strtextPassword= txtPassword.getText();
				String strtextDNI = textDNI.getText();
				String strtextTelefono = textTelefono.getText();
				String strtextDireccion = textDireccion.getText();
				String strtextPoblacion= textPoblacion.getText();
				String strtextCP = textCodigoPostal.getText();
				String strtextPais = textPais.getText();
				String strtextNUsuario = textNUsuario.getText();
				String strtextNTarjeta = textNTarjeta.getText();
				String strtextCSeguridad = textCSeguridad.getText();
				String strtextFCaducidad = textFCaducidad.getText();
				String strtextTTarjeta = textTTarjeta.getText();
		
				MaquinaGestora mq = new MaquinaGestora();
				//mq1.darAltaUsuario(strtextName,strtextDNI,strtextSurname,strtextAddress,strtextPassword,Integer.parseInt(strtextTelefono));
				mq.altaCliente(strtextDNI,strtextNUsuario,strtextName,strtextSurname,strtextAddress,strtextPassword,strtextTelefono,0,strtextDireccion,strtextPoblacion, Integer.parseInt(strtextCP),strtextPais,strtextNTarjeta, strtextFCaducidad, Integer.parseInt(strtextCSeguridad),strtextTTarjeta);
				//JOptionPane.showMessageDialog(null,"Te has registrado correctamente");
		
			}
		
		});
		
		
		//modificar icono ventana
		URL iconURL = getClass().getResource("/imgs/logotype.png");
		// iconURL is null when not found
		ImageIcon icon = new ImageIcon(iconURL);
		setIconImage(icon.getImage());
	}
	
	public JFrame getFrame(){
		return interfazregistro;
	}
}






