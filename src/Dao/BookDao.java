package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Util.DBConnect;
import Entity.Book;

public class BookDao extends DBConnect {
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

	public void addtemp(Book book) {//准备添加书本
		try {
			int i = 0;
			Connection conn = super.getConnection();
			PreparedStatement pst = null;
			String sql = "insert into addbook (id, bookname, author, publisher, price, category, store, bookdesc, location)values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
			pst = conn.prepareStatement(sql);
			pst.setString(1, book.getId());
			pst.setString(2, book.getName());
			pst.setString(3, book.getAuthor());
			pst.setString(4, book.getPublisher());
			pst.setInt(5, book.getPrice());
			pst.setString(6, book.getCategory());
			pst.setInt(7, book.getStore());
			pst.setString(8, book.getDesc());
			pst.setString(9, book.getLocation());
			i = pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Book> getadd() {//查询准备添加的书本
		ArrayList<Book> booklist = new ArrayList<Book>();
		try {
			Connection conn = super.getConnection();
			String sql = "select * from addbook";
			PreparedStatement pst = null;
			ResultSet rs = null;
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			Book addbook = null;
			while (rs.next()) {
				addbook = new Book();
				addbook.setPrice(rs.getInt("price"));
				addbook.setCategory(rs.getString("category"));
				addbook.setStore(rs.getInt("store"));
				addbook.setLocation(rs.getString("location"));
				addbook.setId(rs.getString("id"));
				addbook.setName(rs.getString("bookname"));
				addbook.setAuthor(rs.getString("author"));
				addbook.setPublisher(rs.getString("publisher"));
				booklist.add(addbook);
			}
			return booklist;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return booklist;
	}

	public void confirm() {//完成添加书本操作
		try {
			int i = 0;
			Connection conn = super.getConnection();
			PreparedStatement pst = null;
			String sql = "insert into book select * from addbook;";
			pst = conn.prepareStatement(sql);
			i = pst.executeUpdate();
			sql = "truncate table addbook;";
			pst = conn.prepareStatement(sql);
			i = pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void truncatetable() {//清空add表
		int i = 0;
		Connection conn = null;
		try {
			conn = super.getConnection();
			PreparedStatement pst = null;
			String sql = "truncate table addbook;";
			pst = conn.prepareStatement(sql);
			i = pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public Book QueryBookById(String s) {//通过书本id号进行查询
		try {
			BorrowDao ioDao = new BorrowDao();
			Connection conn = super.getConnection();
			String sql = "select * from book where id=" + "'" + s + "'";
			PreparedStatement pst = null;
			ResultSet rs = null;
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			Book book = new Book();
			while (rs.next()) {
				book.setId(rs.getString("id"));
				book.setName(rs.getString("bookname"));
				book.setAuthor(rs.getString("author"));
				book.setPublisher(rs.getString("publisher"));
				book.setPrice(rs.getInt("price"));
				book.setCategory(rs.getString("category"));
				book.setStore(rs.getInt("store"));
				book.setLend(ioDao.QueryBookNumById(book.getId()));
				book.setRemain(book.getStore() - book.getLend());
				book.setDesc(rs.getString("bookdesc"));
				book.setLocation(rs.getString("location"));
			}
			return book;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void DeleteById(String s) {//通过书本id号进行删除
		try {
			int i = 0;
			Connection conn = super.getConnection();
			PreparedStatement pst = null;
			String sql = "delete from book where  id=" + "'" + s + "'";
			pst = conn.prepareStatement(sql);
			i = pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void EditDone(Book book) {//修改书本信息
		try {
			int i = 0;
			Connection conn = super.getConnection();
			PreparedStatement pst = null;
			String sql = "update book set bookname=?,author=?,publisher=?,price=?,category=?,store=?,bookdesc=?,location=? where id=?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, book.getName());
			pst.setString(2, book.getAuthor());
			pst.setString(3, book.getPublisher());
			pst.setInt(4, book.getPrice());
			pst.setString(5, book.getCategory());
			pst.setInt(6, book.getStore());
			pst.setString(7, book.getDesc());
			pst.setString(8, book.getLocation());
			pst.setString(9, book.getId());
			i = pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
