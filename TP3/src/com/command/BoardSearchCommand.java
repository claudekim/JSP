package com.command;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.controller.BoardDAO;
import com.controller.Command;
import com.controller.CommandAction;
import com.dto.itemDTO;

public class BoardSearchCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String searchName = request.getParameter("searchName");
		String searchValue = request.getParameter("searchValue");

		BoardDAO dao = new BoardDAO();
		ArrayList<itemDTO> searchList = dao.itemSearch(searchName, searchValue);

		request.setAttribute("searchList", searchList);
		return new CommandAction(false, "itemSearch.jsp");
	}

}
