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
	Board selectedBoard;
	public Connection con;
	public Statement stmt;
	public PreparedStatement psmt;
	public ResultSet rs;
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
	BoardDAO dao = new BoardDAO();
	private int boardNo;
	static int boardNoo;

	public void select(int boardNo) {
		this.boardNo = boardNo;
		boardNoo = boardNo;
		List<Board> boardList = new ArrayList<Board>();
//		BoardDAO dao = new BoardDAO();

		selectedBoard = dao.select(boardNo);
		contentSee.setText(selectedBoard.getContent());
		writeSee.setText(selectedBoard.getWriter());
		upddateSee.setText(selectedBoard.getUpdDate() + "");
		titleSee.setText(selectedBoard.getTitle());
		regdateSee.setText(selectedBoard.getRegDate() + "");
		noSee.setText(selectedBoard.getBoardNo() + "");
	}

	// 수정버튼 클릭
	public void updButton1(ActionEvent event) throws IOException {
		SceneUtil.getInstance().switchScene(event, UI.INSERT.getPath());
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