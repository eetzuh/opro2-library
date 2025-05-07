package repository;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import model.client.Weather;

@Dependent
public class WeatherRepository {
    @Inject
    private EntityManager em;

    @Transactional
    public void saveWeather(Weather weather) {
        if (weather.getId() == null) {
            em.persist(weather);
        } else {
            em.merge(weather);
        }

    }
}
