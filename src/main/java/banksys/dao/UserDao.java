package banksys.dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;

import banksys.model.User;
import banksys.sqloperation.GetMySQLConnection;

public class UserDao {
	
	public static void addUser(String user_no, int status, String name, String password, String owner_id_card) {
		String sql = "INSERT INTO user "+
				"(user_no, status, name, password, owner_id_card) "+
				String.format("VALUES ('%s',%d,'%s','%s','%s');", user_no, status, name, password, owner_id_card);
		setInfo(sql);
	}
	
	public static User getInfoByUserNo(String user_no) {
		String sql = String.format("select * from user where user_no='%s'", user_no);	
		return getInfo(sql);	
	}
	
	public static void setInfo(String sql){
        Connection con = GetMySQLConnection.getConnection();
        try{
            Statement state = con.createStatement();
            state.executeUpdate(sql);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        GetMySQLConnection.closeConnection(con);
    }
	
	public static User getInfo(String sql) {
		User user = new User();
		Connection con = GetMySQLConnection.getConnection();
		try {
			Statement state = con.createStatement();
			ResultSet rs = state.executeQuery(sql);
			if (rs.next()) {
                user.setUserNo(rs.getString("user_no"));
                user.setStatus(rs.getInt("status"));
                user.setName(rs.getString("name"));
                user.setPassword(rs.getString("password"));
                user.setOwnerIdCard(rs.getString("owner_id_card"));
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		GetMySQLConnection.closeConnection(con);
		return user;
	}
}
