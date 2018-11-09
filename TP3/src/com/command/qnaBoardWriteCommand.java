package com.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.BoardDAO;
import com.controller.Command;
import com.controller.CommandAction;
import com.dto.qnaDTO;


public class qnaBoardWriteCommand implements Command {

	

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1. user가 보낸 데이터 가져오기
				//2. dao작업
				//3. 바인딩된 데이터가 있으면 바인딩ㄹ
				//4. 포워딩
				
				
				
				String qtitle = request.getParameter("qtitle");
				String qid = request.getParameter("qid");
				String qcontent = request.getParameter("qcontent");
				String sqgnum = request.getParameter("gnum");
				
				System.out.println("문의쓰기커멘드 = 제목: "+qtitle + "/ 아이디 : " + qid + " / 내용 : " + qcontent + " / sqgnum :  " + sqgnum);
				
				int qgnum = 0;
				if(sqgnum != null) qgnum = Integer.valueOf(sqgnum);
				BoardDAO dao = new BoardDAO();
				
				dao.qnainsert(new qnaDTO(qtitle, qcontent, qid, qgnum));
				
				
				return new CommandAction(true, "itemRead.four?gnum=" + qgnum+"&id="+qid);
	}

}
