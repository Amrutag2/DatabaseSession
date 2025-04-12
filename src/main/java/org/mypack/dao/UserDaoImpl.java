package org.mypack.dao;
import org.mypack.dbutil.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UserDaoImpl implements UserDao{
	public boolean isValidUser(String username, String password) {
		String query="SELECT * FROM users WHERE username = ? AND password = ? ";
		try(Connection connection = DBUtil.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query)){
			preparedStatement.setString(1,username);
			preparedStatement.setString(2,password);
			
			ResultSet resultSet = preparedStatement.executeQuery();
//			System.out.println("query run");
			return resultSet.next();
			
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean addUser(User user) {
		String query = "Insert into users(username, email, password) values(?,?,?)";
		try(Connection connection = DBUtil.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query)){
				preparedStatement.setString(1,user.getUsername());
				preparedStatement.setString(2,user.getEmail());
				preparedStatement.setString(3,user.getPassword());
				int rows = preparedStatement.executeUpdate();
				System.out.println("User added");
				return rows>0;
				
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}
