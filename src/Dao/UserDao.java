package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Util.DBConnect;
import Entity.User;

public class UserDao extends DBConnect{


    public String login(User u){
        try {
            Connection conn = super.getConnection();
            String sql = "select password,name from user where user=?";
            PreparedStatement pst = null;
            ResultSet rs = null;
            pst = conn.prepareStatement(sql);
            pst.setString(1, u.getUsername());
            rs = pst.executeQuery();
            if (rs.next()) {
                if (u.getPassword().equals(rs.getString("password"))){
                    u.setName(rs.getString("name"));
                    return "true";
                }
                else{
                    return "false";
                }
            }
            else{
                return "false";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public User queryadminbyname(String s){
        try {
            User u = new User();
            Connection conn = super.getConnection();
            String sql = "select * from user where name=" + "'" + s + "'";
            PreparedStatement pst = null;
            ResultSet rs = null;
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
           if(rs.next()){
               u.setName(rs.getString("name"));
               u.setSex(rs.getString("sex"));
               u.setDepartment(rs.getString("department"));
               u.setTel(rs.getString("tel"));
               return  u;
           }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
