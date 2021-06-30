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
	
	
	// 상세조회에 필요한 필드
	private String boardContent;	// 글 내용
	private int memberNo;			// 작성 회원 번호
	private Timestamp modifyDate;	// 마지막 수정일
	private List<Attachment> atList;// 게시글에 첨부된 파일(이미지) 목록
	
	// 삽입 시 필요한 필드 추가
	private int categoryCode;
	
	
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

	public String getBoardContent() {
		return boardContent;
	}

	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public Timestamp getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Timestamp modifyDate) {
		this.modifyDate = modifyDate;
	}

	public List<Attachment> getAtList() {
		return atList;
	}

	public void setAtList(List<Attachment> atList) {
		this.atList = atList;
	}

	public int getCategoryCode() {
		return categoryCode;
	}

	public void setCategoryCode(int categoryCode) {
		this.categoryCode = categoryCode;
	}

	@Override
	public String toString() {
		return "Board [boardNo=" + boardNo + ", boardTitle=" + boardTitle + ", memberName=" + memberName
				+ ", categoryName=" + categoryName + ", readCount=" + readCount + ", createDate=" + createDate
				+ ", filePath=" + filePath + ", fileName=" + fileName + ", boardContent=" + boardContent + ", memberNo="
				+ memberNo + ", modifyDate=" + modifyDate + ", atList=" + atList + ", categoryCode=" + categoryCode
				+ "]";
	}
	
	
}
