package kr.co.jboard2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kr.co.jboard2.utils.DBConfig;
import kr.co.jboard2.utils.SQL;
import kr.co.jboard2.vo.BoardVO;

public class BoardDAO {

	public static BoardDAO dao = new BoardDAO();

	public static BoardDAO getInstance() {
		return dao;
	}

	private BoardDAO() {}
	
	private Connection conn 		= null;
	private PreparedStatement psmt 	= null;
	private Statement stmt 			= null;
	private ResultSet rs 			= null;
	
	// 게시물 시작 인덱스
	public int getStart(String pg) {
		
		int start = 0;

		if (pg == null) {
			start = 0;
		} else {
			start = (Integer.parseInt(pg) - 1) * 10;
		}
		
		return start;
	}
	
	// 게시물 전체 갯수
	public int getTotalCount() throws Exception {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		int count = 0;

		conn = DBConfig.getConnection();

		stmt = conn.createStatement();
		rs = stmt.executeQuery(SQL.SELECT_COUNT);

		if (rs.next()) {
			count = rs.getInt(1);
		}

		DBConfig.close(rs);
		DBConfig.close(stmt);
		DBConfig.close(conn);

		return count;
	}
	
	// 페이지 계산
		public int getPage(int total) {

			// 페이지 계산
			
			int page = 0; // 전체 글 수

			if (total % 10 == 0) {
				page = total / 10;
			} else {
				page = total / 10 + 1;
			}
			
			return page;
			
		}
	
	public List<BoardVO> list(int idx) throws Exception {
		
		List<BoardVO> arr = new ArrayList<>();
		
		conn = DBConfig.getConnection();
		psmt = conn.prepareStatement(SQL.SELECT_LIST);
		psmt.setInt(1, idx);
		
		rs = psmt.executeQuery();
		
		while(rs.next()) {
			BoardVO vo = new BoardVO();
			vo.setSeq(rs.getInt(1));
			vo.setParent(rs.getInt(2));
			vo.setComment(rs.getInt(3));
			vo.setCate(rs.getString(4));
			vo.setTitle(rs.getString(5));
			vo.setContent(rs.getString(6));
			vo.setFile(rs.getInt(7));
			vo.setHit(rs.getInt(8));
			vo.setUid(rs.getString(9));
			vo.setRegip(rs.getString(10));
			vo.setRdate(rs.getString(11).substring(2, 10));
			vo.setNick(rs.getString(12));
			
			arr.add(vo);
		}
		
		DBConfig.close(rs);
		DBConfig.close(psmt);
		DBConfig.close(conn);
		
		return arr;
		
	}
	
	public void write(BoardVO vo) throws Exception {
		conn = DBConfig.getConnection();
		
		psmt = conn.prepareStatement(SQL.INSERT_BOARD);
		psmt.setString(1, vo.getCate());
		psmt.setString(2, vo.getTitle());
		psmt.setString(3, vo.getContent());
		psmt.setString(4, vo.getUid());
		psmt.setString(5, vo.getRegip());
		
		psmt.executeUpdate();
		
		DBConfig.close(psmt);
		DBConfig.close(conn);
		
	}

	public BoardVO view(String seq) throws Exception {
		BoardVO vo = null;
	
		conn = DBConfig.getConnection();
		
		psmt = conn.prepareStatement(SQL.SELECT_VIEW);
		psmt.setString(1, seq);
		
		ResultSet rs = psmt.executeQuery();
		
		if(rs.next()) {
			vo = new BoardVO();
			
			vo.setSeq(rs.getInt(1));
			vo.setParent(rs.getInt(2));
			vo.setComment(rs.getInt(3));
			vo.setCate(rs.getString(4));
			vo.setTitle(rs.getString(5));
			vo.setContent(rs.getString(6));
			vo.setFile(rs.getInt(7));
			vo.setHit(rs.getInt(8));
			vo.setUid(rs.getString(9));
			vo.setRegip(rs.getString(10));
			vo.setRdate(rs.getString(11));
		}
		
		DBConfig.close(rs);
		DBConfig.close(psmt);
		DBConfig.close(conn);
		
		return vo;
		
	}
	
	public void commentWrite(BoardVO vo) throws Exception {
		conn = DBConfig.getConnection();
		
		psmt = conn.prepareStatement(SQL.INSERT_COMMENT);
		psmt.setInt(1, vo.getParent());
		psmt.setString(2, vo.getCate());
		psmt.setString(3, vo.getContent());
		psmt.setString(4, vo.getUid());
		psmt.setString(5, vo.getRegip());
		
		psmt.executeUpdate();
		
		DBConfig.close(psmt);
		DBConfig.close(conn);
		
	}
	
	public void commentList() throws Exception {}
	
	public void modify() {
		
	}
	
	public void delete() {
		
	}

}
