package com.librarycontroller;

import java.io.IOException;

import java.sql.SQLException;

import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.libraryDao.LibraryDao;
import com.libraryDto.LibraryDto;
import com.librarymodel.LibraryModel;

/**
 * Servlet implementation class InsertServlet
 */
@WebServlet("/")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       LibraryModel libModel=new LibraryModel();
    
    public InsertServlet() {
       
        this.libModel=new LibraryModel();
    }
    
    /**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	doGet(request, response);
	
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getServletPath();

        try {
            switch (action) {
               case "/new":
                    showNewForm(request, response);
                    break;
                case "/insert":
                    insertBook(request, response);
                    break;
                case "/delete":
                    deleteBook(request, response);
                    break;
                  
                default:
                    listBooks(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
		
	      
		}
	
	
	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
		    throws ServletException, IOException {
		        RequestDispatcher dispatcher = request.getRequestDispatcher("insertbook.jsp");
		        dispatcher.forward(request, response);
		    }
	private void listBooks(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException, ServletException {
		List<LibraryDao> listbook=libModel.selectAllBooks();  
		
		        request.setAttribute("listbook", listbook);
		        RequestDispatcher dispatcher = request.getRequestDispatcher("viewbooks.jsp");
		        dispatcher.forward(request, response);
		    }
		
		
	
	 private void insertBook(HttpServletRequest request, HttpServletResponse response)
			    throws SQLException, IOException {
		              LibraryDto libDto=new LibraryDto();
		              libDto.setBook_category(request.getParameter("book_category"));
		              libDto.setBook_name(request.getParameter("book_name"));
			          libDto.setBook_author(request.getParameter("book_author"));
			          libDto.setBook_issue_date(new Date());
			          libModel.insertBook(libDto); 
			        
			       response.sendRedirect("listbooks");
			    }
	 
	 private void deleteBook(HttpServletRequest request, HttpServletResponse response)
			    throws SQLException, IOException {
			        int id = Integer.parseInt(request.getParameter("book_id"));
			        libModel.deleteBook(id);
			        response.sendRedirect("list");

			    }
	 
	 
}
	


