package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.Renderer;

import connection.SingleConnectionBanco;
import model.ModelLogin;

public class DAOUsuarioRepository {
	
	
	private Connection connection;
	
	public DAOUsuarioRepository() {
		connection = SingleConnectionBanco.getConnection();
	}
	
	public ModelLogin gravarUsuario(ModelLogin objeto) throws Exception {
		
		if(objeto.isNovo()) {	//gravar um novo		
		
		String sql = "INSERT INTO model_login(login, senha,  nome, email) VALUES (?, ?, ?, ?);";
		
		PreparedStatement preparedSql = connection.prepareStatement(sql);
		
		preparedSql.setString(1, objeto.getLogin());
		preparedSql.setString(2, objeto.getSenha());
		preparedSql.setString(3, objeto.getNome());
		preparedSql.setString(4, objeto.getEmail());
		
		preparedSql.execute();
		
		connection.commit();//salvando dados
	}else {
		String sql = "UPDATE model.login SET login=?, senha=?, nome=?, email=? WHERE id =  "+objeto.getId()+";";
		PreparedStatement preparedSql = connection.prepareStatement(sql);
		
		preparedSql.setString(1, objeto.getLogin());
		preparedSql.setString(2, objeto.getSenha());
		preparedSql.setString(3, objeto.getNome());
		preparedSql.setString(4, objeto.getEmail());
		

		preparedSql.executeUpdate();
		
		connection.commit();//salvando dados
		
	}
		
	return this.consultaUsuario(objeto.getLogin());
			
  }
	
	public ModelLogin consultaUsuario(String login) throws Exception{
		
		ModelLogin modelLogin = new ModelLogin();
		
		String sql =  "select * from model_login where upper(login) = upper('" + login + "')";		
		
		PreparedStatement statement = connection.prepareStatement(sql);
				
		ResultSet resultado =statement.executeQuery();		
		
		
		while(resultado.next()) {//Sem tem resultado
			
			modelLogin.setId(resultado.getLong("id"));
			modelLogin.setEmail(resultado.getString("email"));
			modelLogin.setLogin(resultado.getString("login"));
			modelLogin.setSenha(resultado.getString("senha"));
			modelLogin.setNome(resultado.getString("nome"));
			
		}
		
		return modelLogin;
	}
	
	
	// Novo m�todo para verificar se o login j� existe
    public boolean validarLogin(String login) throws SQLException {
    	
        String sql = "SELECT COUNT(1) > 0 as existe from model_login WHERE UPPER(login) = UPPER('" + login +"');";

        PreparedStatement statement = connection.prepareStatement(sql);
       
        ResultSet resultado = statement.executeQuery();

        if (resultado.next()) {
            return resultado.getBoolean("existe");
        }

        return false;
    }
	

}
