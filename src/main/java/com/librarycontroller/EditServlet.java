package com.librarycontroller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.libraryDto.LibraryDto;
import com.librarymodel.LibraryModel;

/**
 * Servlet implementation class EditServlet
 */
@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 LibraryModel libModel=new LibraryModel();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		//Create LibraryDto obj to transfer data libraryDao
		
			LibraryDto libDto=new LibraryDto();
			int id=Integer.parseInt(request.getParameter("book_id"));
			libDto.setBook_id(id);
			libDto.setBook_category(request.getParameter("book_category"));
			libDto.setBook_name(request.getParameter("book_name"));
			libDto.setBook_author(request.getParameter("book_author"));
			libDto.setBook_issue_date(new Date());
			try {
				int status=libModel.updateBook(libDto);
				 if(status>0){  
					 out.println("Updated Successfully ");
			            response.sendRedirect("viewbooks.jsp");  //redirect to all book list
			        }else{  
			            out.println("Sorry! unable to update record");
			        }
			      } catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			  }
		
			
			
	         
			
	}

}
