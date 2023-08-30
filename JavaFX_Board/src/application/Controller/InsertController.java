package application.Controller;

import java.io.IOException;

import application.DTO.Board;
import application.Util.SceneUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class InsertController {

	@FXML
	private TextField contentWrite;

	@FXML
	private TextField titleWrite;

	@FXML
	private Button writeDoneBut;

	@FXML
	private TextField writerWrite;
	
	
	@FXML
	void clickWriteDoneBut(ActionEvent event) throws IOException {
		
		String title = titleWrite.getText();
		String writer = writerWrite.getText();
		String content = contentWrite.getText();
		Board board = new Board(title, writer, content);
		MainController.boardService.insert(board);
		
		// 메인화면으로 이동
		SceneUtil.getInstance().switchScene(event, UI.MAIN.getPath());
	}
	
	

}
