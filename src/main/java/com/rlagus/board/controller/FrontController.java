package com.rlagus.board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rlagus.board.command.Command;
import com.rlagus.board.command.ContentCommand;
import com.rlagus.board.command.DeleteCommand;
import com.rlagus.board.command.ListCommand;
import com.rlagus.board.command.WriteCommand;
import com.rlagus.board.controller.dao.boardDao;
import com.rlagus.board.controller.dto.boardDto;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	boardDao dao = new boardDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");	
		// request,response의 값이 인코딩이 UTF-8아니여도 UTF-8로변환시켜줌(한글 깨짐방지)
		
		Command command = null;
		
//		System.out.println(request.getContextPath());
//		System.out.println(request.getRequestURI());
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String comm = uri.substring(conPath.length());		// .do 요청만 빼서 저장
		
		if(comm.equals("/write_form.do")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("writeForm.jsp");
			dispatcher.forward(request, response);
			
		} else if(comm.equals("/write.do")) {
			
			command = new WriteCommand();
			command.execute(request, response);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("list.do");		// "list.jsp"면 안됨
			dispatcher.forward(request, response);
			
		} else if(comm.equals("/list.do")) {
			
			command = new ListCommand();
			command.execute(request, response);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp");
			dispatcher.forward(request, response);
			
		} else if(comm.equals("/content_view.do")) {
			
			command = new ContentCommand();
			command.execute(request, response);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("contentView.jsp");
			dispatcher.forward(request, response);
			
		} else if(comm.equals("/delete.do")) {
			
			command = new DeleteCommand();
			command.execute(request, response);
						
			RequestDispatcher dispatcher = request.getRequestDispatcher("list.do");
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}