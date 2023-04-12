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
		// TODO Auto-generated method stub
//		System.out.println(request.getContextPath());
//		System.out.println(request.getRequestURI());
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String comm = uri.substring(conPath.length());		// .do 요청만 빼서 저장
		
		if(comm.equals("/write_form.do")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("writeForm.jsp");
			dispatcher.forward(request, response);
		} else if(comm.equals("/write.do")) {
			String writer = request.getParameter("writer");
			String subject = request.getParameter("sunject");
			String content = request.getParameter("content");
			
			dao.write(writer,subject,content);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("list.do");		// "list.jsp"면 안됨
			dispatcher.forward(request, response);
			
		} else if(comm.equals("/list.do")) {
			ArrayList<boardDto> dtos = dao.list();
			
			request.setAttribute("list", dtos);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp");
			dispatcher.forward(request, response);
		} else if(comm.equals("/content_view.do")) {
			
			String bnum = request.getParameter("bnum");
			
			boardDto dto = dao.content_view(bnum);
			request.setAttribute("contentDto", dto);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("contentView.jsp");
			dispatcher.forward(request, response);
		} else if(comm.equals("/delete.do")) {
			
			String bnum = request.getParameter("bnum");
			dao.deletelist(bnum);
			
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