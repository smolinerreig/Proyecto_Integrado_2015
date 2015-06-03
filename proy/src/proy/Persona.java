package proy;

import java.io.Serializable;


public class Persona implements Serializable {

	private int idticket;
	private String dni;
	private String nombre = null;
	private String apellidos;
	private String numtarjeta;
	private String nombreevento;
	private String direccionevento;
	private String poblacion;
	private String pais;
	private String sala;
	private String asiento;
	private int precio; 
	
	public Persona(){
		
	}
	
	public Persona(int idticket_, String dni_, String nombre_, String apellidos_, String numtarjeta_, String nombreevento_, String direccionevento_, String poblacion_, String pais_, String sala_, String asiento_,int precio_){
		idticket=idticket_;
		nombre = nombre_;
		apellidos = apellidos_;
		numtarjeta=numtarjeta_;
		nombreevento = nombreevento_;
		direccionevento = direccionevento_;
		poblacion = poblacion_;
		pais = pais_;
		sala = sala_;
		asiento=asiento_;
		precio = precio_;
	}

	
	public int getIdticket() {
		return idticket;
	}

	public void setIdticket(int idticket) {
		this.idticket = idticket;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getNumtarjeta() {
		return numtarjeta;
	}

	public void setNumtarjeta(String numtarjeta) {
		this.numtarjeta = numtarjeta;
	}

	public String getNombreevento() {
		return nombreevento;
	}

	public void setNombreevento(String nombreevento) {
		this.nombreevento = nombreevento;
	}

	public String getDireccionevento() {
		return direccionevento;
	}

	public void setDireccionevento(String direccionevento) {
		this.direccionevento = direccionevento;
	}

	public String getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getSala() {
		return sala;
	}

	public void setSala(String sala) {
		this.sala = sala;
	}

	public String getAsiento() {
		return asiento;
	}

	public void setAsiento(String asiento) {
		this.asiento = asiento;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}
	
	
	
}


