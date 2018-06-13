package com.lyq.bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * ��Ʒ���ݿ����
 * @author Li YongQiang
 *
 */

public class BookDao {
	/**
	 * ��ȡ���ݿ�����
	 * @return Connection����
	 */
	public Connection getConnection(){
		// ���ݿ�����
		Connection conn = null;
		try {
			// �������ݿ�������ע�ᵽ����������
			Class.forName("com.mysql.jdbc.Driver");
			// ���ݿ������ַ���
			String url = "jdbc:mysql://localhost:3306/test1";
			// ���ݿ��û���
			String username = "root";
			// ���ݿ�����
			String password = "000000";
			// ����Connection����
			conn = DriverManager.getConnection(url,username,password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// �������ݿ�����
		return conn;
	}
	public List<Book> find(int page){
	
		List<Book> list = new ArrayList<Book>();

		Connection conn = getConnection();
	
		String sql = "select * from tb_books order by name desc limit ?,?";
		try {
			
			PreparedStatement ps = conn.prepareStatement(sql);
	        ps.setInt(1, (page - 1) * Book.PAGE_SIZE);
			ps.setInt(2, Book.PAGE_SIZE);
		
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
			
				Book book = new Book();	        
                book.setId(rs.getInt("id"));
			    book.setName(rs.getString("name"));
				book.setPrice(rs.getInt("Price"));
				book.setBookCount(rs.getInt("bookCount"));
				book.setAuthor(rs.getString("author"));
				
				list.add(book);
			}
		
			rs.close();
	
			ps.close();
	
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public int findCount(){
		
		int count = 0;
	
		Connection conn = getConnection();
	
		String sql = "select count(*) from tb_books";
		try {
	
			Statement stmt = conn.createStatement();
	
			ResultSet rs = stmt.executeQuery(sql);
		
			if(rs.next()){
         	count = rs.getInt(1);
			}
			
			rs.close();
		
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return count;
	}
}
