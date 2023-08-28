package application.Controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

import application.DAO.BoardDAO;
import application.DTO.Board;
import application.Util.SceneUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class UpdController implements Initializable  {
	Board board;
	BoardDAO dao = new BoardDAO();
	public Connection con;
	public Statement stmt;
	public PreparedStatement psmt;
	public ResultSet rs;
	
    @FXML
    private TextArea contentField;
    @FXML
    private TextField titleField;
    @FXML
    private Button upddoneButton;
    @FXML
    private TextField writerField;
    
    public void upddoneButton(ActionEvent event) throws IOException {
    	String content = contentField.getText();
    	String title = titleField.getText();
    	String writer = writerField.getText();
    	
    	Board updBoard = new Board(title, writer, content);
    	dao.update(updBoard);
    	
    	SceneUtil.getInstance().switchScene(event, UI.MAIN.getPath() );
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		 board = dao.select(ReadController.boardNoo );
	    contentField.setText(board.getContent());
	    titleField.setText(board.getTitle());
	    writerField.setText(board.getWriter());
	}
    

}
