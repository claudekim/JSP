package com.command;

import java.io.IOException;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.controller.BoardDAO;
import com.controller.Command;
import com.controller.CommandAction;
import com.dto.qnaPageTO;

public class BoardReadCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String sGmum = request.getParameter("gnum");
		String id = request.getParameter("id");
		System.out.println("보드리드아이디>>"+id);
		int gnum = 0;
		if (sGmum != null)
			gnum = Integer.valueOf(sGmum);

		BoardDAO dao = new BoardDAO();
		HashMap<String, Object> Ito = dao.itemRead(gnum, id);

		String sCurPage = request.getParameter("curPage");
		int curPage = 1;
		if (sCurPage != null)
			curPage = Integer.valueOf(sCurPage);

		qnaPageTO to = dao.qnapage(curPage, gnum);

		request.setAttribute("Ito", Ito);
		System.out.println("보드리드>>" + Ito);
		request.setAttribute("to", to);

		return new CommandAction(false, "itemRead.jsp");

	}

}
