package proy;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


public class Conexion {
	// DATOS DE LA CONEXION
	static final String CONTROLADOR= "org.postgresql.Driver";
	
	//DATOS DE LA BBDD
	private String host;
	private String bbdd;
	private String user;
	private String pass;
	private String url;
	
	//Conexion
	private Connection conexion = null;// maneja la conexió
	
	//Instancia unica
	private static Conexion instance = null;
	
	private Conexion(String HOST,String BBDD,String USER,String PASS) {
		this.host=HOST;
		this.bbdd=BBDD;
		this.user=USER;
		this.pass=PASS;
		this.url="jdbc:postgresql://"+this.host+"/"+this.bbdd;
	}
	
	//Implementar SingleTon
	public static Conexion getInstance(String HOST,String BBDD,String USER,String PASS) {
	      if(instance == null) {
	         instance = new Conexion(HOST,BBDD,USER,PASS);
	      }
	      return instance;
	   }
	
	public boolean connect(){
		try{
			
			Class.forName(CONTROLADOR);
			
			conexion = DriverManager.getConnection(this.url,this.user,this.pass);
		}
		catch( SQLException excepcionSql ) 
		{
			excepcionSql.printStackTrace();
			return false;
		}
		catch( ClassNotFoundException noEncontroClase)
		{
			noEncontroClase.printStackTrace();
			return false;
		}
		return true;
	}
	
	public Connection getConection(){
		return this.conexion;
	}
	
}