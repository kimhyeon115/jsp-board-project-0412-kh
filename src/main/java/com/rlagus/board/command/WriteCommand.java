package com.rlagus.board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rlagus.board.controller.dao.boardDao;

public class WriteCommand implements Command {
	
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		String writer = request.getParameter("writer");
		String sunject = request.getParameter("sunject");
		String content = request.getParameter("content");
		boardDao dao = new boardDao();
		dao.write(writer,sunject,content);
	} 
}
