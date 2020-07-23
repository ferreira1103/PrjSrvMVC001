package br.com.teste.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {

private static Connection connection = null;

public static Connection getConnection() throws SQLException {

	System.out.println(":: Teste de 1 conexão: " + connection);

	if (connection == null)
		try {

			String Usuario = "root";
			String Senha = "2209caish";

			String Driver = "com.mysql.jdbc.Driver";
			Class.forName(Driver);

			System.out.println(":: Teste de Driver: " + Driver);

			String Url = "jdbc:mysql://localhost/universidade?characterEncoding=latin1&useConfigs=maxPerformance";
			connection = DriverManager.getConnection(Url, Usuario, Senha);

			System.out.println(":: (try) Teste de 2 conexão: " + connection);

//			return connection;

		} catch (ClassNotFoundException e) {

			System.out.println(":: (catch) Teste de 3 conexão: " + connection);
			
			e.printStackTrace();

			throw new SQLException(e.getException());
		}
	
	System.out.print("\n :: Conexão fechada? [DAO] " + connection.isClosed());
	
	return connection;
	
	}
}
