package application.DAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import application.DTO.Board;


public class BoardDAO extends JDBConnection {
	
	public List<Board> selectList() {
		// Board타입의 ArrayList 선언
		List<Board> boardList = new ArrayList<Board>();
		
		// SQL
		String sql = " SELECT * "
				   + " FROM board ";
		
		try {
			stmt = con.createStatement();		// 쿼리 실행 객체 생성
			rs = stmt.executeQuery(sql);		// 쿼리 실행 - 결과-->rs (ResultSet)
			
			// 조회 결과를 리스트에 추가
			while( rs.next() ) {				// next() : 실행 결과의 다음 데이터로 이동
				Board board = new Board();
				
				board.setBoardNo( rs.getInt("board_no") );
				board.setTitle( rs.getString("title") );
				board.setWriter( rs.getString("writer") );
				board.setContent( rs.getString("content") );
				board.setRegDate( rs.getString("reg_date") );
				board.setUpdDate( rs.getString("upd_date") );
				
				boardList.add(board);
			}
			
		} catch (SQLException e) {
			System.err.println("게시글 목록 조회 시, 에러 발생");
			e.printStackTrace();
		}		
		return boardList;
	}
	
	// 데이터 조회
	public Board select(int no) {
		Board board = new Board();
		String sql = " SELECT * "
				   + " FROM board "
				   + " WHERE board_no = ? ";
		
		try {
			psmt = con.prepareStatement(sql);		// 쿼리 실행 객체 생성 (PrepareStatement)
			psmt.setInt(1, no);				// ?(1) <-- boardNo(글번호)
			rs = psmt.executeQuery();				// 쿼리 실행

			// 조회 결과 가져오기
			if( rs.next() ) {
				board.setBoardNo( rs.getInt("board_no") );
				board.setTitle( rs.getString("title") );
				board.setWriter( rs.getString("writer") );
				board.setContent( rs.getString("content") );
				board.setRegDate( rs.getString("reg_date") );
				board.setUpdDate( rs.getString("upd_date") );
			}
			
		} catch (SQLException e) {
			System.err.println("게시글 조회 시, 에러 발생");
			e.printStackTrace();
		}
		return board;
	}
	
	// 데이터 등록
	public int insert(Board board) {
		int result = 0;
		
		String sql = " INSERT INTO board( title, writer, content ) "
				   + " VALUES( ?, ?, ? ) ";
	
		try {
			psmt = con.prepareStatement(sql);			// 쿼리 실행 객체 생성
			psmt.setString(1, board.getTitle());			// 1번 ? 에 제목을 매핑
			psmt.setString(2, board.getWriter());		// 2번 ? 에 작성자을 매핑
			psmt.setString(3, board.getContent());		// 3번 ? 에 내용을 매핑
			
			result = psmt.executeUpdate();				// SQL 실행 요청, 적용된 데이터 개수를 받아옴
														// 게시글 1개 쓰기 성공 시, result : 1
														// 				실패 시, result : 0
			// executeUpdate()
			// : SQL (INSERT, UPDATE, DELETE)을 실행하고 적용된 데이터 개수를 int 타입으로 반환
			
		} catch (SQLException e) {
			System.err.println("게시글 등록 시, 에러 발생");
			e.printStackTrace();
		}		
		return result;
	}
	
	// 데이터 수정
	public int update(Board board) {
		
		int result = 0;
		
		String sql = " UPDATE board "
				   + "   SET title = ? "
				   + "   	,writer = ? "
				   + "   	,content = ? "
				   + "   	,upd_date = now() "
				   + " WHERE board_no = ? "
				   ;

		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, board.getTitle());			// 1번 ? 에 제목을 매핑
			psmt.setString(2, board.getWriter());		// 2번 ? 에 작성자을 매핑
			psmt.setString(3, board.getContent());		// 3번 ? 에 내용을 매핑
			psmt.setInt(4, board.getBoardNo());				// 4번 ? 에 게시글 번호를 매핑
			
			result = psmt.executeUpdate();				// SQL 실행 요청, 적용된 데이터 개수를 받아옴
														// 게시글 1개 수정 성공 시, result : 1
														// 				실패 시, result : 0
		} catch (SQLException e) {
			System.err.println("게시글 수정 시, 에러 발생");
			e.printStackTrace();
		}
		return result;
	}

	// 데이터 삭제
	public int delete(int no) {
		int result = 0;
		
		String sql = " DELETE FROM board "
				   + " WHERE board_no = ? ";
		
		try {
			psmt = con.prepareStatement(sql);	// 쿼리 실행 객체 생성
			psmt.setInt(1, no);			// 1번 ? 에 글번호를 매핑
			
			result = psmt.executeUpdate();		// SQL 실행 요청
		} catch (SQLException e) {
			System.err.println("게시글 삭제 시, 에러 발생");
			e.printStackTrace();
		}  		
		return result;
	}

	public List<Board> selectList(int boardNo) {
		return null;
	}
	  
}

















