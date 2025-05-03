package model.client;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import model.Book;
import model.Genre;

@Entity
public class BookGenre {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne(cascade = CascadeType.ALL)
	private Genre genre;

	@ManyToOne(cascade = CascadeType.ALL)
	private Book book;

	public BookGenre() {
	}


	public BookGenre(int id, Genre genre, Book book) {
		super();
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

	public void setId(int id) {
		this.id = id;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((genre == null) ? 0 : genre.hashCode());
		result = prime * result + ((book == null) ? 0 : book.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookGenre other = (BookGenre) obj;
		if (id != other.id)
			return false;
		if (genre == null) {
			if (other.genre != null)
				return false;
		} else if (!genre.equals(other.genre))
			return false;
		if (book == null) {
			if (other.book != null)
				return false;
		} else if (!book.equals(other.book))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BookGenre [id=" + id + ", genre=" + genre + ", book=" + book + "]";
	}

}
