package hr.fer.rassus.lab.temperaturemicroservice.service;

import hr.fer.rassus.lab.temperaturemicroservice.entity.TemperatureReadingEntity;
import hr.fer.rassus.lab.temperaturemicroservice.repository.TemperatureReadingRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class TemperatureService {
    private final TemperatureReadingRepository temperatureReadingRepository;

    public TemperatureDto getTemperature() {
        log.info("Received request for temperature reading.");

        int readingId = getCurrentReadingId();

        log.info("Reading ID: {}", readingId);

        Double temperatureValue = temperatureReadingRepository.findById(readingId)
                .map(TemperatureReadingEntity::getReading)
                .orElse(null);

        log.info("Temperature value: {}", temperatureValue);

        return TemperatureDto.fromValue(temperatureValue);
    }

    private int getCurrentReadingId() {
        long brojAktivnihSekundi = System.currentTimeMillis() / (1000 * 60);
        return (int) (brojAktivnihSekundi % 100) + 1;
    }
}
