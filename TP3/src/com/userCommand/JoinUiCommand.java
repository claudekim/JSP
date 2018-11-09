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

		System.out.println("▼▼▼회원가입 눌렀을때 ▶▶▶JoinUiCommand.java");
		System.out.println("join.jsp로 이동");
		System.out.println("▲▲▲작업종료 턴넘김▲▲▲");
      return new CommandAction(false, "join.jsp");
      
   }

}