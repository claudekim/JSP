package com.userCommand;

import java.io.IOException;
import java.rmi.ServerException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.controller.BoardDAO;
import com.controller.Command;
import com.controller.CommandAction;
import com.dto.thmemberDTO;

public class JoinCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServerException, IOException {
		
		System.out.println("▼▼▼회원가입완료 눌렀을때 ▶▶▶JoinCommand.java");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String repw = request.getParameter("repw");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String sex = request.getParameter("sex");
		String birthday = request.getParameter("birthday");

		JoinError errors = new JoinError();

		BoardDAO dao = new BoardDAO();
		if (dao.exist(id)) {
			errors.setIDexist(true);
		}
		if (!repw.equals(pw)) {
			errors.setPWdisagree(true);
		}
		if (id == null || id.equals("")) {
			errors.setIdNull(true);
		}
		if (pw == null || pw.equals("")) {
			errors.setPwNull(true);
		}
		if (name == null || name.equals("")) {
			errors.setNameNull(true);
		}
		if (address == null || address.equals("")) {
			errors.setAddressNull(true);
		}
		if (sex == null || (!sex.equalsIgnoreCase("M") && !sex.equalsIgnoreCase("F"))) {
			errors.setSexNull(true);
		}
		if (birthday == null || birthday.equals("")) {
			errors.setBirthdayNull(true);
		}

		if (errors.ExistError()) {
			request.setAttribute("errors", errors);
			request.setAttribute("id", id);
			request.setAttribute("name", name);
			request.setAttribute("address", address);
			System.out.println("▲▲▲작업종료 턴넘김▲▲▲");
			return new CommandAction(false, "join.jsp");
		} else {
			dao.insert(new thmemberDTO(id, pw, name, address, sex, birthday, "U"));

			HttpSession session = request.getSession();
			session.setAttribute("id", id);
			session.setAttribute("pw", pw);
			session.setAttribute("who", "U");
			System.out.println("▲▲▲작업종료 턴넘김▲▲▲");
			return new CommandAction(true, "JoinSuccess.jsp");
		}

	}

}