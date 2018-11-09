package com.command;


import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.BoardDAO;
import com.controller.Command;
import com.controller.CommandAction;
import com.dto.itemDTO;


public class BoardModifyUICommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sGnum = request.getParameter("gnum");
		String id = request.getParameter("id");
		System.out.println("보드수정아이디>> "+id);
		int gnum = -1;
		if(sGnum != null) gnum = Integer.valueOf(sGnum);
		
		BoardDAO dao = new BoardDAO();
		HashMap<String, Object> Ito = dao.itemModifyui(gnum,id);
		
		request.setAttribute("Ito", Ito);
		
		
		return new CommandAction(false, "itemModify.jsp");
	}

}
