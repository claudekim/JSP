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

public class userUpdateUiCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("▼▼▼수정눌렀을때▶▶▶userUpdateUiCommand.java");

		HttpSession session = request.getSession(false);
		System.out.println("셋션 : " + session);
		String id = request.getParameter("id");

		if (session != null) {
			thmemberDTO login = (thmemberDTO) session.getAttribute("login");
			String id2 = login.getId();

			System.out.println("겟파라로 들어온 ID : " + id + "\n 셋션겟어트리로 데려온 ID :" + id2);
			System.out.println("-----------------------");
			boolean yes = id2.equals(id);
			System.out.println(yes);

			if (id2.equals(id)) {
				System.out.println("ㅇㅇㅇㅇ");
				BoardDAO dao = new BoardDAO();
				thmemberDTO dto = dao.userselect(id);
				request.setAttribute("dto", dto);
				System.out.println("▲▲▲작업종료 턴넘김▲▲▲");
				return new CommandAction(false, "userUpdate.jsp");

			} else {
				System.out.println("x x x x");
				System.out.println();
				session.invalidate();
				System.out.println("▲▲▲작업종료 턴넘김▲▲▲");
				return new CommandAction(true, "index.jsp");
			}

		} else {
			System.out.println("▲▲▲작업종료 턴넘김▲▲▲");
			return new CommandAction(true, "loginForm.do");
		}

	}

}
