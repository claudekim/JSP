package com.command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.BoardDAO;
import com.controller.Command;
import com.controller.CommandAction;
import com.dto.qnaDTO;

public class qnaBoardSearchCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<qnaDTO> qnasearchlist = new ArrayList<>();
		
		String searchName = request.getParameter("searchName");
		String searchValue = request.getParameter("searchValue");
		String sgnum = request.getParameter("gnum");
		
		
		
		int gnum = 0;
		if(sgnum != null) gnum = Integer.parseInt(sgnum); 
		BoardDAO dao = new BoardDAO();
		
		qnasearchlist = dao.qnasearch(searchName, searchValue, gnum);
		
		request.setAttribute("qnasearchlist", qnasearchlist);
		request.setAttribute("gnum", gnum);
		
		
		
		
		
		return new CommandAction(false, "qnasearch.jsp");
	}

}
