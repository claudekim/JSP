package com.userCommand;
import java.io.IOException;

import java.rmi.ServerException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.Command;
import com.controller.CommandAction;


public class JoinUiCommand implements Command {

   @Override
   public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
         throws ServerException, IOException {

		System.out.println("����ȸ������ �������� ������JoinUiCommand.java");
		System.out.println("join.jsp�� �̵�");
		System.out.println("�����۾����� �ϳѱ����");
      return new CommandAction(false, "join.jsp");
      
   }

}