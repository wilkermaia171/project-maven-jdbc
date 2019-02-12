package dao;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conexaojdbc.SingleConnection;
import model.BeanUserFone;
import model.Telefone;
import model.UserJava;

public class UserJavaDao {

	private static Connection connection;

	public UserJavaDao() {

		connection = SingleConnection.getConnection();

	}

	public void salvar(UserJava userjava) {
		try {
			String sql = "insert into userjava (nome, email) values(?, ?)";
			PreparedStatement insert = connection.prepareStatement(sql);
			insert.setString(1, userjava.getNome());
			insert.setString(2, userjava.getEmail());
			insert.execute();// executa a gravação na tabela user java
			connection.commit();// se tudo ok grava os dados
			System.out.println("Salvo com sucesso!");

		} catch (Exception e) {

			try {
				// se ocorrer algum erro volta ao estado anterior
				connection.rollback();

			} catch (SQLException e1) {

				e1.printStackTrace();

			}

			e.printStackTrace();

		}

	}

	// lista para consulta de tabela userjava
	public List<UserJava> listar() throws Exception {

		List<UserJava> list = new ArrayList<UserJava>();

		String sql = "select*from userjava";

		try {

			PreparedStatement statement = connection.prepareStatement(sql);

			ResultSet resultado = statement.executeQuery();

			while (resultado.next()) {

				UserJava userjava = new UserJava();
				userjava.setId(resultado.getLong("id"));
				userjava.setNome(resultado.getString("nome"));
				userjava.setEmail(resultado.getString("email"));
				list.add(userjava);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;

	}

	public UserJava buscar(Long id) throws Exception {

		UserJava retorno = new UserJava();

		String sql = "select*from userjava where id = " + id;

		PreparedStatement statement = connection.prepareStatement(sql);

		ResultSet resultado = statement.executeQuery();

		while (resultado.next()) {

			retorno.setId(resultado.getLong("id"));
			retorno.setNome(resultado.getString("nome"));
			retorno.setEmail(resultado.getString("email"));

		}

		return retorno;
	}

	public List<BeanUserFone> listarUserFone() throws Exception {

		List<BeanUserFone> beanUserFone = new ArrayList<BeanUserFone>();

		//String sql = "SELECT id, nome, email, numero FROM user_java where id = " + id;
		
		String sql = "SELECT id, nome, email, numero FROM user_java order by id";

		try {

			PreparedStatement statement = connection.prepareStatement(sql);

			ResultSet resultset = statement.executeQuery();

			while (resultset.next()) {

				BeanUserFone userFone = new BeanUserFone();

				userFone.setNome(resultset.getString("nome"));
				userFone.setEmail(resultset.getString("email"));
				userFone.setNumero(resultset.getString("numero"));

				beanUserFone.add(userFone);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return beanUserFone;
	}

	public void atualizar(UserJava userjava) {
		try {
			String sql = "update userjava set nome = ? where id =" + userjava.getId();

			PreparedStatement statement = connection.prepareStatement(sql);
			;
			statement.setString(1, userjava.getNome());

			statement.execute();
			connection.commit();

			System.out.println("Atualizado com sucesso!");

		} catch (Exception e) {
			try {
				connection.rollback();

			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
	}

	public void deletar(Long id) {
		try {
			String sql = "delete from userjava where id = " + id;
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.execute();
			connection.commit();
			System.out.println("Usuário deletado com sucesso");

		} catch (Exception e) {

			try {
				connection.rollback();

			} catch (SQLException e1) {

				e1.printStackTrace();

			}

			e.printStackTrace();

		}

	}

	public void salvarTelefone(Telefone telefone) {

		try {
			String sql = "insert into telefoneuser (numero, usuariopessoa, tipo) values(?, ?, ?)";
			PreparedStatement insert = connection.prepareStatement(sql);
			insert.setString(1, telefone.getNumero());
			insert.setLong(2, telefone.getUsuariopessoa());
			insert.setString(3, telefone.getTipo());
			insert.execute();// executa a gravação na tabela telefoneuser java
			connection.commit();// se tudo ok grava os dados
			System.out.println("Telefone salvo com sucesso!");

		} catch (Exception e) {

			try {
				// se ocorrer algum erro volta ao estado anterior
				connection.rollback();

			} catch (SQLException e1) {

				e1.printStackTrace();

			}

			e.printStackTrace();

		}

	}

	public void deleteFonesPorUser(Long id) {
		try {
			String sqlFone = "delete from telefoneuser where usuariopessoa = " + id;
			String sqlUser = "delete from userjava where id = " + id;

			PreparedStatement preparedStatement = connection.prepareStatement(sqlFone);
			preparedStatement.executeUpdate();
			connection.commit();

			System.out.println("Telefone deletado com sucesso");

			PreparedStatement preparedStatement1 = connection.prepareStatement(sqlUser);
			preparedStatement1.executeUpdate();
			connection.commit();

			System.out.println("Usuário deletado com sucesso");

		} catch (Exception e) {

			try {
				connection.rollback();

			} catch (SQLException e1) {

				e1.printStackTrace();

			}

			e.printStackTrace();

		}

	}
}
