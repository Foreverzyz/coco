package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Util.DBConnect;

public class ReaderLoginAndRegisterDao extends DBConnect {

	public int loginbyidandpsw(String reaid, String password) {
		int status = 0;
		try {
			Connection conn = super.getConnection();
			PreparedStatement pst = null;
			ResultSet rs = null;
			String sql = "select * from reader where readerid=? and password=? and status=1";

			pst = conn.prepareStatement(sql);

			pst.setString(1, reaid);
			pst.setString(2, password);
			rs = pst.executeQuery();
			// while (rs.next()) {
			// if (rpassword.equals(rs.getString(2))) {
			// flag = true;
			// }
			if (rs.next())
				status = rs.getInt("status");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	public int checkbyreaderid(String reaid) {
		int status = 0;
		try {
			Connection conn = super.getConnection();

			String sql = "select * from reader where readerid=? and status";
			PreparedStatement pst = null;
			ResultSet rs = null;
			pst = conn.prepareStatement(sql);

			pst.setString(1, reaid);
			rs = pst.executeQuery();
			// while (rs.next()) {
			// if (rpassword.equals(rs.getString(2))) {
			// flag = true;
			// }
			if (rs.next())
				status = rs.getInt("status");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	//
	// create trigger iii
	//
	// after insert
	// on reader
	// for each row
	// begin
	// declare
	// set status=1;
	// end;
	//
	// create
	// trigger dc
	// before insert on dc
	// for each row begin
	// declare in_sort int(3) default 999 ;
	// set in_sort = (select sort from dc where orgstr=new.orgstr limit 1);
	// set new.sort=in_sort ; end;

	public int addreader(String username, String psw) {
		int status = 0;
		try {
			Connection conn = super.getConnection();

			String sql = "insert into reader(readerid,password,status) values(?,?,1)";
			PreparedStatement pst = null;
			// ResultSet rs = null;
			pst = conn.prepareStatement(sql);

			pst.setString(1, username);
			pst.setString(2, psw);
			pst.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

}
