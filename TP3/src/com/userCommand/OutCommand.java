package com.userCommand;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.controller.Command;
import com.controller.CommandAction;

public class OutCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("▼▼▼로그아웃 ▶▶▶OutCommand.java");
		HttpSession session = request.getSession(false);

		if (session != null) {
			session.invalidate();
			System.out.println("셋션이 제거 되었습니다.");
		} else {
			System.out.println("이미 제거된 상태입니다");
		}

		// TODO Auto-generated method stub

		System.out.println("▲▲▲작업종료 턴넘김▲▲▲");
		return new CommandAction(true, "index.jsp");
	}

}
