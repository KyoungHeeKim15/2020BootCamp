package jdbc;

import java.sql.*;

public class Main {

	public static void main(String[] args) {
		Connection conn = null;
		Statement st = null;
		String url = "jdbc:oracle:thin:@localhost:1522:orcl";
		String user = "SYS as sysdba"; 
		String password = "123412";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, password);
			st = conn.createStatement();
			
			st.execute("TRUNCATE TABLE TEST03.TBL_LT_INF");
			st.executeUpdate("INSERT INTO TEST03.TBL_LT_INF SELECT *  FROM TEST01.TBL_LT_INF");
			
			String sql = "MERGE INTO TEST03.TBL_LT_INF t3 USING TEST02.TBL_LT_INF t2 ON (t3.fa_id = t2.fa_id and t3.lt_id = t2.lt_id and t3.prod_id = t2.prod_id) WHEN NOT MATCHED THEN INSERT(FA_ID,LT_ID,PROD_ID,FL_ID,OP_ID,TIMEKEY,CHG_TM, CRT_TM) values (t2.FA_ID,t2.LT_ID,t2.PROD_ID,t2.FL_ID,t2.OP_ID,t2.TIMEKEY,t2.CHG_TM, t2.CRT_TM)";
			st.executeUpdate(sql);
			/*
			System.out.println("DONE!! ");
			
			ResultSet rs = st.executeQuery("SELECT COUNT(*) FROM TEST03.TBL_LT_INF");
			while(rs.next()) {
				System.out.println(rs.getInt(1));
			}*/
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			try {
				if(st != null) st.close();
				if(conn != null) conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
