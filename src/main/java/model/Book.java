package model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;

@Entity
@NamedQueries({
		@NamedQuery(name = Book.GET_ALL_BOOKS, query = "Select b from Book b"),
})
public class Book {

	public static final String GET_ALL_BOOKS = "Book.getAllBooks";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String title;
	private boolean available;
	private int numPages;

	@ManyToOne
	private Member member;

	public Book() {
	}

	public Book(int id, String title, boolean available, int numPages) {
		super();
		this.id = id;
		this.title = title;
		this.available = available;
		this.numPages = numPages;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + (available ? 1231 : 1237);
		result = prime * result + numPages;
		result = prime * result + ((member == null) ? 0 : member.hashCode());
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
		Book other = (Book) obj;
		if (id != other.id)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (available != other.available)
			return false;
		if (numPages != other.numPages)
			return false;
		if (member == null) {
			if (other.member != null)
				return false;
		} else if (!member.equals(other.member))
			return false;
		return true;
	}

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public boolean isAvailable() {
		return available;
	}

	public int getNumPages() {
		return numPages;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", available=" + available + ", numPages=" + numPages
				+ ", member=" + member + "]";
	}

}
