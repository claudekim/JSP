package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.qnaDTO;
import com.dto.thmemberDTO;

public class userSelectListUiCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		
		thmemberDTO dto = (thmemberDTO)request.getSession().getAttribute("login");
		
		BoardDAO dao = new BoardDAO();
		
		ArrayList<qnaDTO> list = dao.getuserSelectList(dto.getId());

			
		
		request.setAttribute("list", list);
		
		
		return new CommandAction(false, "userSelectList.jsp");
	}

}
