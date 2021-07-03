package com.bookstore.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bookstore.db.DBContext;
import com.bookstore.entity.Bill;



public class BillDAO {
	
	Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    public List<Bill> getAllBill() {
        List<Bill> list = new ArrayList<>();
        String query = "select * from bill";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Bill(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getDate(4)));
            }
        } catch (Exception e) {
        }
        return list;
    }
    
    public void addBill(int uid,int total, Date date) {
        String query = "INSERT INTO `bill`( `uID`, `total`, `datebuy`) VALUES (?,?,?)";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, uid);
			ps.setInt(2, total);
			ps.setDate(3, date);
	
            ps.executeUpdate();
        } catch (Exception e) {
        }  
    }
    
    public Bill getLast() {
        String query = "SELECT * FROM bill ORDER BY `billID` DESC LIMIT 1";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Bill(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getDate(4));
            }
        } catch (Exception e) {
        }
        return null;
    }
    
}
