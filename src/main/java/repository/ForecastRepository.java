package repository;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import model.client.Forecast;

@Dependent
public class ForecastRepository {
    @Inject
    private EntityManager em;

    @Transactional
    public void saveForecast(Forecast forecast) {
        if (forecast.getId() == null) {
            em.persist(forecast);
        } else {
            em.merge(forecast);
        }

    }
}
