package proy;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.ScrollPane;
import java.beans.Statement;
import java.net.URL;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTable;
import javax.swing.JScrollPane;

import net.proteanit.sql.DbUtils;

import javax.swing.ImageIcon;

import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;

public class InterfazBuscarEvento {

	private JFrame frmEventallBuscar;
	private JTextField eventoSolicitado;
	private JTable table;
	private JTextField txtSeparator;
	private JTextField numEntradasComprar;
	private JTextField txtPreciomuestraentrada;
	private JTextField PrecioFinalComprarYa;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazBuscarEvento window = new InterfazBuscarEvento();
					window.frmEventallBuscar.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public InterfazBuscarEvento() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEventallBuscar = new JFrame();
		frmEventallBuscar.setResizable(false);
		frmEventallBuscar.setTitle("Event4All - Buscar eventos");
		frmEventallBuscar.setBounds(100, 100, 930, 470);
		frmEventallBuscar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEventallBuscar.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Comprar entradas");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JLabel lblHola = new JLabel("\u20AC/unid.");
		lblHola.setFont(new Font("Tahoma", Font.PLAIN, 29));
		lblHola.setBounds(786, 49, 114, 57);
		frmEventallBuscar.getContentPane().add(lblHola);
		
		JLabel lblEntradasDeseaY = new JLabel("entradas desea");
		lblEntradasDeseaY.setBounds(661, 161, 219, 14);
		frmEventallBuscar.getContentPane().add(lblEntradasDeseaY);
		
		JLabel PrecioTextFinal = new JLabel("Precio final: ");
		PrecioTextFinal.setBounds(677, 231, 75, 23);
		frmEventallBuscar.getContentPane().add(PrecioTextFinal);
		
		PrecioFinalComprarYa = new JTextField();
		PrecioFinalComprarYa.setEditable(false);
		PrecioFinalComprarYa.setText("0");
		PrecioFinalComprarYa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		PrecioFinalComprarYa.setColumns(10);
		PrecioFinalComprarYa.setBounds(749, 229, 54, 20);
		frmEventallBuscar.getContentPane().add(PrecioFinalComprarYa);
		
		
		
		
		txtPreciomuestraentrada = new JTextField();
		txtPreciomuestraentrada.setEditable(false);
		txtPreciomuestraentrada.setFont(new Font("Tahoma", Font.PLAIN, 27));
		txtPreciomuestraentrada.setBounds(699, 49, 80, 57);
		frmEventallBuscar.getContentPane().add(txtPreciomuestraentrada);
		txtPreciomuestraentrada.setColumns(10);
	    
		
		
		
		numEntradasComprar = new JTextField();
		numEntradasComprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				float txtPreciomuestraentrada_ = Float.parseFloat(txtPreciomuestraentrada.getText());
				float numEntradasComprar_ = Float.parseFloat(numEntradasComprar.getText());
				
				float preciofinalentradas = txtPreciomuestraentrada_*numEntradasComprar_;
				//Float.toString(float)
				String preciofinalentradastxt =String.valueOf(preciofinalentradas);
				PrecioFinalComprarYa.setText(preciofinalentradastxt);
				
			}
		});
		
		JLabel label = new JLabel("\u20AC");
		label.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label.setBounds(805, 230, 114, 23);
		frmEventallBuscar.getContentPane().add(label);
		
		numEntradasComprar.setBounds(749, 198, 40, 20);
		numEntradasComprar.setText("1");
		frmEventallBuscar.getContentPane().add(numEntradasComprar);
		numEntradasComprar.setColumns(10);
		
		JLabel lblNEntradas = new JLabel("N\u00BA entradas: ");
		lblNEntradas.setBounds(677, 197, 75, 23);
		frmEventallBuscar.getContentPane().add(lblNEntradas);
		btnNewButton.setBounds(699, 284, 151, 39);
		frmEventallBuscar.getContentPane().add(btnNewButton);
		
		JLabel lblEligaEl = new JLabel("Eliga el evento al que desee asistir, cuantas ");
		lblEligaEl.setBounds(661, 135, 258, 34);
		frmEventallBuscar.getContentPane().add(lblEligaEl);
		
		txtSeparator = new JTextField();
		txtSeparator.setBounds(623, 11, 8, 410);
		frmEventallBuscar.getContentPane().add(txtSeparator);
		txtSeparator.setColumns(10);
		
		JLabel lblBuscarEvento = new JLabel("Buscar evento: ");
		lblBuscarEvento.setBounds(26, 35, 114, 14);
		frmEventallBuscar.getContentPane().add(lblBuscarEvento);
		
		eventoSolicitado = new JTextField();
		eventoSolicitado.setHorizontalAlignment(SwingConstants.CENTER);
		eventoSolicitado.setBounds(125, 32, 206, 20);
		frmEventallBuscar.getContentPane().add(eventoSolicitado);
		eventoSolicitado.setColumns(10);
		
		JButton btnBuscarEventosDisponibles = new JButton("Eventos disponibles");
		btnBuscarEventosDisponibles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			///////BuscarEventoActivo);
					MaquinaGestora ClickEventosActivos = new MaquinaGestora();
					TableModel tm = ClickEventosActivos.buscarEventosActivos();
					
					if(tm!=null){
					//Mostrar en la tabla los resultados de los eventos activos
					table.setModel(tm);
					}
					
				////
			}
		});
		
		//imagen en Jbutton
		btnBuscarEventosDisponibles.setBounds(462, 48, 151, 34);
		frmEventallBuscar.getContentPane().add(btnBuscarEventosDisponibles);
		
		JButton btnBuscar = new JButton();
		btnBuscar.setIcon(new ImageIcon(this.getClass().getResource("/imgs/searchicon.PNG")));
		btnBuscar.setBorder(null);
		btnBuscar.setOpaque(false);
		btnBuscar.setContentAreaFilled(false);
		btnBuscar.setBorderPainted(false);
		//
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			//////	Mostrar en la tabla los resultados del evento buscado
				MaquinaGestora EventoBuscado = new MaquinaGestora();
				String eventoSolicitado_ = eventoSolicitado.getText();
				
				TableModel tm = EventoBuscado.buscarEvento(eventoSolicitado_);

					//Mostrar en la tabla los resultados del evento buscado
					table.setModel(tm);
					
			}
		});
		btnBuscar.setBounds(341, 11, 75, 57);
		frmEventallBuscar.getContentPane().add(btnBuscar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 93, 587, 328);
		frmEventallBuscar.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
	        public void valueChanged(ListSelectionEvent event) {
	            // do some actions here, for example
	            // print first column value from selected row
	            //System.out.println(table.getValueAt(table.getSelectedRow(), 0).toString());
	        	//Selecciona el valor de la fila, columna 9
				Integer price = (Integer) table.getValueAt(table.getSelectedRow(), 8);
					txtPreciomuestraentrada.setText(Integer.toString(price.intValue()));
					
					float preciofinalentradas = 0;
					float txtPreciomuestraentrada_ =0;
					float numEntradasComprar_ =0;
					
					//jtextfield to float
					txtPreciomuestraentrada_ = Float.parseFloat(txtPreciomuestraentrada.getText());
					numEntradasComprar_ = Float.parseFloat(numEntradasComprar.getText());
					
					preciofinalentradas = txtPreciomuestraentrada_*numEntradasComprar_;
					//Float.toString(float)
					String preciofinalentradastxt =String.valueOf(preciofinalentradas);
					PrecioFinalComprarYa.setText(preciofinalentradastxt);
					
	        }
	    });
		
		
		//Fondo pantalla en un Jlabel o una imagen
		JLabel lblFondo = new JLabel();
		lblFondo.setIcon(new ImageIcon(this.getClass().getResource("/imgs/wallpaper.jpg")));
		lblFondo.setBounds(0, 0, 924, 442);
		frmEventallBuscar.getContentPane().add(lblFondo);
		//Fin Fondo pantalla
		
		//modificar icono ventana
		URL iconURL = getClass().getResource("/imgs/logotype.png");
		// iconURL is null when not found
		ImageIcon icon = new ImageIcon(iconURL);
		frmEventallBuscar.setIconImage(icon.getImage());
		//Fin modificar icono ventana
		
		
		
	}
}



