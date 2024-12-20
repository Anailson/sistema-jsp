package connection;

import java.sql.Connection;
import java.sql.DriverManager;

/*
 * Classe respons�vel pela conex�o do banco
 */

public class SingleConnectionBanco {
	
	private static String banco = "jdbc:postgresql://localhost:5432/curso-jsp?autoReconnect=true";//autoReconnect=true caso a conex�o caia. O BD sobe o conex�o
	private static String user = "postgres";
	private static String senha = "admin";
	private static Connection connection = null;
	
	public static Connection getConnection() {
		return connection;
	}
	
	static {
		conectar();
	}
	
	public SingleConnectionBanco() {/*Quando tiver uma inst�ncia vai conectar*/
		conectar();
	}
	
	private static void conectar() {
		
		try {
			if(connection == null) {
				Class.forName("org.postgresql.Driver");/*Carrega o driver de conex�o do banco*/
				connection = DriverManager.getConnection(banco, user, senha);
				connection.setAutoCommit(false);/*para n�o efetuar as altera��es no banco sem nosso comando*/
			}
			
		} catch (Exception e) {
			e.printStackTrace();/*Mostrar qql erro no momento de conectar*/
		}
	
	}
	
}
