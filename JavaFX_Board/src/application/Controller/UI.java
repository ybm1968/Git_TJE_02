package application.Controller;

public enum UI {

	MAIN("/application/UI/Main.fxml"),
	INSERT("/application/UI/Insert.fxml"),
	READ("/application/UI/Read.fxml"),
	UPDATE("/application/UI/Update.fxml");

	private final String path;
	
	UI(String path) {
		this.path = path;
	}

	public String getPath() {
		return path;
	}
	
}
