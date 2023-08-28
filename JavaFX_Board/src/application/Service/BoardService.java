package application.Service;

import java.util.*;

import application.DTO.Board;

// 게시판 관리를 위한 필요한 리스트에 대한 정리
public interface BoardService {

	// 게시글 목록
	List<Board> list(); // BoardService를 구현한 BoardServiceImple 실행
	
	// 게시글 조회
	Board select(int boarNo);
	
	// 게시글 추가
	int insert(Board board);
	
	// 게시글 수정
	int update(Board board);
	
	// 게시글 삭제
	int delete(int boardNo);
}
