package com.command;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.controller.Command;
import com.controller.CommandAction;
import com.controller.BoardDAO;
import com.dto.ItemPageTO;

public class itemListCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sItemCurPage = request.getParameter("itemCurPage");
		int itemCurPage = 1;

		if (sItemCurPage != null)
			itemCurPage = Integer.valueOf(sItemCurPage);

		BoardDAO dao = new BoardDAO();
		ItemPageTO Ito = dao.page(itemCurPage);
		request.setAttribute("Ito", Ito);

		return new CommandAction(false, "saleBoard.jsp");
	}

}
