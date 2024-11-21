package util;

import java.sql.*;

public class DBConnection {
	private static Connection con;

    public void connect() {
        String driver = "oracle.jdbc.driver.OracleDriver";
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String user = "basic";
        String password = "1234";

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);
            if(con != null) {
                System.out.println("DB 연결 성공!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static Connection getConnection() { 
    	return con; 
	}

}
