package br.com.teste.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.teste.model.Estudante;
import br.com.teste.util.DbUtil;

public class EstudanteDao {

	private Connection connection;

	public EstudanteDao() {

		System.out.println(" ...Construindo EstudanteDao ");

		try {
			connection = DbUtil.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//Incluir estudantes
	public void incluirEstudantes(Estudante estudante) {

		try {

			
			String sql = "insert into Student(id, name, city, phone) values (?, ?, ?, ?)";

			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setInt(1, estudante.getCodigo());
			stmt.setString(2, estudante.getNome());
			stmt.setString(3, estudante.getCidade());
			stmt.setString(4, estudante.getTelefone());

			stmt.executeUpdate();

			stmt.close();
//			connection.close();

			System.out.println(":: Deu certo incluir [DAO]::" + sql);

		} catch (SQLException esql) {
			System.out.println(":: Deu erro:" + esql);
		}

	}

	//Listar estudantes
	public List<Estudante> listarEstudantes() {

		List<Estudante> listaDeEstudantes = new ArrayList<Estudante>();

		try {

			String sql = "SELECT * FROM Student";

			Statement stmt = connection.createStatement();
			ResultSet rset = stmt.executeQuery(sql);

			while (rset.next()) {

				Estudante estudante = new Estudante();

				estudante.setCodigo(rset.getInt("id"));
				estudante.setNome(rset.getString("name"));
				estudante.setCidade(rset.getString("city"));
				estudante.setTelefone(rset.getString("phone"));

				listaDeEstudantes.add(estudante);
				System.out.println("<br>Nome " + estudante);
			}
			System.out.println(":: Deu certo Listar [DAO]::"+sql);

			stmt.close();
//			connection.close();
			
		} catch (SQLException esql) {
			System.out.println(":: Deu erro: " + esql);
			esql.printStackTrace();
		}
		return listaDeEstudantes;
	}

	//Excluir estudantes
	public void excluirEstudantes(Estudante estudante) {

		try {

			
			String sql = "Delete from Student where id=?";

			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setInt(1, estudante.getCodigo());

			stmt.executeUpdate();

			stmt.close();
//			connection.close();

			System.out.println(":: Deu certo excluir [DAO]::" + sql);

		} catch (SQLException esql) {
			System.out.println(":: Deu erro:" + esql);
		}

	}
	//Editar estudantes
	public void editarEstudantes(Estudante estudante) {

		try {

			
			String sql = "Update Student set name=?, city=?, phone=? where id=?";

			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, estudante.getNome());
			stmt.setString(2, estudante.getCidade());
			stmt.setString(3, estudante.getTelefone());
			stmt.setInt(4, estudante.getCodigo());

			stmt.executeUpdate();

			stmt.close();
//			connection.close();

			System.out.println(":: Deu certo editar [DAO]::" + sql);

		} catch (SQLException esql) {
			System.out.println(":: Deu erro:" + esql);
		}

	}

}

