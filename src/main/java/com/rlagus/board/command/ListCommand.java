package com.rlagus.board.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rlagus.board.controller.dao.boardDao;
import com.rlagus.board.controller.dto.boardDto;

public class ListCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		boardDao dao = new boardDao();
		
		ArrayList<boardDto> dtos = dao.list();
		
		request.setAttribute("list", dtos);
	}

}
