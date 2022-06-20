package com.libraryDao;

public class LibraryDao {
	
	private int   book_id;
	private String book_name;
	private String book_author;
	private String book_category;
	private String book_issue_date;
	private String book_return_date;
	
	
	public LibraryDao(int id, String book_name, String book_author, String book_category,
			String book_issue_date, String book_return_date) {
		super();
		this.book_id = id;
		this.book_name = book_name;
		this.book_author = book_author;
		this.book_category = book_category;
		this.book_issue_date = book_issue_date;
		this.book_return_date = book_return_date;
	}
	
	
	
	
    public LibraryDao() {
		super();
	}
    
	
	
	public int getBook_id() {
		return book_id;
	}
	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	public String getBook_author() {
		return book_author;
	}
	public void setBook_author(String book_author) {
		this.book_author = book_author;
	}
	public String getBook_category() {
		return book_category;
	}
	public void setBook_category(String book_category) {
		this.book_category = book_category;
	}
	public String getBook_issue_date() {
		return book_issue_date;
	}
	public void setBook_issue_date(String book_issue_date) {
		this.book_issue_date = book_issue_date;
	}
	public String getBook_return_date() {
		return book_return_date;
	}
	public void setBook_return_date(String book_return_date) {
		this.book_return_date = book_return_date;
	}
	

}
