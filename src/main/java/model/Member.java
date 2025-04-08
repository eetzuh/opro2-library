package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;

@Entity
@NamedQuery(name = Member.GET_MEMBERS_FOR_LIBRARIAN, query = "Select m from Member m where m.librarian.id = :id")

public class Member {

	public static final String GET_MEMBERS_FOR_LIBRARIAN = "Member.getMembersForLibrarian";
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String firstName;
	private String lastName;
	private Date membershipDate;
	private boolean active;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "book_id")
	private List<Book> books;

	@ManyToOne
	private Librarian librarian;

	public Member() {
	}

	public Member(int id, String firstName, String lastName, Date membershipDate, boolean active) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.membershipDate = membershipDate;
		this.active = active;
		this.books = new ArrayList<Book>();
	}

	public int getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public Date getMembershipDate() {
		return membershipDate;
	}

	public boolean isActive() {
		return active;
	}

	public List<Book> getBooks() {
		return books;
	}

}
