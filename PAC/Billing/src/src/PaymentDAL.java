package src;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class PaymentDAL {
	private String url = "jdbc:oracle:thin:@//dtcao03l.unix.anz:4422/GTBOP03D";
	private String userName = "opee_owner";
	private String pwd = "Adm_Dev3_OpeeOwn_426";
	public void CreatePaymentHeader(PaymentHeader header) throws SQLException
	{		
		Connection conn = DriverManager.getConnection(url, userName, pwd);
		Statement statement = conn.createStatement();
		String insertStatement = header.getInsertSQL();
		statement.execute(insertStatement);
	}
	
	public void CreatePaymentDetail(PaymentDetail dtl) throws SQLException
	{		
		Connection conn = DriverManager.getConnection(url, userName, pwd);
		Statement statement = conn.createStatement();
		String insertStatement = dtl.getInsertSQL();
		statement.execute(insertStatement);
	}
	public void DeletePaymentDetail(String batchId) throws SQLException{
		Connection conn = DriverManager.getConnection(url, userName, pwd);
		Statement statement = conn.createStatement();
		String deleteStatement = "delete from pay_dtl_rep where dtl_req_id='" + batchId + "'";
		statement.execute(deleteStatement);
		
	}
	
	public void DeletePaymentHeader(String batchId) throws SQLException{
		Connection conn = DriverManager.getConnection(url, userName, pwd);
		Statement statement = conn.createStatement();
		String deleteStatement = "delete from pay_hdr_rep where req_id='" + batchId + "'";
		statement.execute(deleteStatement);
		
	}
}
