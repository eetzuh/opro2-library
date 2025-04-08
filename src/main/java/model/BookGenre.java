package model;

public class BookGenre {
	private int id;
	private Genre genre;
	private Book book;
	
	public BookGenre(int id, Genre genre, Book book) {
		super();
		this.id = id;
		this.genre = genre;
		this.book = book;
	}

	public int getId() {
		return id;
	}

	public Genre getGenre() {
		return genre;
	}

	public Book getBook() {
		return book;
	}

	
}
