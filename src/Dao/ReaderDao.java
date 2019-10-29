package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Util.DBConnect;
import Entity.Reader;

public class ReaderDao extends DBConnect{
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
                reader.setStatus(rs.getInt("status"));
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
    
    public ArrayList<Reader> GetAllReader(){//查询所有读者
        ArrayList<Reader> ReaderList = new ArrayList<Reader>();
        Connection conn = null;
        try {
            conn = super.getConnection();
            String sql = "select * from reader";
            PreparedStatement pst = null;
            ResultSet rs = null;
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            Reader reader = null;
            while(rs.next()){
                reader = new Reader();
                reader.setReaderid(rs.getString("readerid"));
                reader.setName(rs.getString("name"));
                reader.setSex(rs.getString("sex"));
                reader.setStatus(rs.getInt("status"));
                reader.setMail(rs.getString("mail"));
                reader.setGrade(rs.getInt("grade"));
                reader.setClassnum(rs.getInt("classnum"));
                reader.setTel(rs.getString("tel"));
                ReaderList.add(reader);
            }
            return ReaderList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public void SetBlackList(String readerid, boolean isblack){//设置读者状态
        int i = 0;
        Connection conn = null;
        String sql = null;
        try {
            conn = super.getConnection();
            PreparedStatement pst = null;
            if(isblack == true)
                sql = "update reader set status=1 where readerid=?";
            else
                sql = "update reader set status=-1 where readerid=?";
            pst = conn.prepareStatement(sql);
            pst.setString(1, readerid);
            i = pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
