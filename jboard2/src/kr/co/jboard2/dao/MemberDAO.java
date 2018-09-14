package kr.co.jboard2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import kr.co.jboard2.utils.DBConfig;
import kr.co.jboard2.utils.SQL;
import kr.co.jboard2.vo.TermsVO;

public class MemberDAO {
	
	// ΩÃ±€≈Ê ∞¥√º
	private static MemberDAO dao = new MemberDAO();
	public static MemberDAO getInstance() {
		return dao;
	}
	
	private MemberDAO() {}

	private Connection conn 		= null;
	private PreparedStatement psmt 	= null;
	private Statement stmt 			= null;
	private ResultSet rs 			= null;
	
	public void login() throws Exception {
	}

	public TermsVO terms() throws Exception {

		TermsVO vo = null;
		
		conn = DBConfig.getConnection();
		stmt = conn.createStatement();
		rs = stmt.executeQuery(SQL.SELECT_TERMS);
		if (rs.next()) {
			vo = new TermsVO();
			vo.setTerms(rs.getString(1));
			vo.setPrivacy(rs.getString(2));
			
		}
		
		DBConfig.close(rs);
		DBConfig.close(stmt);
		DBConfig.close(conn);
		
		return vo;
	}

	public void register() throws Exception {
	}

	public int checkUser(String uid) throws Exception {
		int result = 0;

		conn = DBConfig.getConnection();
		psmt = conn.prepareStatement(SQL.SELECT_CHECK_ID);
		psmt.setString(1, uid);
		
		rs = psmt.executeQuery();
		
		if (rs.next()) {
			result = rs.getInt(1);
		}
		
		DBConfig.close(rs);
		DBConfig.close(psmt);
		DBConfig.close(conn);
		
		return result;
		
		
	}

}
