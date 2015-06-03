package Interfaces;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;

public class VentanaLoginGestor {

	private JFrame frmLoginGestor;
	private JTextField textUser;
	private JTextField textContraseña;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaLoginGestor window = new VentanaLoginGestor();
					window.frmLoginGestor.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaLoginGestor() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLoginGestor = new JFrame();
		frmLoginGestor.setBounds(100, 100, 400, 250);
		frmLoginGestor.setResizable(false);
		frmLoginGestor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLoginGestor.getContentPane().setLayout(null);
		frmLoginGestor.setTitle("Gestor");
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.setBounds(141, 173, 76, 23);
		frmLoginGestor.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
		
		String strUsuario = textUser.getText();
		String strPassword = textContraseña.getText();
		
		if(InicioSesion(strUsuario,strPassword)==true){  
			try {
				
				InterfazAltasBajasEventos window = new InterfazAltasBajasEventos (frmLoginGestor);
				window.getFrameAltasBajasEventos().setVisible(true);
				frmLoginGestor.setVisible(false);
				} catch (Exception e1) {
					e1.printStackTrace();
			
			}
			try {
				strPassword = hash(textContraseña.getText());
			} catch (Exception e2) {
			
				e2.printStackTrace();
			}
			
			
		}
		
		
		
			}
		});
		
		
		textUser = new JTextField();
		textUser.setBounds(141, 11, 136, 20);
		frmLoginGestor.getContentPane().add(textUser);
		textUser.setColumns(10);
		
		textContraseña = new JTextField();
		textContraseña.setColumns(10);
		textContraseña.setBounds(141, 91, 136, 20);
		frmLoginGestor.getContentPane().add(textContraseña);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(25, 14, 68, 14);
		frmLoginGestor.getContentPane().add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setBounds(25, 94, 76, 14);
		frmLoginGestor.getContentPane().add(lblContrasea);
		
		//Fondo pantalla en un Jlabel o una imagen
		JLabel lblFondo = new JLabel();
		lblFondo.setIcon(new ImageIcon(this.getClass().getResource("/imgs/wallpaper.jpg")));
		lblFondo.setBounds(0, 0, 924, 442);
		frmLoginGestor.getContentPane().add(lblFondo);
		//Fin Fondo pantalla
		
		
		
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
            ResultSet resultado= consulta.executeQuery("SELECT n_usuario, contraseña FROM gestor  WHERE  n_usuario = '"+n_usuario+"'  AND contraseña = '"+contraseña+"';");
            
            
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
}
