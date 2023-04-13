package com.rlagus.board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rlagus.board.controller.dao.boardDao;

public class DeleteCommand implements Command {
	
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		String bnum = request.getParameter("bnum");
		boardDao dao = new boardDao();
		dao.deletelist(bnum);
	}
}
