package com.lti.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.lti.entity.Product;

public class Dao {
	
	public Product select(int id) {
		Connection conn=null;
		PreparedStatement ps= null;
		ResultSet rs = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "system", "Amitbook34#");
			String sql="select * from tbl_product where id=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			rs=ps.executeQuery();
			if(rs.next()) {
				Product product = new Product();
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setPrice(rs.getDouble("price"));
				
				return product;
			}
			return null;
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		finally {
			try {
				conn.close();
			}
			catch(Exception e) {
				
			}
		}
		
	}
	
	public List<Product> selectAll(){
		Connection conn=null;
		PreparedStatement ps= null;
		ResultSet rs = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "system", "Amitbook34#");
			String sql="select * from tbl_product";
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			
			List<Product> list = new ArrayList<Product>();
			
			while(rs.next()) {
				Product product = new Product();
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setPrice(rs.getDouble("price"));
				
				list.add(product);
			}
				return list;
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		finally {
			try {
				conn.close();
			}
			catch(Exception e) {
				
			}
		}
	}
	
	public void insert(Product product) {
		Connection conn=null;
		PreparedStatement ps= null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "system", "Amitbook34#");
			String sql="insert into tbl_product values(?,?,?)";
			ps=conn.prepareStatement(sql);
			
			ps.setInt(1, product.getId());
			ps.setString(2, product.getName());
			ps.setDouble(3, product.getPrice());
			/*int count = */ps.executeUpdate();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				conn.close();
			}
			catch(Exception e) {
				
			}
		}
	}
}
