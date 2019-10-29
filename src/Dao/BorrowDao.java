package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Util.DBConnect;
import Entity.Borrow;

public class BorrowDao extends DBConnect{
    public void borrow(String bookid, String readerid, String time, int borrowday){//
        try {
            int i = 0;
            Connection conn = super.getConnection();
            PreparedStatement pst = null;
            String sql = "insert into borrow (bookid, readerid, service, borrowtime, borrowday, complete)values(?, ?, ?, ?, ?, ?)";
            pst = conn.prepareStatement(sql);
            pst.setString(1, bookid);
            pst.setString(2, readerid);
            pst.setInt(3, -1);
            pst.setString(4, time);
            pst.setInt(5, borrowday);
            pst.setInt(6, 0);
            i = pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public ArrayList<Borrow> getLogList(){//借阅表
        try {
            ArrayList<Borrow> Loglist = new ArrayList<Borrow>();
            BookDao bdao = new BookDao();
            Connection conn = super.getConnection();
            String sql = "select * from borrow";
            PreparedStatement pst = null;
            ResultSet rs = null;
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            String service = null;
            String bookname = null;
            String complete = null;
            while (rs.next()) {
                Borrow log = new Borrow();
                bookname = bdao.QueryBookById(rs.getString("bookid")).getName();
                log.setBookid(rs.getString("bookid") + "  (" + bookname + ")");
                log.setReaderid(rs.getString("readerid"));
                service = (rs.getInt("service") == -1) ?  "借出" : "归还";
                log.setService(service);
                log.setBorrowtime(rs.getString("borrowtime"));
                log.setBorrowday(rs.getInt("borrowday"));
                complete = (rs.getInt("complete") == 0) ? "未归还" : "已归还";
                log.setComplete(complete);
                Loglist.add(log);
            }
            return Loglist;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public int QueryBookNumById(String id){//id号查询借阅表
        int num = 0;
        Connection conn = null;
        try {
            conn = super.getConnection();
            String sql = "select * from borrow where bookid=? and complete=? order by borrowtime";
            PreparedStatement pst = null;
            ResultSet rs = null;
            pst = conn.prepareStatement(sql);
            pst.setString(1, id);
            pst.setInt(2, 0);
            rs = pst.executeQuery();
            rs.last();
            num += rs.getRow();
            return num;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  num;
    }
    
    public ArrayList<Borrow> QueryBorrowNumByReaderid(String id){//id号查询借阅表数目
        int num = 0;
        Connection conn = null;
        ArrayList<Borrow> loglist = new ArrayList<Borrow>();
        String service = null;
        String complete = null;
        try {
            conn = super.getConnection();
            String sql = "select * from borrow where readerid=? and complete=?";
            PreparedStatement pst = null;
            ResultSet rs = null;
            pst = conn.prepareStatement(sql);
            pst.setString(1, id);
            pst.setInt(2, 0);
            rs = pst.executeQuery();
            Borrow log = null;
            while(rs.next()){
                log = new Borrow();
                log.setReaderid(rs.getString("readerid"));
                log.setBookid(rs.getString("bookid"));
                log.setBorrowtime(rs.getString("borrowtime"));
                service = (rs.getInt("service") == -1) ? "借出" : "归还";
                log.setService(service);
                complete = (rs.getInt("complete") == 0) ? "未归还" : "已归还";
                log.setComplete(complete);
                log.setBorrowday(rs.getInt("borrowday"));
                loglist.add(log);
            }
            return loglist;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  null;
    }
    
    public void ReturnBook(String bookid, String readerid, String borrowtime, String returntime){//还书
        int i = 0;
        try {
            Connection conn = super.getConnection();
            PreparedStatement pst = null;
            String sql = "update borrow set complete=1 where bookid=? and readerid=? and service=? and borrowtime=?";
            pst = conn.prepareStatement(sql);
            pst.setString(1, bookid);
            pst.setString(2, readerid);
            pst.setInt(3, -1);
            pst.setString(4, borrowtime);
            i = pst.executeUpdate();
            sql = "insert into borrow (bookid, readerid, service, borrowtime,complete)values(?, ?, ?, ?, ?)";
            pst = conn.prepareStatement(sql);
            pst.setString(1, bookid);
            pst.setString(2, readerid);
            pst.setInt(3, 1);
            pst.setString(4, returntime);
            pst.setInt(5, 1);
            i = pst.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
