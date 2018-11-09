package com.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.BoardDAO;
import com.controller.Command;
import com.controller.CommandAction;
import com.dto.qnaDTO;


public class qnaBoardReplyUICommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sqNum = request.getParameter("qnum");
		int qnum = -1;
		if(sqNum != null) qnum = Integer.valueOf(sqNum);
		
		BoardDAO dao = new BoardDAO();
		qnaDTO dto = dao.qnareplyui(qnum);
		
		request.setAttribute("dto", dto);
		
		
		return new CommandAction(false, "qnareply.jsp");
	}

}
