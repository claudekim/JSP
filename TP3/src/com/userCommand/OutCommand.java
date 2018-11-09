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

		System.out.println("����α׾ƿ� ������OutCommand.java");
		HttpSession session = request.getSession(false);

		if (session != null) {
			session.invalidate();
			System.out.println("�¼��� ���� �Ǿ����ϴ�.");
		} else {
			System.out.println("�̹� ���ŵ� �����Դϴ�");
		}

		// TODO Auto-generated method stub

		System.out.println("�����۾����� �ϳѱ����");
		return new CommandAction(true, "index.jsp");
	}

}
