package repository;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import model.Author;

@Dependent
public class AuthorRepository {
    @Inject
    private EntityManager em;

    @Transactional
    public Author createAuthor(Author a) {
        return em.merge(a);
    }

    @Transactional
    public void updateAuthor(Author author) {
        em.merge(author);
    }

    @Transactional
    public Author getAuthorByID(int id) {
        return em.find(Author.class, id);
    }

}
