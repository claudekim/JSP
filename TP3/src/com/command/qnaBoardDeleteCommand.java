package com.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.BoardDAO;
import com.controller.Command;
import com.controller.CommandAction;


public class qnaBoardDeleteCommand implements Command {

	

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("▼▼▼문의글삭제▶▶▶qnaBoardDeleteCommand.java");
		String sgnum = request.getParameter("gnum");
		String id= request.getParameter("id");
		BoardDAO dao = new BoardDAO();
		
		String sqNum = request.getParameter("qnum");
		int qnum = -1;
		int gnum = -1;
		
		if(sqNum != null) qnum = Integer.parseInt(sqNum);
		if(sgnum != null) gnum = Integer.parseInt(sgnum);
		
		if(dao.qnaisroot(qnum)) {
			dao.qnadeleteroot(qnum);
		} else {
			dao.qnadelete(qnum);
		}
		
		
		
		
		
		
		
		
		
		return new CommandAction(true, "itemRead.four?gnum=" + gnum+"&id="+id);
	}

}
