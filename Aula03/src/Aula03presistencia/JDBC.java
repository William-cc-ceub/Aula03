package Aula03presistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class JDBC {
	public static void main(String[] args) throws ClassNotFoundException {
		String url = "jdbc:postgresql://localhost:5432/aula03";
		String usuario = "usuario";
		String senha = "s3nh4";
		try {
			Connection conexao = DriverManager.getConnection(url, usuario, senha);
			if (conexao != null) {
				System.out.println("Conexão bem-sucedida!");
			} else {
				System.out.println("Falha na conexão.");
			}
			
			Statement statement = conexao.createStatement();
			String consultaSQL = "SELECT * FROM produto";
			ResultSet resultado =statement.executeQuery(consultaSQL);
			while (resultado.next()) {
				int id = resultado.getInt("id");
				String nome = resultado.getString("nome");
				double preco = resultado.getDouble("preco");
				System.out.println("ID: " + id + ", Nome: " + nome + ", Preço: " + preco);
				
			}
			resultado.close();
			statement.close();
			conexao.close();
		} catch (SQLException e) {
			System.out.println("Erro na conexão com o banco de dados: " +e.getMessage());
			}
			
		}
		
	}

