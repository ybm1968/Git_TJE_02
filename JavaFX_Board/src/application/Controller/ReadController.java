package application.Controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import application.DAO.BoardDAO;
import application.DTO.Board;
import application.Util.SceneUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ReadController {
	
	@FXML
	private TextArea contentSee;
	@FXML
	private Button delButton11;
	@FXML
	private Button gotolistButton;
	@FXML
	private TextField noSee;
	@FXML
	private TextField regdateSee;
	@FXML
	private TextField titleSee;
	@FXML
	private Button updButton1;
	@FXML
	private TextField upddateSee;
	@FXML
	private TextField writeSee;
	
	static int no;
	
	public void select(int boardNo) {
		no = boardNo;
		Board board = new Board();
//		BoardDAO dao = new BoardDAO();

		System.out.println("select(boardNo)");
		board = MainController.boardService.select(boardNo);
		contentSee.setText(board.getContent());
		writeSee.setText(board.getWriter());
		upddateSee.setText(board.getUpdDate() + "");
		titleSee.setText(board.getTitle());
		regdateSee.setText(board.getRegDate() + "");
		noSee.setText(board.getBoardNo() + "");
	}

	// 수정버튼 클릭
	public void updButton1(ActionEvent event) throws IOException {
		
		// ReadController 가져오고
		// boardNo 넘겨줄 메소드를 호출
		
		SceneUtil.getInstance().switchScene(event, UI.UPDATE.getPath());
	}

	// 삭제버튼 클릭
	public void clickDelButton(ActionEvent event) throws IOException {
		SceneUtil.getInstance().switchScene(event, UI.MAIN.getPath());
	}

	// 목록으로 이동 버튼 클릭
	public void gotolistButton(ActionEvent event) throws IOException {
		SceneUtil.getInstance().switchScene(event, UI.MAIN.getPath());
	}

}