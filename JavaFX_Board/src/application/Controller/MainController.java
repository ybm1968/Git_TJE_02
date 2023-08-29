package application.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import application.DTO.Board;
import application.Service.BoardService;
import application.Service.BoardServiceImpl;
import application.Util.SceneUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class MainController implements Initializable {

	@FXML
	private TableColumn<Board, Integer> colBoardNo;

	@FXML
	private TableColumn<Board, String> colRegDate;

	@FXML
	private TableColumn<Board, String> colTitle;

	@FXML
	private TableColumn<Board, String> colUpdDate;

	@FXML
	private TableColumn<Board, String> colWriter;

	@FXML
	private TableView<Board> boardTableView;

	@FXML
	private Button writeButton;

	static int index2; // 지우자
	List<Board> boardList = new ArrayList<>();
	static BoardService boardService = new BoardServiceImpl();
	SceneUtil su = SceneUtil.getInstance();

	Stage stage;
	Scene scene;
	Parent root;

	ObservableList<Board> observableList;

	// 게시글 쓰기로 이동
	@FXML
	void clickwriteButton(ActionEvent event) throws IOException {
		SceneUtil.getInstance().switchScene(event, UI.INSERT.getPath());
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		observableList = FXCollections.observableArrayList();

		List<Board> boardList = boardService.list();
		observableList.addAll(boardList);

		colBoardNo.setCellValueFactory(new PropertyValueFactory<>("BoardNo"));
		colTitle.setCellValueFactory(new PropertyValueFactory<>("Title"));
		colWriter.setCellValueFactory(new PropertyValueFactory<>("Writer"));
		colRegDate.setCellValueFactory(new PropertyValueFactory<>("RegDate"));
		colUpdDate.setCellValueFactory(new PropertyValueFactory<>("UpdDate"));

		boardTableView.setItems(observableList);

		boardTableView.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {

				// 더블 클릭 이벤트
				if (event.getClickCount() == 2) {
					stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

					int index = boardTableView.getSelectionModel().getSelectedItem().getBoardNo();
					// Sub 씬을 가져오기
					FXMLLoader loader = new FXMLLoader(getClass().getResource("Read.fxml"));

					try {
						root = loader.load();

					} catch (IOException e) {
						e.printStackTrace();
					}

					ReadController subController = loader.getController();

					if (subController != null) {
						boardService.select(index);
					}
					
					// switchRead(stage, root, "Read.fxml");
					try {
						SceneUtil.getInstance().switchScene(event, UI.READ.getPath(), root);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
				if (event.getClickCount() == 1) {
					index2 = boardTableView.getSelectionModel().getSelectedItem().getBoardNo();

				}
			}

		});

	}

////	@FXML
//	public void boardDelete() {
//		boardDAO.deleteBoard(index2);
//		boardList = boardDAO.boardList();
//
//		observableList = FXCollections.observableArrayList();
//		observableList.addAll(boardList);
//		boardTableView.setItems(observableList);
//	}
//
//	public void switcTohWrite(ActionEvent event) throws IOException {
//		switchScnene(event, "Write.fxml");
//	}
//
//	public void switcTohUpDate(ActionEvent event) throws IOException {
//		switchScnene(event, "UpDate.fxml");
//	}
//
//	public void switchScnene(ActionEvent event, String fxml) throws IOException {
//		Parent root = FXMLLoader.load(getClass().getResource(fxml));
//		scene = new Scene(root);
//		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//		stage.setScene(scene);
//		stage.show();
//	}
//
//	public void switchRead(Stage stage, Parent root, String fxml) {
//		scene = new Scene(root);
//		stage.setScene(scene);
//		stage.show();
//	}
}
