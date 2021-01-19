package main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import db.DB;

public class AppInsereDados {

	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");
		
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			conn = DB.getConnection();
			st = conn.prepareStatement(
					"INSERT INTO titulos (nome, lancamento, genero) VALUES "
					+ "(?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
			
			st.setString(1, "Harry Potter e a Câmara Secreta");
			st.setDate(2, new java.sql.Date(sdf.parse("2/07/1998").getTime()));
			st.setString(3, "Romance, Bildungsroman, Literatura fantástica, Alta fantasia, Ficção de aventura");
			
			int linhasAlteradas = st.executeUpdate();
			
			if(linhasAlteradas > 0) {
				rs = st.getGeneratedKeys();
				while(rs.next()) {
					int id = rs.getInt(1);	
					System.out.println("Novo id é: " + id);
				}
			} else {
				System.out.println("Nenhuma linha alterada.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} finally {
			DB.closeStatement(st);
			DB.closeResulSet(rs);
			DB.closeConnection();
		}
	}
	
}