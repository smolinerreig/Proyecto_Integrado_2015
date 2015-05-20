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
				String query2 = "insert into datos_bancarios(num_tarjeta, dni_titular, fecha_caducidad, cod_seguridad, tipo_tarjeta) values('"
						+ tarjeta_
						+ "','"
						+ dni_
						+ "','"
						+ caducidad_
						+ "',"
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

	public void bajaCliente(String dni_, String n_usuario_) {
		if (this.existeCliente(dni_, n_usuario_)) {
			try {
				Statement consulta = Conexion
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

	public void altaEvento(String nombre_, String estado_, String fechahora_,
			String sala_, String asiento_, String datos_, Integer nument_,
			Integer precio_, String NombreLugarEvento_, String tipo_,
			Integer Aforo_, String Direccion_, String poblacion_,
			Integer codigoPostal_, String Pais_) {
		Integer idLugar = 0;

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

						System.out.println(idLugar);
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

	public void comprarEvento(String num_tarjeta, Integer id_evento,
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

			if (!this.existeEvento(nombreEvento)) {

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
	}

	public ResultSet getCompras(String n_usuario) {

		ResultSet compras = null;
		String tarj="";

		try {
			Statement consulta = Conexion
					.getInstance("localhost", "ventaentradas", "postgres",
							"tonphp").getConection().createStatement();
			ResultSet tarjeta = consulta
					.executeQuery("SELECT num_tarjeta from datos_bancarios where dni_titular=( SELECT dni FROM usuario WHERE n_usuario =('"
							+ n_usuario + "'))");
			while(tarjeta.next()){
				tarj = tarjeta.getString("num_tarjeta");
			}
			compras = consulta
					.executeQuery("select nombre, estado, evento.fecha_hora, sala, asiento, datos, num_entradas_disponibles, precio, cantidad, importe from evento, detalles_compra WHERE evento.id=detalles_compra.id_evento AND detalles_compra.num_tarjeta like '"
							+ tarj + "';");
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "error");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return compras;
	}

	public TableModel buscarEventosActivos() {
		ResultSet rs = null;
		TableModel tm=null;

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
			tm=DbUtils.resultSetToTableModel(rs);

			if (rs != null) {

			} else {

			}

		} catch (Exception e) {

			System.out.println(e.toString());

		}
		return tm;

	}

}
