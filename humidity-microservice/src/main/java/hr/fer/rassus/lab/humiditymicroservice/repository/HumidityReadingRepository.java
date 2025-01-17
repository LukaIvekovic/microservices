package hr.fer.rassus.lab.humiditymicroservice.repository;

import hr.fer.rassus.lab.humiditymicroservice.entity.HumidityReadingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HumidityReadingRepository extends JpaRepository<HumidityReadingEntity, Integer> {
}
