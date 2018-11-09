package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.command.BoardDeleteCommand;
import com.command.BoardModifyCommand;
import com.command.BoardModifyUICommand;
import com.command.BoardReadCommand;
import com.command.BoardSearchCommand;
import com.command.BoardWriteCommand;
import com.command.BoardWriteUICommand;
import com.command.itemListCommand;
import com.command.qnaBoardDeleteCommand;
import com.command.qnaBoardModifyCommand;
import com.command.qnaBoardModifyUICommand;
import com.command.qnaBoardReadCommand;
import com.command.qnaBoardReplyCommand;
import com.command.qnaBoardReplyUICommand;
import com.command.qnaBoardSearchCommand;
import com.command.qnaBoardWriteCommand;
import com.command.qnaBoardWriteUICommand;
import com.command.statisticsCommand;
import com.userCommand.JoinCommand;
import com.userCommand.JoinUiCommand;
import com.userCommand.OutCommand;
import com.userCommand.loginUiCommand;
import com.userCommand.userDeleteCommand;
import com.userCommand.userSelectCommand;
import com.userCommand.userUpdateCommand;
import com.userCommand.userUpdateUiCommand;

/**
 * Servlet implementation class BoardFrontController
 */
@WebServlet("*.four")
public class BoardFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BoardFrontController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String dd = request.getRemoteAddr();
		String d = request.getLocalAddr();
		System.out.println("ip : " + dd);
		System.out.println(d);

		String uri = request.getRequestURI();
		String path = request.getContextPath();
		String what = uri.substring(path.length());

		Command com = null;
		
		// �̵��ּ�
		if (what.equalsIgnoreCase("/loginUi.four")) {//�α���
			com = new loginUiCommand();
		}else if (what.equalsIgnoreCase("/out.four")) {//�α׾ƿ�
			com = new OutCommand();
		}else if (what.equalsIgnoreCase("/userSelect.four")) {//�ڱ���������
			com = new userSelectCommand();
		}else if (what.equalsIgnoreCase("/userUpdateUi.four")) {//�ڱ������������̵�
			com = new userUpdateUiCommand();
		}else if (what.equalsIgnoreCase("/userUpdate.four")) {//�ڱ���������
			com = new userUpdateCommand();
		}else if (what.equalsIgnoreCase("/userDelete.four")) {//ȸ��Ż��
			com = new userDeleteCommand();
		}else if (what.equalsIgnoreCase("/joinui.four")) {//ȸ�������������̵�
			com = new JoinUiCommand();
		}else if (what.equalsIgnoreCase("/join.four")) {//ȸ������
			com = new JoinCommand();
		}else if(what.equalsIgnoreCase("/itemList.four")) {//��ǰ����Ʈ
			com = new itemListCommand(); 
		} else if (what.equalsIgnoreCase("/itemRead.four")) {// ��ǰ �󼼺���
			com = new BoardReadCommand();
		} else if (what.equalsIgnoreCase("/itemWriteui.four")) {//��ǰ ��������� �̵�
			com = new BoardWriteUICommand();
		} else if (what.equalsIgnoreCase("/itemWrite.four")) {//��ǰ ���
			com = new BoardWriteCommand();
		} else if (what.equalsIgnoreCase("/itemModifyui.four")) {//��ǰ ��� ����
			com = new BoardModifyUICommand();
		} else if (what.equalsIgnoreCase("/itemModify.four")) {//��ǰ ��� ����
			com = new BoardModifyCommand();
		} else if (what.equalsIgnoreCase("/itemDelete.four")) {//��ǰ ����
			com = new BoardDeleteCommand();
		} else if (what.equalsIgnoreCase("/itemSearch.four")) {//��ǰ �˻�
			com = new BoardSearchCommand(); //
		} else if(what.equalsIgnoreCase("/qnaWriteui.four")) {
			com = new qnaBoardWriteUICommand();
		} else if(what.equalsIgnoreCase("/qnawrite.four")) {
			com = new qnaBoardWriteCommand();
		} else if(what.equalsIgnoreCase("/qnaread.four")) {
			com = new qnaBoardReadCommand();
		} else if(what.equalsIgnoreCase("/qnamodifyui.four")) {
			com = new qnaBoardModifyUICommand();
		} else if(what.equalsIgnoreCase("/qnamodify.four")) {
			com = new qnaBoardModifyCommand();
		} else if(what.equalsIgnoreCase("/qnadelete.four")) {
			com = new qnaBoardDeleteCommand();
		} else if(what.equalsIgnoreCase("/qnasearch.four")) {
			com = new qnaBoardSearchCommand();
		} else if(what.equalsIgnoreCase("/qnareplyui.four")) {
			com = new qnaBoardReplyUICommand();
		} else if(what.equalsIgnoreCase("/qnareply.four")) {
			com = new qnaBoardReplyCommand();
		} else if(what.equalsIgnoreCase("/statistics.four")) {
			com = new statisticsCommand();
		} else if(what.equalsIgnoreCase("/userSelectListUi.four")) {
			com = new userSelectListUiCommand();
		}
		
		
		
		
		if (com != null) {
			CommandAction action = com.execute(request, response);

			if (action.isRedirect()) {
				response.sendRedirect(action.getPath());
			} else {
				RequestDispatcher dis = request.getRequestDispatcher(action.getPath());
				dis.forward(request, response);
			}

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		doGet(request, response);
	}

}
