package com.command;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.BoardDAO;
import com.controller.Command;
import com.dto.itemDTO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class BoardModifyCommand implements Command {

	@Override
	public com.controller.CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String fileName = "";
		String orgFileName = "";
		String uploadPath = request.getServletContext().getRealPath("img");
		System.out.println(uploadPath);
		System.out.println(fileName);
		MultipartRequest multi = new MultipartRequest(request, uploadPath, 1024 * 1024 * 10, "euc-kr",
				new DefaultFileRenamePolicy());

		fileName = multi.getFilesystemName("filename1");
		orgFileName = multi.getOriginalFileName("filename1");
		String sGnum = multi.getParameter("gnum");
		String id = multi.getParameter("id");
		int gnum = -1;
		if (sGnum != null)
			gnum = Integer.valueOf(sGnum);
		String gtitle = multi.getParameter("gtitle");
		String gcontent = multi.getParameter("gcontent");
		System.out.println(fileName);
		BoardDAO dao = new BoardDAO();
		itemDTO Ito = new itemDTO(gnum, gtitle, gcontent);
		dao.modify(Ito, fileName);

		return new com.controller.CommandAction(false, "itemRead.four?gnum=" + gnum + "&id=" + id);
	}

}
