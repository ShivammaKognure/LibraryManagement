<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.libraryDto.LibraryDto" %>

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
              
               <form action="insert" method="post">
               
                        <caption>
                            <h2>Add New Book</h2>
                        </caption>
                        
                          <label> Book Category</label>
                           
                          <input type="text" value="<c:out value='${libDto.book_category}' />" class="form-control" name="book_category">
                        <br>
                          <label>Book Name </label>
                            
                          <input type="text" value="<c:out value='${libDto.book_name}' />" class="form-control" name="book_name"/>
                           <br>

                          <label> Book Author</label> 
                          
                         <input type="text" value="<c:out value='${libDto.book_author}' />" class="form-control" name="book_author"/>
                         
                             <br>
                        <button type="submit" class="btn btn-success">Save</button>

                        </form>
                    </div>
                </div>
            </div>
        </body>

</html>