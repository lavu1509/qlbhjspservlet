package com.bookstore.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bookstore.db.DBContext;

import com.bookstore.entity.BillDetail;

public class BillDetailDAO {
	Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    public List<BillDetail> getAllBillDetail(String id) {
        List<BillDetail> list = new ArrayList<>();
        String query = "select * from bill_detail WHERE billID = ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();
 
            while (rs.next()) {
                list.add(new BillDetail(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getInt(5)));
            }
        } catch (Exception e) {
        }
        return list;
    }
    
    public void addBill(int billid,int pid, int quatity, int bprice) {
        String query = "INSERT INTO `bill_detail`( `billID`, `pid`, `quatity`, `bprice`) VALUES (?,?,?,?)";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, billid);
			ps.setInt(2, pid);
			ps.setInt(3, quatity);
			ps.setInt(4, bprice);
		
            ps.executeUpdate();
        } catch (Exception e) {
        }  
    }
    
}
