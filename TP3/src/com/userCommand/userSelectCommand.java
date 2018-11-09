package com.userCommand;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.BoardDAO;
import com.controller.Command;
import com.controller.CommandAction;
import com.dto.thmemberDTO;

public class userSelectCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("▼▼▼자기정보보기 눌렀을때▶▶▶userSelectCommand.java");
		String id = request.getParameter("id");
		System.out.println(id);
		BoardDAO dao = new BoardDAO();
		thmemberDTO dto = dao.userselect(id);
		request.setAttribute("dto", dto);
		System.out.println(dto);
		System.out.println("▲▲▲작업종료 턴넘김▲▲▲");
		return new CommandAction(false, "userSelect.jsp");

	}

}
