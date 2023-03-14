package clases;

import java.io.IOException;
import java.sql.SQLException;

import exceptions.NoDataException;

public class Main {
	/**
	 * Se intenta obtener un argumento de línea de comandos, que debe ser un valor numérico. Si el argumento es "1", se llama al método estático getTodos() de la clase Proveedores
	 * @param args
	 */
	public static void main(String[] args) {

		try {
			if (args[0].toString().equals("1")) {
				Proveedores.getTodos();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NoDataException e) {
			e.printStackTrace();
		}
	}
}
