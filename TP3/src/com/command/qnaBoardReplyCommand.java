package com.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.BoardDAO;
import com.controller.Command;
import com.controller.CommandAction;
import com.dto.qnaDTO;

public class qnaBoardReplyCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. user data
				String sqNum = request.getParameter("qnum");
				String sRepRoot = request.getParameter("repRoot");
				String sRepStep = request.getParameter("repStep");
				String sRepIndent = request.getParameter("repIndent");
				
			
				int qnum = -1;
				int repRoot = -1;
				int repStep = -1;
				int repIndent = -1;
				
				
				if(sqNum != null) qnum = Integer.valueOf(sqNum);
				if(sRepRoot != null) repRoot = Integer.valueOf(sRepRoot);
				if(sRepStep != null) repStep = Integer.valueOf(sRepStep);
				if(sRepIndent != null) repIndent = Integer.valueOf(sRepIndent);
				
				
				
				String qtitle = request.getParameter("qtitle");
				System.out.println("qna보드리플라이커멘드에서 타이틀 > "+qtitle);
				String qid = request.getParameter("qid");
				System.out.println("qna보드리플라이커멘드에서 큐아이디 > "+qid);
				String qcontent = request.getParameter("qcontent");
				
				
				// 2. dao
				BoardDAO dao = new BoardDAO();
				int qgnum = dao.getgnum(qnum);
				System.out.println(qid);
				System.out.println(qnum);
				int repNum = dao.qnareply(new qnaDTO(qnum, qtitle, qcontent, null, qid, 0, repRoot, repStep, repIndent, qgnum));
				
				// 3. binding
				// 4. forwarding
				return new CommandAction(true, "qnaread.four?qnum=" + repNum);// TODO Auto-generated method stub
	}

}
