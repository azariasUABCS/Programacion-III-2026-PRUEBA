package repository;

import java.sql.Connection; 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import config.DatabaseConnection;
import modelos.User;
import utils.PasswordUtils;

public class LoginRepository {

	public User login(String correo, String contrasena) {
		
		
		String sql = "SELECT id_usuario, correo_electronico, contraseña, rol, nombre FROM usuario WHERE correo_electronico = ?";
		
		try (
			Connection conn = DatabaseConnection.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
		){
			
			stmt.setString(1, correo);
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) 
			{
				String hashedPassword = rs.getString("contraseña");
				//System.out.println(hashedPassword);
				
				boolean correctPassword = PasswordUtils.checkPassword(contrasena, hashedPassword);
				
				if(!correctPassword) 
					return null;
				
				User user = new User();
				user.setId(rs.getInt("id_usuario"));
				user.setCorreo(rs.getString("correo_electronico"));
				user.setNombre(rs.getString("nombre"));
				user.setRol(rs.getString("rol"));

				return user;
			}
		}
		catch(SQLException ex) 
		{
			ex.printStackTrace();
		}

		return null;
	}
	
	
}







