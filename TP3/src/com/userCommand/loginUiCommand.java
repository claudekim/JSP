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
		System.out.println("����α��� �������� ������loginUiCommand.java");
		String userid = request.getParameter("id");
		String userpw = request.getParameter("pw");

		BoardDAO dao = new BoardDAO();
		thmemberDTO login = dao.login(new thmemberDTO(userid, userpw, null));
		if (login != null) {

			HttpSession session = request.getSession();
			session.setAttribute("login", login);


			System.out.println("���� : " + login);
			System.out.println("�¼� : " + session);
			System.out.println("id  : " + userid);
			System.out.println("pw : " + userpw);
			System.out.println("���� : "+login.getWho());
			System.out.println("=============");
			System.out.println();
			if(login.getWho().equalsIgnoreCase("U")) dao.visit(login);
			   

			System.out.println("�����۾����� �ϳѱ����");
	         return new CommandAction(true, "itemList.four");
	      } else {
	         
	         request.setAttribute("refuse", true);
	 		System.out.println("�����۾����� �ϳѱ����");
	         return new CommandAction(false, "index.jsp");
	      }
	}
}