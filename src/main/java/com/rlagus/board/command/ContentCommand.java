package com.rlagus.board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rlagus.board.controller.dao.boardDao;
import com.rlagus.board.controller.dto.boardDto;

public class ContentCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		String bnum = request.getParameter("bnum");
		boardDao dao = new boardDao();
		
		boardDto dto = dao.content_view(bnum);
		request.setAttribute("contentDto", dto);
	}

}
