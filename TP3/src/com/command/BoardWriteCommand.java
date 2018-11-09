package com.command;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.controller.BoardDAO;
import com.controller.Command;
import com.controller.CommandAction;
import com.dto.itemDTO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class BoardWriteCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String fileName = "";
		String orgFileName = "";
		// String uploadPath = "c:"+File.separator+"upload";
		String uploadPath = request.getServletContext().getRealPath("img");
		System.out.println(uploadPath);

		MultipartRequest multi = new MultipartRequest(request, uploadPath, 1024 * 1024 * 10, "euc-kr",
				new DefaultFileRenamePolicy());

		fileName = multi.getFilesystemName("filename1");
		orgFileName = multi.getOriginalFileName("filename1");
		String gtitle = multi.getParameter("gtitle");
		String gcontent = multi.getParameter("gcontent");

		System.out.println(gcontent + "============================");
		/*
		 * request.setAttribute("fileName", fileName);
		 * request.setAttribute("orgFileName", orgFileName);
		 */

		BoardDAO dao = new BoardDAO();
		dao.insertItem(new itemDTO(gtitle, gcontent), fileName);

		return new CommandAction(true, "itemList.four");
	}

}
