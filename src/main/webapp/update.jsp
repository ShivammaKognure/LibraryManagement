<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.librarymodel.LibraryModel"%>
<%@page import="com.libraryDto.LibraryDto" %>
<%@page import="java.util.Date" %>
<%@page import=" java.sql.SQLException"%> 
        <html>

        <head>
            <title>Library Management</title>
           
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
            
        </head>

        <body>

            <header>
                <nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato">
                    <div>
                        <div class="navbar-brand">Library Management </div>
                    </div>

                    <ul class="navbar-nav">
                        <li><a href="<%=request.getContextPath()%>/list" class="nav-link">Books</a></li>
                    </ul>
                </nav>
            </header>
            <br>
            <div class="container col-md-5">
                <div class="card">
                    <div class="card-body">
               
                <form action="EditServlet" method="post">
                        <caption>
                            <h2>  Edit Book</h2>
                        </caption>

                        
                        <%LibraryModel libModel=new LibraryModel(); %>   
                        <%LibraryDto libDto=new LibraryDto(); %>
                        <%String book_id=request.getParameter("book_id");
            			    %>
            			
            			
                    <input type="hidden" name="book_id" value="<%=(book_id)%>" />
                       
                        
                          <label> Book Category</label>
                           
                          <input type="text" value="<%libDto.setBook_category(request.getParameter("book_category")); %>" class="form-control" name="book_category">
                        <br>
                          <label>Book Name </label>
                            
                          <input type="text" value="<% libDto.setBook_name(request.getParameter("book_name"));%>" class="form-control" name="book_name"/>
                           <br>

                          <label> Book Author</label> 
                          
                         <input type="text" value="<%libDto.setBook_author(request.getParameter("book_author"));%>" class="form-control" name="book_author"/>
                         
                             <br>
                        <button type="submit" class="btn btn-success">Save</button>

                        </form>
                    </div>
                </div>
            </div>
        </body>

</html>