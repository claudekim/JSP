package com.userCommand;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.BoardDAO;
import com.controller.Command;
import com.controller.CommandAction;
import com.dto.thmemberDTO;

public class userUpdateCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("▼▼▼수정폼에서 완료눌렀을때▶▶▶userUpdateCommand.java");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String sex = request.getParameter("sex");
		String birthday = request.getParameter("birthday");

		BoardDAO dao = new BoardDAO();
		dao.userUpdate(new thmemberDTO(id, pw, name, address, sex, birthday,"U"));

		System.out.println("▲▲▲작업종료 턴넘김▲▲▲");
		return new CommandAction(true, "userSelect.four?id=" + id);
	

	}

}
