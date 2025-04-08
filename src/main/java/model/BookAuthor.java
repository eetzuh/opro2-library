package model;

public class BookAuthor {
	private int id;
	private Author author;
	private Book book;
	
	public BookAuthor(int id, Author author, Book book) {
		super();
		this.id = id;
		this.author = author;
		this.book = book;
	}
	
	public int getId() {
		return id;
	}

	public Author getAuthor() {
		return author;
	}

	public Book getBook() {
		return book;
	}

}
