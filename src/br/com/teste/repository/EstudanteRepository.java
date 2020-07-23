package br.com.teste.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.teste.model.Estudante;
import br.com.teste.util.DbUtil;

public class EstudanteRepository {

	private Connection connection;

	public EstudanteRepository() {

		try {
			connection = DbUtil.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//Incluir estudantes
	public void incluirEstudantes(Estudante estudante) {

		System.out.println(":: incluirEstudante ::" + estudante);

		try {

			
			String sql = "insert into Student(id, name, city, phone) values (?, ?, ?, ?)";

			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setInt(1, 0);
			stmt.setString(2, estudante.getNome());
			stmt.setString(3, estudante.getCidade());
			stmt.setString(4, estudante.getTelefone());

			stmt.executeUpdate();

			stmt.close();

			connection.close();

			System.out.println(":: Deu certo!! ::" + sql);

		} catch (SQLException esql) {
			System.out.println(":: Deu erro:" + esql);
		}

	}

// listarEstudantes
	public List<Estudante> listarEstudantes() {

		System.out.println(":: listarEstudante :: todos");
		
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
			System.out.println(":: Deu certo!! ::"+sql);

			stmt.close();
			connection.close();
			
		} catch (SQLException esql) {
			System.out.println(":: Deu erro: " + esql);
			esql.printStackTrace();
		}
		return listaDeEstudantes;
	}

}
