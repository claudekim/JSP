package com.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.BoardDAO;
import com.controller.Command;
import com.controller.CommandAction;
import com.dto.qnaDTO;

public class qnaBoardModifyCommand implements Command {


	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BoardDAO dao = new BoardDAO();
		
		String sqNum = request.getParameter("qnum");
		int qnum = -1;
		if(sqNum != null) qnum = Integer.valueOf(sqNum);
		
		String qtitle = request.getParameter("qtitle");
		String qcontent = request.getParameter("qcontent");
		
		System.out.println(qnum +" "+ qtitle +" "+ qcontent);
		
		dao.qnamodify(new qnaDTO(qnum, qtitle, qcontent, null, null, 0, 0, 0, 0, 0));
		
		
		
		
		
		return new CommandAction(true, "qnaread.four?qnum=" + qnum);
	}

}
