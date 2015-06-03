package proy;

import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;

public class MaquinaGestora {

	public MaquinaGestora() {
		System.out.println(Conexion.getInstance("localhost", "ventaentradas",
				"postgres", "tonphp").connect());
	}

	public boolean existeCliente(String dni, String n_usuario) {
		String dni_ = "";
		String n_usuario_ = "";
		boolean conclusion = false;

		try {
			Statement consulta = Conexion
					.getInstance("localhost", "ventaentradas", "postgres",
							"tonphp").getConection().createStatement();
			String query = "SELECT * FROM usuario  WHERE  n_usuario = '"
					+ n_usuario + "'  AND dni = '" + dni + "';";
			ResultSet resultado = consulta.executeQuery(query);

			while (resultado.next()) {
				dni_ = resultado.getString("dni");
				n_usuario_ = resultado.getString("n_usuario");
			}

		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "error");
		}

		if (dni_.equals(dni) && n_usuario_.equals(n_usuario)) {
			conclusion = true;
		}

		return conclusion;
	}

	public void altaCliente(String dni_, String n_usuario_, String nombre_,
			String apellidos_, String email_, String contrasenya_,
			String telefono_, Integer puntos_, String direccion_,
			String poblacion_, Integer cp_, String pais_, String tarjeta_,
			String caducidad_, Integer codigo_, String tipotarjeta_) {

		if (!this.existeCliente(dni_, n_usuario_)) {
			try {

				Statement consulta = Conexion
						.getInstance("localhost", "ventaentradas", "postgres",
								"tonphp").getConection().createStatement();
				String query = "insert into usuario (dni, n_usuario, nombre, apellidos, email, contraseña, telefono, puntos) "
						+ "values('"
						+ dni_
						+ "','"
						+ n_usuario_
						+ "','"
						+ nombre_
						+ "','"
						+ apellidos_
						+ "','"
						+ email_
						+ "','"
						+ contrasenya_
						+ "','"
						+ telefono_
						+ "','"
						+ puntos_
						+ "')";
				consulta.executeUpdate(query);
				String query1 = "insert into direccion_usuario(dni, direccion, poblacion, codigo_postal, pais) values('"
						+ dni_
						+ "','"
						+ direccion_
						+ "','"
						+ poblacion_
						+ "',"
						+ cp_ + ",'" + pais_ + "');";
				consulta.executeUpdate(query1);
				String query2 = "insert into datos_bancarios(num_tarjeta, dni_titular, fecha_caducidad , cod_seguridad, tipo_tarjeta) values('"
						+ tarjeta_
						+ "','"
						+ dni_
						+ "','"+caducidad_+"',"
						+ codigo_ + ",'" + tipotarjeta_ + "');";
				consulta.executeUpdate(query2);

			} catch (SQLException e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "error");
			}

		} else {
			JOptionPane.showMessageDialog(null,
					"Este cliente ya se encuentra registrado");
		}
	}

	public void bajaCliente(String n_usuario_) {
		String dni_="";
		Statement consulta;
		ResultSet user=null;
		try {
			consulta = Conexion
					.getInstance("localhost", "ventaentradas", "postgres",
							"tonphp").getConection().createStatement();
			user=consulta.executeQuery("select dni FROM usuario WHERE n_usuario = '"
					+ n_usuario_ + "';");
			while(user.next()){
				dni_ = user.getString("dni");
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		if (this.existeCliente(dni_, n_usuario_)) {
			System.out.println(n_usuario_);
			try {
				consulta = Conexion
						.getInstance("localhost", "ventaentradas", "postgres",
								"tonphp").getConection().createStatement();
				consulta.executeUpdate("DELETE FROM usuario WHERE dni = '"
						+ dni_ + "';");
				consulta.executeUpdate("DELETE FROM datos_bancarios  WHERE  dni_titular = '"
						+ dni_ + "';");
				consulta.executeUpdate("DELETE FROM direccion_usuario  WHERE  dni = '"
						+ dni_ + "';");
			} catch (SQLException e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "error");
			}

		} else {
			JOptionPane.showMessageDialog(null, "No se reconoce este usuario");
		}
	}

	public boolean existeEvento(String nombre_) {
		String nombre = "";
		boolean conclusion = false;

		try {
			Statement consulta = Conexion
					.getInstance("localhost", "ventaentradas", "postgres",
							"tonphp").getConection().createStatement();
			String query = "SELECT * FROM evento  WHERE  nombre = '" + nombre_
					+ "';";
			ResultSet resultado = consulta.executeQuery(query);

			while (resultado.next()) {
				nombre = resultado.getString("nombre");
			}

		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "error");
		}

		if (nombre_.equals(nombre)) {
			conclusion = true;
		}

		return conclusion;
	}

	public void altaEvento(String nombre_, String Direccion_,
			String poblacion_, String estado_, String fechahora_, String tipo_,
			String sala_, String asiento_, Integer nument_, String datos_,
			String Pais_, Integer Aforo_, String codigoPostal_,
			String NombreLugarEvento_, Integer precio_) {

		int idLugar = 0;

		if (!this.existeEvento(nombre_)) {
			try {

				Statement consulta = Conexion
						.getInstance("localhost", "ventaentradas", "postgres",
								"tonphp").getConection().createStatement();

				if (idLugar == 0) {

					consulta.executeUpdate("insert into lugar_evento (nombre, tipo, aforo, direccion, poblacion, codigo_postal, pais) values('"
							+ NombreLugarEvento_
							+ "','"
							+ tipo_
							+ "','"
							+ Aforo_
							+ "','"
							+ Direccion_
							+ "','"
							+ poblacion_
							+ "','" + codigoPostal_ + "','" + Pais_ + "')");

					ResultSet _lugar = consulta
							.executeQuery("select id from lugar_evento where nombre ='"
									+ NombreLugarEvento_
									+ "' and codigo_postal= '"
									+ codigoPostal_
									+ "';");
					while (_lugar.next()) {

						idLugar = _lugar.getInt("id");

					}

				} else {
					ResultSet Lugar = consulta
							.executeQuery("select id from lugar_evento where nombre ='"
									+ NombreLugarEvento_
									+ "' and codigo_postal= '"
									+ codigoPostal_
									+ "';");
					while (Lugar.next()) {

						idLugar = Lugar.getInt("id");

						System.out.println(idLugar);
					}
				}

				String query = "INSERT INTO evento (nombre, estado, fecha_hora, sala, asiento, datos, num_entradas_disponibles, precio, id_lugar_evento) VALUES ('"
						+ nombre_
						+ "','"
						+ estado_
						+ "','"
						+ fechahora_
						+ "','"
						+ sala_
						+ "','"
						+ asiento_
						+ "','"
						+ datos_
						+ "'," + nument_ + "," + precio_ + "," + idLugar + ");";
				consulta.executeUpdate(query);

			} catch (SQLException e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "error");
			}

		} else {
			JOptionPane.showMessageDialog(null,
					"Este evento ya se encuentra registrado");
		}
	}

	public void bajaEvento(String nombre_) {
		if (this.existeEvento(nombre_)) {
			try {
				Statement consulta = Conexion
						.getInstance("localhost", "ventaentradas", "postgres",
								"tonphp").getConection().createStatement();
				consulta.executeUpdate("DELETE FROM evento  WHERE  nombre = '"
						+ nombre_ + "';");
			} catch (SQLException e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "error");
			}

		} else {
			JOptionPane.showMessageDialog(null, "No se reconoce este evento");
		}
	}

	public void comprarEvento(String num_tarjeta, String nombre, Integer id_evento,
			Integer cantidad, double importe) {
		String nombreEvento = "";
		try {
			Statement consulta = Conexion
					.getInstance("localhost", "ventaentradas", "postgres",
							"tonphp").getConection().createStatement();
			ResultSet nomEvento = consulta
					.executeQuery("Select nombre from evento where id='"
							+ id_evento + "'");

			while (nomEvento.next()) {
				nombreEvento = nomEvento.getString("nombre");
			}

			if (this.existeEvento(nombreEvento)) {

				consulta = Conexion
						.getInstance("localhost", "ventaentradas", "postgres",
								"tonphp").getConection().createStatement();
				consulta.executeUpdate("INSERT INTO detalles_compra (num_tarjeta, id_evento, cantidad, importe, fecha_hora) VALUES ('"
						+ num_tarjeta
						+ "',"
						+ id_evento
						+ ", "
						+ cantidad
						+ "," + importe + ",now());");

			} else {

			}
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "error");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		this.generarPersona(num_tarjeta, id_evento);
	}

	public TableModel getCompras(String n_usuario) {

		ResultSet compras = null;
		String tarj = "";
		TableModel tm = null;

		try {
			Statement consulta = Conexion
					.getInstance("localhost", "ventaentradas", "postgres",
							"tonphp").getConection().createStatement();
			ResultSet tarjeta = consulta
					.executeQuery("SELECT num_tarjeta from datos_bancarios where dni_titular=( SELECT dni FROM usuario WHERE n_usuario =('"
							+ n_usuario + "'))");
			while (tarjeta.next()) {
				tarj = tarjeta.getString("num_tarjeta");
			}
			compras = consulta
					.executeQuery("select nombre, estado, evento.fecha_hora, sala, asiento, datos, num_entradas_disponibles, precio, cantidad, importe from evento, detalles_compra WHERE evento.id=detalles_compra.id_evento AND detalles_compra.num_tarjeta like '"
							+ tarj + "';");
			tm = DbUtils.resultSetToTableModel(compras);
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "error");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return tm;
	}

	public TableModel buscarEventosActivos() {
		ResultSet rs = null;
		TableModel tm = null;

		try {

			Statement consulta = Conexion
					.getInstance("localhost", "ventaentradas", "postgres",
							"tonphp").getConection().createStatement();
			rs = consulta
					.executeQuery("SELECT * FROM evento  WHERE  estado='activo'");
			tm = DbUtils.resultSetToTableModel(rs);

			if (rs != null) {

			} else {

			}

		} catch (Exception e) {

			System.out.println(e.toString());

		}
		return tm;

	}

	public TableModel buscarEvento(String nombre) {
		ResultSet rs = null;
		TableModel tm = null;

		try {

			Statement consulta = Conexion
					.getInstance("localhost", "ventaentradas", "postgres",
							"tonphp").getConection().createStatement();
			rs = consulta.executeQuery("SELECT * FROM evento  WHERE  nombre='"
					+ nombre + "'");
			tm = DbUtils.resultSetToTableModel(rs);

			if (rs != null) {

			} else {

			}

		} catch (Exception e) {

			System.out.println(e.toString());

		}
		return tm;

	}
	
	private Persona generarPersona(String numTarjeta, Integer idEvento){
		String dni="";
		String n_usuario="";
		String nombre="";
		String apellidos="";
		Integer id_lugar_evento=0;
		String nombre_evento="";
		String fecha_evento="";
		String sala="";
		String asiento="";
		int id_evento=0;
		int precio=0;
		int id_compra=0;
		String direccion="";
		String poblacion="";
		String pais="";
		
		try {
			Statement consulta = Conexion
					.getInstance("localhost", "ventaentradas", "postgres",
							"tonphp").getConection().createStatement();
			
			ResultSet usuario = consulta
					.executeQuery("SELECT dni, n_usuario, nombre, apellidos FROM usuario WHERE dni = (SELECT dni_titular from datos_bancarios where num_tarjeta='"
							+ numTarjeta + "')");
			while (usuario.next()) {
				dni = usuario.getString("dni");
				n_usuario = usuario.getString("n_usuario");
				nombre = usuario.getString("nombre");
				apellidos = usuario.getString("apellidos");
			}
			
			ResultSet evento = consulta
					.executeQuery("select evento.id, nombre, evento.fecha_hora, sala, asiento, precio, id_lugar_evento from evento, detalles_compra WHERE evento.id=detalles_compra.id_evento AND detalles_compra.num_tarjeta like '"
							+ numTarjeta + "';");
			while (evento.next()) {
				id_evento=evento.getInt("id");
				nombre_evento=evento.getString("nombre");
				fecha_evento=evento.getString("fecha_hora");
				sala=evento.getString("sala");
				asiento=evento.getString("asiento");
				precio=evento.getInt("precio");
				id_lugar_evento=evento.getInt("id_lugar_evento");
			}
			
			ResultSet compra = consulta
					.executeQuery("select id from detalles_compra WHERE id="+id_evento+" AND num_tarjeta= '"
							+ numTarjeta + "';");
			while (compra.next()) {			
				id_compra=compra.getInt("id");
			}
			
			ResultSet lugar = consulta
					.executeQuery("select direccion, poblacion, pais from lugar_evento, evento WHERE evento.id="+id_lugar_evento+ ";");
			while (lugar.next()) {
				direccion=lugar.getString("direccion");
				poblacion=lugar.getString("poblacion");
				pais=lugar.getString("pais");
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "error");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	Persona persona=new Persona(id_compra, dni, nombre, apellidos, numTarjeta, nombre_evento, direccion, poblacion, pais, sala, asiento, precio);
	
		return persona;
	}
	
	

}
