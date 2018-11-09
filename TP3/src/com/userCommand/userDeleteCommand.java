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

public class userDeleteCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("▼▼▼삭제 눌렀을때▶▶▶userDeleteCommand.java");
		String id = request.getParameter("id");
		System.out.println("지울 ID : " + id);

		HttpSession session = request.getSession(false);
		System.out.println("지울 ID 셋션 : " + session);
		System.out.println("----------------");

		if (session != null) {
			thmemberDTO log = (thmemberDTO) session.getAttribute("login");
			String id2 = log.getId();
			System.out.println(id2);
			System.out.println(id);
			System.out.println("----------------");
			if (id.equals(id2)) {

				BoardDAO dao = new BoardDAO();
				System.out.println(id);
				dao.userDelete(id);
				System.out.println(id);
				System.out.println("삭제완료");
				System.out.println();
				System.out.println("▲▲▲작업종료 턴넘김▲▲▲");
				return new CommandAction(true, "index.jsp");
			} else {
				System.out.println("▲▲▲작업종료 턴넘김▲▲▲");
				System.out.println("같지않내요");
				System.out.println();
				return new CommandAction(true, "index.jsp");
			}
		} else {
			System.out.println("▲▲▲작업종료 턴넘김▲▲▲");
			return new CommandAction(true, "index.jsp");
		}

	}

}
