package application.Service;

import java.util.List;

import application.DAO.BoardDAO;
import application.DTO.Board;

public class BoardServiceImpl implements BoardService { // BoardService 인터페이스 구현
	
	private BoardDAO boardDAO = new BoardDAO();

	@Override
	public List<Board> list() {
		List<Board> boardList = (List<Board>)boardDAO.selectList(); // boardDAO.selectList호출. 
		return boardList; // boardDAO.selectList에서 반환된 리스트를 반환
	}

	@Override
	public Board select(int boardNo) {
		Board board = (Board) boardDAO.select(boardNo);
		return board;
	}

	@Override
	public int insert(Board board) {
		int result = boardDAO.insert(board);
		return result;
	}

	@Override 
	public int update(Board board) {
		int result = boardDAO.update(board);
		return result;
	}

	@Override
	public int delete(int boardNo) {
		int result = boardDAO.delete(boardNo);
		return result;
	}

}
