package com.librarymodel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import com.libraryDao.LibraryDao;
import com.libraryDto.LibraryDto;

public class LibraryModel {
	
	//constant variables to run sql query
	private static final String INSERT_BOOK_SQL= "insert into library1" + " (id, bcategory, bname, bauthor, issuedate, returndate) values "+" (seq_book.nextval, ?, ?, ?, ?, ?)";
	private static final String SELECT_ALL_BOOKS="select * from library1";
	private static final String DELETE_BOOK_SQL="delete from library1 where id= ? ";
	private static final String UPDATE_BOOK_SQL="update library1 set bcategory = ?,bname = ? ,bauthor= ? ,issuedate= ? ,returndate= ? where id=? ";
	private static final String SELECT_BOOK_BY_ID = "select id,bcategory, bname, bauthor, issuedate, returndate from library1 where id =?";
	
	//to convet date to string
	SimpleDateFormat sdf=new SimpleDateFormat("dd-MMM-yyyy");
	Calendar cl=Calendar.getInstance();
	LibraryDao libDao=new LibraryDao();
	
    // insert book new book
	public int insertBook(LibraryDto libDto) throws SQLException {
		int result=0;
		
		try {
			// call getconnection method to establish connection
			 Connection connection=getConnection();
				
			//get data from LibraryDto to LibraryDao
			
			//libDao.setBook_id(libDto.getBook_id());
			libDao.setBook_category(libDto.getBook_category());
			libDao.setBook_name(libDto.getBook_name());
			libDao.setBook_author(libDto.getBook_author());
			
			//insert issue date in string format using sdf
			
			String currentDate=sdf.format(libDto.getBook_issue_date());
			
			libDao.setBook_issue_date(currentDate);
			
			//insert return date in string format add 5 days
			
			cl.setTime(new Date());
			cl.add(Calendar.DATE, 5);
			String returnDate =sdf.format(cl.getTime());
			
			libDao.setBook_return_date(returnDate);
			
			// Prepared statement parameterized query that gives better performance
			 PreparedStatement st= connection.prepareStatement(INSERT_BOOK_SQL);
			
			st.setString(1, libDao.getBook_category());
			st.setString(2, libDao.getBook_name());
			st.setString(3, libDao.getBook_author());
			st.setString(4, libDao.getBook_issue_date());
			st.setString(5, libDao.getBook_return_date());
				
			 result= st.executeUpdate();  //to execute insert query
             connection.close();
				
		}catch(Exception e) {
			e.printStackTrace();
		//to show exception occur during insert
		}
		return result;    //returns int value 1 or 0
		}
	
	//Update Book details
public int updateBook(LibraryDto libDto) throws SQLException {
		
	int i=0;
		
		try {
			// call getconnection method to establish connection
			 Connection connection=getConnection();
			 
			//get data from LibraryDto to LibraryDao
			libDao.setBook_id(libDto.getBook_id());
			libDao.setBook_category(libDto.getBook_category());
			libDao.setBook_name(libDto.getBook_name());
			libDao.setBook_author(libDto.getBook_author());
			
			//insert issue date in string format using sdf
			
			String currentDate=sdf.format(libDto.getBook_issue_date());
			
			libDao.setBook_issue_date(currentDate);
			
			//insert return date in string format add 5 days
			
			cl.setTime(new Date());
			cl.add(Calendar.DATE, 5);
			String returnDate =sdf.format(cl.getTime());
			
			libDao.setBook_return_date(returnDate);
		
			  PreparedStatement st= connection.prepareStatement(UPDATE_BOOK_SQL);
			
			st.setString(1, libDao.getBook_category());
			st.setString(2, libDao.getBook_name());
			st.setString(3, libDao.getBook_author());
			st.setString(4, libDao.getBook_issue_date());
			st.setString(5, libDao.getBook_return_date());
			st.setInt(6, libDao.getBook_id());
			
             i= st.executeUpdate(); //to execute update query
			
            connection.close();
				
		}catch(Exception e) {
			e.printStackTrace();
			//to show exception occur during update
		}
		return i;
		}


//List type method
public List<LibraryDao> selectAllBooks() {
	List<LibraryDao> listBooks=new ArrayList<>();

	
	try {
		// call getconnection method to establish connection
		 Connection connection=getConnection();
		  PreparedStatement st= connection.prepareStatement(SELECT_ALL_BOOKS);
	    //ResultSet to store all column value
		  
        ResultSet rs= st.executeQuery();		
        while(rs.next()) {
        	int id=rs.getInt(1);
        	String bcategory=rs.getString(2);
        	String bname=rs.getString(3);
        	String bauthor=rs.getString(4);
        	String issuedate=rs.getString(5);
        	String returndate=rs.getString(6);
        	listBooks.add(new LibraryDao(id, bcategory, bname, bauthor, issuedate, returndate));
        }
        connection.close();
			
	}catch(Exception e) {
		e.printStackTrace();
	  
	}
	return listBooks; //returns list of array type
	}

//delete row
public boolean deleteBook(int id) throws SQLException {
	
	boolean rowDeleted = false ;
	
	try {
		// call getconnection method to establish connection
		 Connection connection=getConnection();
		  PreparedStatement st= connection.prepareStatement(DELETE_BOOK_SQL);
	     
	     st.setInt(1, id);
	     rowDeleted=st.executeUpdate() >0;
	     connection.close();
			
	}catch(Exception e) {
		e.printStackTrace();
	
	}
	return rowDeleted;
	}



	private Connection getConnection() {
		
		Connection connection=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			try {
				connection=DriverManager
						.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","sys");
			
				
				//System.out.println(connection.isClosed());
				
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
			
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return connection;
	}

	

}
