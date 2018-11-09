package com.command;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.BoardDAO;
import com.controller.Command;
import com.controller.CommandAction;
import com.dto.qnaDTO;
import com.dto.thmemberDTO;

public class qnaBoardReadCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String sqNum = request.getParameter("qnum");
		int qnum = 0;
		if (sqNum != null)
			qnum = Integer.valueOf(sqNum);

		BoardDAO dao = new BoardDAO();

		thmemberDTO login = (thmemberDTO) request.getSession().getAttribute("login");

		String id = login.getId();

		if (!dao.qnareadToday(id, qnum)) {
			dao.qnainsertread(id, qnum);
			dao.qnareadcntincrease(qnum);
		}
		qnaDTO dto = dao.qnaread(qnum);

		request.setAttribute("dto", dto);

		return new CommandAction(false, "qnaread.jsp");
	}

}
