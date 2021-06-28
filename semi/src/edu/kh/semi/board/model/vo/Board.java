package edu.kh.semi.board.model.vo;

import java.sql.Timestamp;
import java.util.List;

public class Board {

	private int boardNo;
	private String boardTitle;
	private String memberName;
	private String categoryName;
	private int readCount;	
	private Timestamp createDate;
	
	// 목록 조회 시 하나만 조회되지만,
	// 상세 조회 시 여러 개가 조회 될 수 있기 때문에 List로 선언
	private List<String> filePath;
	private List<String> fileName;
	
	public Board() {}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public int getReadCount() {
		return readCount;
	}

	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public List<String> getFilePath() {
		return filePath;
	}

	public void setFilePath(List<String> filePath) {
		this.filePath = filePath;
	}

	public List<String> getFileName() {
		return fileName;
	}

	public void setFileName(List<String> fileName) {
		this.fileName = fileName;
	}

	@Override
	public String toString() {
		return "Board [boardNo=" + boardNo + ", boardTitle=" + boardTitle + ", memberName=" + memberName
				+ ", categoryName=" + categoryName + ", readCount=" + readCount + ", createDate=" + createDate
				+ ", filePath=" + filePath + ", fileName=" + fileName + "]";
	}
	
}
