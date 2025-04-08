package model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
    private String title;
    private boolean available;
    private int numPages;
    
    @ManyToOne
    private Member member;
	
    public Book(){}
	public Book(int id, String title, boolean available, int numPages) {
		super();
		this.id = id;
		this.title = title;
		this.available = available;
		this.numPages = numPages;
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
  
}
