package com.libraryDto;

import java.util.Date;

public class LibraryDto {
	
	private String book_name;
	private int   book_id;
	private String book_author;
	private String book_category;
	private Date book_issue_date;

	
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
	public Date getBook_issue_date() {
		return book_issue_date;
	}
	public void setBook_issue_date(Date date) {
		this.book_issue_date = date;
	}
	
	public int getBook_id() {
		return book_id;
	}
	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
	

	
}
