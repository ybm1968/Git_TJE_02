package application.Util;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class SceneUtil {
    private static SceneUtil instance;
    
    Stage stage;
    Scene scene;
    Parent root;
    FXMLLoader loader;
    
    private SceneUtil() {
        // private 생성자
    }
    
    public static SceneUtil getInstance() {
        if (instance == null) {
            instance = new SceneUtil();
        }
        return instance;
    }

    /**
     * 화면이동 (ActionEvent)
     * @param event
     * @param fxml
     * @throws IOException
     */
    public void switchScene(ActionEvent event, String fxml) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource( fxml ));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
    
    /**
     * 화면이동 (MouseEvent)
     * @param event
     * @param fxml
     * @throws IOException
     */
    public void switchScene(MouseEvent event, String fxml) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource( fxml ));
    	stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    	scene = new Scene(root);
    	stage.setScene(scene);
    	stage.show();
    }
    
    /**
     * 화면 이동 (지정된 root 인스턴스) 
     * @param event
     * @param fxml
     * @param root
     * @throws IOException
     */
    public void switchScene(ActionEvent event, String fxml, Parent root) throws IOException {
    	stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    	scene = new Scene(root);
    	stage.setScene(scene);
    	stage.show();
    }
    
    /**
     * 화면 이동 (지정된 root 인스턴스)
     * @param event
     * @param fxml
     * @param root
     * @throws IOException
     */
    public void switchScene(MouseEvent event, String fxml, Parent root) throws IOException {
    	stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    	scene = new Scene(root);
    	stage.setScene(scene);
    	stage.show();
    }
    
    /**
     * fxml 에 지정된 Controller 가져오기
     * @param fxml
     * @return
     * @throws IOException
     */
    public Object getController(String fxml) throws IOException {
		loader = new FXMLLoader(getClass().getResource(fxml));
		root = loader.load();
		return loader.getController();
    }
    
    /**
     * 프로그램 종료
     * @param event
     */
    public void close(ActionEvent event) {
    	Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("프로그램 종료");
		alert.setHeaderText("프로그램을 종료하시겠습니까?");
		alert.setContentText("프로그램이 종료됩니다.");
		
		if( alert.showAndWait().get() == ButtonType.OK ) {
			System.out.println("프로그램 종료");
			stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			stage.close();
		}
    }
    
    
    /**
     * 프로그램 종료
     * @param event
     */
    public void close(MouseEvent event) {
    	Alert alert = new Alert(AlertType.CONFIRMATION);
    	alert.setTitle("프로그램 종료");
    	alert.setHeaderText("프로그램을 종료하시겠습니까?");
    	alert.setContentText("프로그램이 종료됩니다.");
    	
    	if( alert.showAndWait().get() == ButtonType.OK ) {
    		System.out.println("프로그램 종료");
    		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    		stage.close();
    	}
    }
    
    
    /**
     * 프로그램 종료
     * @param event
     */
    public void close(Stage stage) {
    	Alert alert = new Alert(AlertType.CONFIRMATION);
    	alert.setTitle("프로그램 종료");
    	alert.setHeaderText("프로그램을 종료하시겠습니까?");
    	alert.setContentText("프로그램이 종료됩니다.");
    	
    	if( alert.showAndWait().get() == ButtonType.OK ) {
    		System.out.println("프로그램 종료");
    		stage.close();
    	}
    }
    
    
    /* getter & setter */
	public FXMLLoader getLoader() {
		return loader;
	}

	public void setLoader(FXMLLoader loader) {
		this.loader = loader;
	}

	public Parent getRoot() {
		return root;
	}

	public void setRoot(Parent root) {
		this.root = root;
	}
    
    
}