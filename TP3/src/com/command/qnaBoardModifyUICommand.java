package com.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.BoardDAO;
import com.controller.Command;
import com.controller.CommandAction;
import com.dto.qnaDTO;



public class qnaBoardModifyUICommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. user data acquire
				String sqNum = request.getParameter("qnum");
				int qnum = -1;
				if(sqNum != null) qnum = Integer.valueOf(sqNum);
				
				
				// 2. dao
				BoardDAO dao = new BoardDAO();
				qnaDTO dto = dao.qnamodifyui(qnum);
				
				
				
				// 3. binding
				request.setAttribute("dto", dto);
				
				
				
				// 4. forwarding
				return new CommandAction(false, "qnamodify.jsp");
	}

}
