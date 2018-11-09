package com.command;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.BoardDAO;
import com.controller.Command;
import com.controller.CommandAction;
;

public class BoardDeleteCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sGnum = request.getParameter("gnum");
		
		int gnum = -1;
		if(sGnum != null) gnum = Integer.valueOf(sGnum);
		
		BoardDAO dao = new BoardDAO();
		dao.itemDelete(gnum);
		
		return new CommandAction(true, "itemList.four");
	}

}
