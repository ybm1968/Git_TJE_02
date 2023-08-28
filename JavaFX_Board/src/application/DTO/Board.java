package application.DTO;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Board {

	private SimpleIntegerProperty boardNo;
	private SimpleStringProperty title;
	private SimpleStringProperty writer;
	private SimpleStringProperty content;
	private SimpleStringProperty regDate;
	private SimpleStringProperty updDate;
	
	
	// 생성자
	public Board() {
		this("제목없음", "글쓴이없음", "내용없음");
	}

	public Board(String title, String writer, String content) {
		this.title = new SimpleStringProperty(title);
		this.writer = new SimpleStringProperty(writer);
		this.content = new SimpleStringProperty(content);
	}

	
	
	
	public Board(int boardNo, String title, String writer,
			String content, String regDate, String updDate) {
		this.boardNo = new SimpleIntegerProperty(boardNo);
		this.title = new SimpleStringProperty(title);
		this.writer = new SimpleStringProperty(writer);
		this.content = new SimpleStringProperty(content);
		this.regDate = new SimpleStringProperty(regDate);
		this.updDate = new SimpleStringProperty(updDate);
	}

	// getter, setter
	public int getBoardNo() {return boardNo.get();}
	public void setBoardNo(int boardNo) {this.boardNo = new SimpleIntegerProperty(boardNo);}

	public String getTitle() {return title.get();}
	public void setTitle(String title) {this.title = new SimpleStringProperty(title);}

	public String getWriter() {return writer.get();}
	public void setWriter(String writer) {this.writer = new SimpleStringProperty(writer);}

	public String getContent() {return content.get();}
	public void setContent(String content) {this.content = new SimpleStringProperty(content);}

	public String getRegDate() {return regDate.get();}
	public void setRegDate(String regDate) {this.regDate = new SimpleStringProperty(regDate);}

	public String getUpdDate() {return updDate.get();}
	public void setUpdDate(String updDate) {this.updDate = new SimpleStringProperty(updDate);}

	
	// toString
	// : 객체를 출력할 때, 지정한 문자열 형식으로 반환하는 메소드
	// object(최상위클래스)에 정의되어 있으며, 이를 오버라이딩하여 사용한다.
	@Override
	public String toString() {
		return "Board [boardNo=" + boardNo + ", title=" + title + ", writer=" + writer + ", content=" + content
				+ ", regDate=" + regDate + ", updDate=" + updDate + "]";
	}
}
