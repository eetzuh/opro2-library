package repository;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import model.client.PublicHoliday;

@Dependent
public class PublicHolidayRepository {
    @Inject
    private EntityManager em;

    @Transactional
    public void saveHoliday(PublicHoliday holiday) {
        if (holiday.getId() == null) {
            em.persist(holiday);
        } else {
            em.merge(holiday);
        }
    }

}
