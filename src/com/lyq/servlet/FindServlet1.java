package com.lyq.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lyq.bean.Book;
import com.lyq.bean.BookDao;

public class FindServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int currPage = 1;
		
		if(request.getParameter("page") != null){
		 currPage = Integer.parseInt(request.getParameter("page"));
		}
	
		BookDao dao = new BookDao();
		List<Book> list = dao.find(currPage);	
		request.setAttribute("list", list);
		
		int pages;
	
		int count = dao.findCount();
	
		if(count % Book.PAGE_SIZE == 0){
				pages = count / Book.PAGE_SIZE;
		}else{
					pages = count / Book.PAGE_SIZE + 1;
		}
		
		StringBuffer sb = new StringBuffer();
	
		for(int i=1; i <= pages; i++){
		
			if(i == currPage){
		
				sb.append("『" + i + "』");
			}else{
			
				sb.append("<a href='FindServlet1?page=" + i + "'>" + i + "</a>");
			}
		
			sb.append("  ");
		}
	
		request.setAttribute("bar", sb.toString());
	
		request.getRequestDispatcher("book_list1.jsp").forward(request, response);
	}

}
