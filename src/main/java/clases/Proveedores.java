package clases;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import exceptions.NoDataException;
/**
 * 
 * @author Alejandro Tubío
 * clase que representa a los proveedores
 */
public class Proveedores {
	private int id_proveedor;
	private String nombre;
	private String fecha_alta;
	private int id_cliente;
	private static ArrayList<Proveedores> misProveedores;
	
	/**
	 * parámetros de la base de datos
	 * @param id_proveedor
	 * @param nombre
	 * @param fecha_alta
	 * @param id_cliente
	 */

	public Proveedores(int id_proveedor, String nombre, String fecha_alta, int id_cliente){
		super();
		this.id_proveedor = id_proveedor;
		this.nombre = nombre;
		this.fecha_alta = fecha_alta;
		this.id_cliente = id_cliente;
	}

	public int getId_proveedor() {
		return id_proveedor;
	}

	public void setId_proveedor(int id_proveedor) {
		this.id_proveedor = id_proveedor;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFecha_alta() {
		return fecha_alta;
	}

	public void setFecha_alta(String fecha_alta) {
		this.fecha_alta = fecha_alta;
	}

	public int getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}
	
	public static ArrayList<Proveedores> getMisProveedores() {
		return misProveedores;
	}

	public static void setMisProveedores(ArrayList<Proveedores> misProveedores) {
		Proveedores.misProveedores = misProveedores;
	}

	@Override
	public String toString() {
		return "Proveedores [id_proveedor=" + id_proveedor + ", nombre=" + nombre + ", fecha_alta=" + fecha_alta
				+ ", id_cliente=" + id_cliente + "]";
	}
	/**
	 * consulta una base de datos de proveedores y guarda la información en archivos JSON y de texto plano.
	 * 
	 * exceptions
	 * @throws IOException
	 * @throws SQLException
	 * @throws NoDataException
	 */
	public static void getTodos() throws IOException, SQLException, NoDataException {
		FileWriter writerJson = new FileWriter("registro.json");
		FileWriter writerTxt = new FileWriter("registro.txt");
		BufferedReader readerTxt = new BufferedReader(new FileReader("registro.txt"));
		String stuffToWrite;
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		misProveedores = new ArrayList<Proveedores>();
		boolean vacio = true;
		
		//conexión con la base de datos de proveedores
		Connection conexion = DriverManager.getConnection("jdbc:mysql://127.0.0.1/proveedores_bd", "root",
				"jfgUh39YGU");
		Statement smt = conexion.createStatement();
		
		//consulta a la base de datos
		ResultSet proveedoresResult = smt.executeQuery("select * from proveedores");
		
		//lista de objetos Proveedores a partir de los resultados de la consulta
		while (proveedoresResult.next()) {
			vacio = false;
			misProveedores.add(new Proveedores(proveedoresResult.getInt("id_proveedor"),
					proveedoresResult.getString("nombre"), formatter.format(proveedoresResult.getDate("fecha_alta")),
					proveedoresResult.getInt("id_cliente")));
		}
		
		//guarda la información en archivos de texto plano
		for (int i = 0; i < misProveedores.size(); i++) {
			stuffToWrite = misProveedores.toString();
			writerTxt.write(stuffToWrite);
		}
		
		//guarda la información en archivos JSON
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		if (!(gson.toJson(misProveedores).toString().equals("[]"))) {
			writerJson.write(gson.toJson(misProveedores));
		}

		smt.close();
		conexion.close();
		proveedoresResult.close();
		writerJson.close();
		writerTxt.close();
		
		//lanza una excepción NoDataException si no se encuentran datos en la base de datos de proveedores.
		if (vacio) {
			throw new NoDataException("El cliente no tiene proveedores asignados.");
		}
	}
}
