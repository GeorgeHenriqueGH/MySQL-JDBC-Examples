package main;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;

public class AppRecuperaDados {

	public static void main(String[] args) {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			conn = DB.getConnection();
			st = conn.createStatement();
			
			rs = st.executeQuery("SELECT * FROM titulos");
			while(rs.next()) {
				System.out.println(rs.getInt("id") + ", " + rs.getString("nome") + 
				", " + rs.getDate("lancamento") + ", " + rs.getString("genero"));
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeStatement(st);
			DB.closeResulSet(rs);
			DB.closeConnection();
		}
	}
	
}
