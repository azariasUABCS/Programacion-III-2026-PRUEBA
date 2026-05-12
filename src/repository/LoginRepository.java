package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import config.DatabaseConnection;
import modelos.User;

public class LoginRepository {

	public User login(String correo, String contrasena) {
		
		/*String sql = "SELECT id, email, password FROM users WHERE email = '" 
				+ email + "' AND password = '" + password + "'";*/
		
		String sql = "SELECT id_usuario, correo_electronico, contraseña FROM usuario WHERE correo_electronico = ? AND contraseña = ?";
		
		try (
			Connection conn = DatabaseConnection.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
		){
			
			stmt.setString(1, correo);
			stmt.setString(2, contrasena);
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id_usuario"));
				user.setCorreo(rs.getString("correo_electronico"));
				
				return user;
			}
			
			
		}catch(SQLException ex) {
			ex.printStackTrace();
		}

		return null;
	}
	
}







