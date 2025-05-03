package repository;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import model.Book;
import model.client.BookGenre;

@Dependent
public class BookRepository {
    @Inject
    private EntityManager em;

    @Transactional
    public Book createBook(Book b) {
        return em.merge(b);
    }

    @Transactional
    public BookGenre createBookGenre(BookGenre bg) {
        return em.merge(bg);
    }
}
