package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

import Util.DBConnect;
import Entity.Book;
import Entity.Reader;

public class ReaderSelfDao extends DBConnect{
	
	public ArrayList<Book> getAllBook() {//查询全部书本
		ArrayList<Book> booklist = new ArrayList<Book>();
		BorrowDao ioDao = new BorrowDao();
		try {
			Connection conn = super.getConnection();
			String sql = "select * from book";
			PreparedStatement pst = null;
			ResultSet rs = null;
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				Book book = new Book();
				book.setId(rs.getString("id"));
				book.setName(rs.getString("bookname"));
				book.setAuthor(rs.getString("author"));
				book.setPublisher(rs.getString("publisher"));
				book.setPrice(rs.getInt("price"));
				book.setCategory(rs.getString("category"));
				book.setStore(rs.getInt("store"));
				book.setLend(ioDao.QueryBookNumById(book.getId()));
				book.setRemain(book.getStore() - book.getLend());
				book.setLocation(rs.getString("location"));
				booklist.add(book);
			}
			return booklist;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return booklist;
	}
	
	
	public void EditReader(Reader reader) {//修改读者信息
		try {
			int i = 0;
			Connection conn = super.getConnection();
			PreparedStatement pst = null;
			
//			readerid
//			password
//			name
//		    sex;
//		    status;
//		    mail;
//		    grade;
//		    tel;
//		    classnum;
//		    borrow;

			
			String sql = "update reader set mail=?,tel=?where readerid=?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, reader.getMail());
			pst.setString(2, reader.getTel());
			
			pst.setString(3, reader.getReaderid());
			i = pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
}
//查询读者个人信息
		public Reader QueryReaderById(String id){//id号查询读者
	        Reader reader = new Reader();
	        BorrowDao ioDao = new BorrowDao();
	        Connection conn = null;
	        try {
	            conn = super.getConnection();
	            String sql = "select * from reader where readerid=" + "'" + id + "'";
	            PreparedStatement pst = null;
	            ResultSet rs = null;
	            pst = conn.prepareStatement(sql);
	            rs = pst.executeQuery();
	            while (rs.next()){
	                reader.setName(rs.getString("name"));
	                reader.setSex(rs.getString("sex"));
	                reader.setGrade(rs.getInt("grade"));
	                reader.setClassnum(rs.getInt("classnum"));
	                reader.setBorrow(ioDao.QueryBorrowNumByReaderid(id).size());
	            }
	            return reader;
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return null;
	    }
}