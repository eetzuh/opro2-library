package repository;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import model.Genre;

@Dependent
public class GenreRepository {
    @Inject
    private EntityManager em;

    @Transactional
    public Genre createGenre(Genre g){
        return em.merge(g);
    }

}
