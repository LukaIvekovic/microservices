package hr.fer.rassus.lab.temperaturemicroservice.repository;

import hr.fer.rassus.lab.temperaturemicroservice.entity.TemperatureReadingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TemperatureReadingRepository extends JpaRepository<TemperatureReadingEntity, Integer> {
}
