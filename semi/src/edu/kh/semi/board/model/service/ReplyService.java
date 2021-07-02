package edu.kh.semi.board.model.service;

import static edu.kh.semi.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import edu.kh.semi.board.model.dao.ReplyDAO;
import edu.kh.semi.board.model.vo.Reply;


public class ReplyService {
	
	private ReplyDAO dao = new ReplyDAO();

	/** 댓글 목록 조회 Service
	 * @param boardNo 
	 * @return list
	 * @throws Exception
	 */
	public List<Reply> selectList(int boardNo) throws Exception{
		Connection conn = getConnection();
		
		List<Reply> list = dao.selectList(conn, boardNo);
		
		close(conn);
		
		return list;
	}

	/** 댓글 삽입 Service
	 * @param reply
	 * @return result
	 * @throws Exception
	 */
	public int insertReply(Reply reply) throws Exception{
		Connection conn = getConnection();
		
		// 크로스 사이트 스크립팅 방지 처리
		reply.setReplyContent( replaceParameter(reply.getReplyContent()) );
		// 개행 문자 변경
		reply.setReplyContent( reply.getReplyContent().replaceAll("(\r\n|\r|\n|\n\r)", "<br>")  );
		
		int result = dao.insertReply(conn, reply);
		
		if(result > 0) 	commit(conn);
		else			rollback(conn);
		
		close(conn);
		
		return result;
	}

	/** 댓글 수정 Service
	 * @param reply
	 * @return result
	 * @throws Exception
	 */
	public int updateReply(Reply reply) throws Exception{
		
		Connection conn = getConnection();
		
		// 크로스 사이트 스크립팅 방지 처리
		reply.setReplyContent( replaceParameter(reply.getReplyContent()) );
		// 개행 문자 변경
		reply.setReplyContent( reply.getReplyContent().replaceAll("(\r\n|\r|\n|\n\r)", "<br>")  );
		
		
		int result = dao.updateReply(conn, reply);
		
		if(result > 0) 	commit(conn);
		else			rollback(conn);
		
		close(conn);
		
		return result;
		
	}

	/** 댓글 삭제 Service
	 * @param replyNo
	 * @return result
	 * @throws Exception
	 */
	public int deleteReply(int replyNo) throws Exception{
		Connection conn = getConnection();
		
		int result = dao.deleteReply(conn, replyNo);
		
		if(result > 0) 	commit(conn);
		else			rollback(conn);
		
		close(conn);
		
		return result;
	}

	
	
	
	// 크로스 사이트 스크립트 방지 메소드
	private String replaceParameter(String param) {
		String result = param;
		if(param != null) {
			result = result.replaceAll("&", "&amp;");
			result = result.replaceAll("<", "&lt;");
			result = result.replaceAll(">", "&gt;");
			result = result.replaceAll("\"", "&quot;");
		}
		
		return result;
	}
}








