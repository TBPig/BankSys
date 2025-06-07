package banksys.dao;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.ResultSet;

import banksys.model.Account;
import banksys.sqloperation.GetMySQLConnection;

public class AccountDao {

    public static void addAccount(String account_no, int status, String opener_id, int balance, String manager_id) {
        String sql = "INSERT INTO account " +
                "(account_no, status, opener_id, balance, manager_id) " +
                String.format("VALUES ('%s', %d, '%s', %d, '%s');", account_no, status, opener_id, balance, manager_id);
        setInfo(sql);
    }

    public static List<Account> getUserAccount(String user_no) {
        String sql = String.format("select * from account where opener_id='%s'", user_no);
        return getInfoList(sql);
    }

    private static void setInfo(String sql) {
        Connection con = GetMySQLConnection.getConnection();
        try {
            Statement state = con.createStatement();
            state.executeUpdate(sql);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        GetMySQLConnection.closeConnection(con);
    }

    @SuppressWarnings("unused")
	private static Account getInfo(String sql) {
        Account account = new Account();
        Connection con = GetMySQLConnection.getConnection();
        try {
            Statement state = con.createStatement();
            ResultSet rs = state.executeQuery(sql);
            if (rs.next()) {
                account.setAccountNo(rs.getString("account_no"));
                account.setStatus(rs.getInt("status"));
                account.setOpenerId(rs.getString("opener_id"));
                account.setBalance(rs.getInt("balance"));
                account.setManagerId(rs.getString("manager_id"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        GetMySQLConnection.closeConnection(con);
        return account;
    }
    
    private static List<Account> getInfoList(String sql) {
    	List<Account> accountList=new ArrayList<Account>();
    	Connection con = GetMySQLConnection.getConnection();
        try {
            Statement state = con.createStatement();
            ResultSet rs = state.executeQuery(sql);
            while (rs.next()) {
            	Account account = new Account();
                account.setAccountNo(rs.getString("account_no"));
                account.setStatus(rs.getInt("status"));
                account.setOpenerId(rs.getString("opener_id"));
                account.setBalance(rs.getInt("balance"));
                account.setManagerId(rs.getString("manager_id"));
                
                accountList.add(account);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        GetMySQLConnection.closeConnection(con);
		return accountList;
	}
}
