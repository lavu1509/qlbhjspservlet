package com.bookstore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bookstore.db.DBContext;
import com.bookstore.entity.Product;

public class ProductDAO {
	Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    public List<Product> getAllProduct() {
        List<Product> list = new ArrayList<>();
        String query = "select * from product";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                		rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), 
                		rs.getString(6), rs.getString(7),rs.getString(8), rs.getInt(9), rs.getInt(10)));
            }
        } catch (Exception e) {
        }
        return list;
    }
    
    public void deleteProduct(String pid) {
        String query = "delete from product\n"
                + "where pid = ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, pid);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void insertProduct(String name, String image, String price,String author,
            String title, String description,String detail, String pcid, int sid) {
        String query = "INSERT INTO `product`( `pname`, `image`, `price`, `author`, `title`, `description`, `detail`, `cateID`, `sell_ID`) "
        		+ "VALUES (?,?,?,?,?,?,?,?,?)";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, image);
            ps.setString(3, price);
            ps.setString(4, author);
            ps.setString(5, title);
            ps.setString(6, description);
            ps.setString(7, detail);
            ps.setString(8, pcid);
            ps.setInt(9, sid);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void editProduct(String name, String image, String price,String author,
            String title, String description, String detail, String pcid,String pid) {
        String query = "UPDATE `product` SET `pname`= ? ,`image`= ?,`price`= ?,`author`= ?,`title`= ?,`description`= ?,`detail`= ?,`cateID`= ? "
        		+ "WHERE `pid`=?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, image);
            ps.setString(3, price);
            ps.setString(4, author);
            ps.setString(5, title);
            ps.setString(6, description);
            ps.setString(7, detail);
            ps.setString(8, pcid);
            ps.setString(9, pid);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    public List<Product> getTop3() {
        List<Product> list = new ArrayList<>();
        String query = "select top 3 * from product";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                		rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), 
                		rs.getString(6), rs.getString(7),rs.getString(8), rs.getInt(9), rs.getInt(10)));
            }
        } catch (Exception e) {
        }
        return list;
    }
    
    public List<Product> getProductByCID(String cateID) {
        List<Product> list = new ArrayList<>();
        String query = "select * from product\n"
                + "where cateID = ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, cateID);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                		rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), 
                		rs.getString(6), rs.getString(7),rs.getString(8), rs.getInt(9), rs.getInt(10)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Product> getProductBySellID(int id) {
        List<Product> list = new ArrayList<>();
        String query = "select * from product\n"
                + "where sell_ID = ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                		rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), 
                		rs.getString(6), rs.getString(7),rs.getString(8), rs.getInt(9), rs.getInt(10)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Product> searchByName(String txtSearch) {
        List<Product> list = new ArrayList<>();
        String query = "select * from product where `pname` like ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, "%" + txtSearch + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                		rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), 
                		rs.getString(6), rs.getString(7),rs.getString(8), rs.getInt(9), rs.getInt(10)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public Product getProductByID(String id) {
        String query = "SELECT * FROM `product` WHERE `pid`= ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Product(rs.getInt(1),
                		rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), 
                		rs.getString(6), rs.getString(7),rs.getString(8), rs.getInt(9), rs.getInt(10));
            }
        } catch (Exception e) {
        }
        return null;
    }
    
    public int getTotalPagingBySellID(int uid) {
    	String query = "SELECT COUNT(*) FROM product WHERE sell_ID = ?";
    	try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setInt(1, uid);
            rs = ps.executeQuery();
            while(rs.next()) {
            	return rs.getInt(1);
            }
		} catch (Exception e) {
			// TODO: handle exception
		}
    	return 0;
    }
    
    public int getTotalPaging() {
    	String query = "SELECT COUNT(*) FROM product";
    	try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            
            rs = ps.executeQuery();
            while(rs.next()) {
            	return rs.getInt(1);
            }
		} catch (Exception e) {
			// TODO: handle exception
		}
    	return 0;
    }
    
    public List<Product> getProductPaging(int index) {
        List<Product> list = new ArrayList<>();
        String query = "SELECT * FROM product ORDER BY pid LIMIT ? , 6";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setInt(1, (index-1)*6);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                		rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), 
                		rs.getString(6), rs.getString(7),rs.getString(8), rs.getInt(9), rs.getInt(10)));
            }
        } catch (Exception e) {
        }
        return list;
    }
    
    public List<Product> getProductPagingBySellID(int index,int sellid) {
        List<Product> list = new ArrayList<>();
        String query = "SELECT * FROM product WHERE sell_ID = ? ORDER BY pid LIMIT ? , 5";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setInt(1, sellid);
            ps.setInt(2, (index-1)*5);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                		rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), 
                		rs.getString(6), rs.getString(7),rs.getString(8), rs.getInt(9), rs.getInt(10)));
            }
        } catch (Exception e) {
        }
        return list;
    }
    public Product getLast() {
        String query = "SELECT * FROM product ORDER BY `pid` DESC LIMIT 3";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Product(rs.getInt(1),
                		rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), 
                		rs.getString(6), rs.getString(7),rs.getString(8), rs.getInt(9), rs.getInt(10));
            }
        } catch (Exception e) {
        }
        return null;
    }
    
    
    
    public static void main(String[] args) {
        ProductDAO dao = new ProductDAO();
      
        
     int a = dao.getTotalPagingBySellID(1);
        System.out.println(a);
        
    }
}
