package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaDeConexao {

	public static Connection getConexao() {
		try {
			String url = "jdbc:mysql://localhost/curso_java?verifyServerCertificate=false&useSSL=true";
			String usuario = "root";
			String senha = "1234567";
			
			return DriverManager.getConnection(url, usuario, senha);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
