package Util;

import java.sql.*;
import java.util.HashMap;
import Util.XmlValidate;
import Util.Xmlparser;

public class DBConnect {
//    private static final String driver = "com.mysql.jdbc.Driver"; 
//
//    private static final String url = "jdbc:mysql://localhost:3306/library?useUnicode=true&characterEncoding=UTF-8&useSSL=false";
//    private static final String username = "root";
//    private static final String password = "root";
//    private static Connection conn = null;

	private static String driver=null;
	private static String url =null;
	private static String user = null ;
	private static String password = null ;
	private static Connection conn = null;
	String xmlPath = "database.conf.xml";
	String xsdPath = "database.conf.xsd"; 
    
    
    
    
    
    static {
    	String xmlPath = "database.conf.xml";
		String xsdPath = "database.conf.xsd"; 
		String base = Thread.currentThread().getContextClassLoader().getResource("").getPath().toString();
		xmlPath = base + xmlPath;
		xsdPath = base + xsdPath;
		if(XmlValidate.validate(xmlPath, xsdPath))
		{
			HashMap<String, String> hm =new HashMap<String, String>();
			hm = Xmlparser.parser(xmlPath);
			driver = hm.get("driver");
			url = hm.get("url");
			user = hm.get("user");
			password = hm.get("password");
        try {
            Class.forName(driver);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    }

    public static Connection getConnection() throws Exception {
        if (conn == null) {
            conn = DriverManager.getConnection(url, user, password);
            return conn;
        }
        return conn;
    }

    public static void close(Connection conn, Statement st, ResultSet rs) {
        try {
            if (conn != null)
                conn.close();
            if (st != null)
                st.close();
            if (rs != null)
                rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static boolean executeSql(String sql) {
        Connection conn = null;
        try {
            conn = getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Statement st = null;
        try {
            st = conn.createStatement();
            return st.executeUpdate(sql) > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(conn, st, null);
        }
        return false;
    }

}