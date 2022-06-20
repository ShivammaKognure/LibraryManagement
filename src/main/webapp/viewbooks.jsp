<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.libraryDao.LibraryDao" %>
<%@page import="java.util.List" %>
<%@page import="com.librarymodel.LibraryModel"%>
        <html>

        <head>
            <title>Library Management</title>
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
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

            <div class="row">
                <!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

                <div class="container">
                    <h3 class="text-center">List of Books</h3>
                    <hr>
                    <div class="container text-left">

                        <a href="<%=request.getContextPath()%>/new" class="btn btn-success">Add New Book</a>
                    </div>
                    <br>
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Book Category</th>
                                <th>Book name</th>
                                <th>Book Author</th>
                                <th>Book Issue</th>
                                <th>Book Return</th>
                                <th>Action</th>
                            </tr>
                        </thead>
                        <tbody>
                        <%LibraryModel libModel=new LibraryModel(); %>   
                        <%List<LibraryDao> list=libModel.selectAllBooks(); %>
                        <%for(LibraryDao l:list){ %>
        
                        
                            <!--   for (Todo todo: todos) {-->
                         
                                <tr>
                                
                                    <td>
                                      <%=l.getBook_id() %>
                                    </td>
                                    <td>
                                     <%=l.getBook_category() %>
                                       
                                    </td>
                                 
                                    
                                    <td>
                                    <%=l.getBook_name() %>
                                        
                                    </td>
                                    <td>
                                    <%=l.getBook_author() %>
                                       
                                    </td>
                                    <td>
                                    <%=l.getBook_issue_date() %>
                                        
                                    </td>
                                    <td>
                                    <%=l.getBook_return_date() %>
                                        
                                    </td>
                                    
                                    <td><a href="update.jsp?book_id=<%=l.getBook_id() %>">Edit</a> &nbsp;&nbsp;&nbsp;&nbsp; <a href="delete?book_id=<%=l.getBook_id() %>">Delete</a></td>
                                </tr>
                                
                                <%} %>
                          
                          
                        </tbody>

                    </table>
                </div>
            </div>
        </body>
</html>