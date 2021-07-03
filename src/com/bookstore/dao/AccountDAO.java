package com.bookstore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bookstore.db.DBContext;
import com.bookstore.entity.Account;


public class AccountDAO {
	Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    public Account login(String user, String pass) {
        String query = "select * from account\n"
                + "where username = ?\n"
                + "and pass = ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Account(rs.getInt(1), rs.getString(2), rs.getString(3), 
                		rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7), rs.getInt(8), rs.getInt(9));
            }
        } catch (Exception e) {
        }
        return null;
    }
    
    public Account checkAccountExist(String user) {
        String query = "select * from account where username = ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, user);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Account(rs.getInt(1), rs.getString(2), rs.getString(3), 
                		rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7), rs.getInt(8), rs.getInt(9));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public void singup(String username, String pass,String email,String fullname,String phone,String address) {
        String query = "INSERT INTO `account`( `username`, `pass`, `email`, `fullname`, `phone`, `address`, `isSell`, `isAdmin`) "
        		+ "	VALUES (?,?,?,?,?,?,0,0)";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, pass);
            ps.setString(3, email);
            ps.setString(4, fullname);
            ps.setString(5, phone);
            ps.setString(6, address);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        
    }
    public List<Account> getAllAccount() {
        List<Account> list = new ArrayList<>();
        String query = "select * from account";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), 
                		rs.getString(6), rs.getString(7), rs.getInt(8), rs.getInt(9)));
            }
        } catch (Exception e) {
        }
        return list;
    }
    
    public void editAccount(String isSell, String isAdmin, String pid) {
        String query = "UPDATE `account` SET `isSell`=?,`isAdmin`=? WHERE `uID`=? ";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, isSell);
            ps.setString(1, isAdmin);
            ps.setString(3, pid);
            ps.executeUpdate();
         
        } catch (Exception e) {
        }
    }
    
//    public static void main(String[] args) {
//        AccountDAO dao = new AccountDAO();
//        Account list = dao.login("admin", "qqq111");
//        
//        System.out.println(list.toString());
//
//
//    }
}
