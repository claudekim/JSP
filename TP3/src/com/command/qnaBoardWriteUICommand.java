package com.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.Command;
import com.controller.CommandAction;

public class qnaBoardWriteUICommand implements Command {



	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sgnum = request.getParameter("gnum");
		String qid = request.getParameter("qid");
		int gnum = 0;
		if(sgnum != null) gnum = Integer.parseInt(sgnum);
		System.out.println("문의쓰기ui gnum= "+gnum);
		System.out.println("문의쓰기ui qid= "+qid);
		request.setAttribute("gnum", gnum);
		request.setAttribute("qid", qid);
		
		return new CommandAction(false, "qnawrite.jsp");
	}

}
