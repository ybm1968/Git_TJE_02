package application.Controller;

import java.io.IOException;
import java.net.URL;

import java.util.ResourceBundle;



import application.DTO.Board;
import application.Util.SceneUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class UpdateController implements Initializable {

	@FXML
	private TextArea contentField;
	@FXML
	private TextField titleField;
//	@FXML
//	private Button upddoneButton;
	@FXML
	private TextField writerField;

	Board board = null;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		board = MainController.boardService.select(ReadController.no);
		System.out.println(board);
		contentField.setText(board.getContent());
		titleField.setText(board.getTitle());
		writerField.setText(board.getWriter());
	}

	@FXML
	public void upddoneButton(ActionEvent event) throws IOException {
		String content = contentField.getText();
		String title = titleField.getText();
		String writer = writerField.getText();

		board = new Board(title, writer, content);
		board.setBoardNo( ReadController.no );
		MainController.boardService.update(board);

		SceneUtil.getInstance().switchScene(event, UI.MAIN.getPath());
	}

	

}