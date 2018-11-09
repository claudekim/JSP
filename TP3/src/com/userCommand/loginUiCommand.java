package com.userCommand;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.controller.BoardDAO;
import com.controller.Command;
import com.controller.CommandAction;
import com.dto.thmemberDTO;

public class loginUiCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("▼▼▼로그인 눌렀을때 ▶▶▶loginUiCommand.java");
		String userid = request.getParameter("id");
		String userpw = request.getParameter("pw");

		BoardDAO dao = new BoardDAO();
		thmemberDTO login = dao.login(new thmemberDTO(userid, userpw, null));
		if (login != null) {

			HttpSession session = request.getSession();
			session.setAttribute("login", login);


			System.out.println("정보 : " + login);
			System.out.println("셋션 : " + session);
			System.out.println("id  : " + userid);
			System.out.println("pw : " + userpw);
			System.out.println("권한 : "+login.getWho());
			System.out.println("=============");
			System.out.println();
			if(login.getWho().equalsIgnoreCase("U")) dao.visit(login);
			   

			System.out.println("▲▲▲작업종료 턴넘김▲▲▲");
	         return new CommandAction(true, "itemList.four");
	      } else {
	         
	         request.setAttribute("refuse", true);
	 		System.out.println("▲▲▲작업종료 턴넘김▲▲▲");
	         return new CommandAction(false, "index.jsp");
	      }
	}
}